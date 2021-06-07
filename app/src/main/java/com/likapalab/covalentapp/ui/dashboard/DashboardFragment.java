/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:13
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 03.06.2021 22:29
 */

package com.likapalab.covalentapp.ui.dashboard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.likapalab.covalentapp.Constants;
import com.likapalab.covalentapp.R;
import com.likapalab.covalentapp.adapters.BalanceInfoAdapter;
import com.likapalab.covalentapp.adapters.TransactionListAdapter;
import com.likapalab.covalentapp.api.balances.BalanceItem;
import com.likapalab.covalentapp.api.transcation.TransactionItem;

import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    //Class Variables
    private String walletAddress = "0x7A15f704d45AADA83F18ac81b41EaCD48f766E90";
    private BalanceInfoAdapter balanceInfoAdapter;

    //Widgets
    private View progressView;
    private View progressBarView;
    private ViewPager balanceInfoViewPager;
    private RecyclerView transactionRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        walletAddress = getArguments().getString(Constants.INTENT_PARAMETER_WALLET_ADDRESS);
        getActivity().registerReceiver(viewPagerHeightReceiver, new IntentFilter(Constants.INTENT_ACTION_BALANCE_INFO_VIEW_PAGER_HEIGHT_RECEIVED));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(viewPagerHeightReceiver);
    }

    private final BroadcastReceiver viewPagerHeightReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra(Constants.INTENT_PARAMETER_VIEW_PAGER_HEIGHT)) {
                int viewPagerHeight = intent.getIntExtra(Constants.INTENT_PARAMETER_VIEW_PAGER_HEIGHT, 0);
                if (balanceInfoViewPager != null) {
                    balanceInfoViewPager.getLayoutParams().height = viewPagerHeight;
                    balanceInfoViewPager.requestLayout();
                }
            }
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        init(root);
        return root;
    }

    private void init(View view) {
        progressView = view.findViewById(R.id.view_progress);
        progressBarView = view.findViewById(R.id.view_progress_bar);

        balanceInfoViewPager = view.findViewById(R.id.view_pager);
        balanceInfoViewPager.setPageMargin((int) getResources().getDimension(R.dimen.margin_large));
        transactionRecyclerView = view.findViewById(R.id.recycler_view_transactions);

        view.findViewById(R.id.image_view_back).setOnClickListener(view1 -> getActivity().onBackPressed());

        dashboardViewModel.getOnProgress().observe(getViewLifecycleOwner(), aBoolean -> onProgress(aBoolean));

        dashboardViewModel.getBalances(walletAddress, getString(R.string.covalent_services_api_key));
        dashboardViewModel.getBalanceResponse().observe(getViewLifecycleOwner(), balanceResponse -> {
            initBalances(balanceResponse.getData().getItems());
        });

        dashboardViewModel.getTransactions(walletAddress, getString(R.string.covalent_services_api_key));
        dashboardViewModel.getTransactionsResponse().observe(getViewLifecycleOwner(), transactionsResponse -> {
            initTransactionList(transactionsResponse.getData().getNextUpdateAt(), transactionsResponse.getData().getItems());
        });
    }

    private void initBalances(List<BalanceItem> balanceItemList) {
        getActivity().runOnUiThread(() -> {
            balanceInfoViewPager.removeAllViews();

            balanceInfoAdapter = new BalanceInfoAdapter(getActivity().getSupportFragmentManager(), balanceItemList);
            balanceInfoViewPager.setAdapter(balanceInfoAdapter);
            balanceInfoAdapter.notifyDataSetChanged();
            balanceInfoViewPager.clearOnPageChangeListeners();
            balanceInfoViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        });
    }

    private void initTransactionList(String updatedAt, List<TransactionItem> transactionList) {
        TransactionListAdapter transactionListAdapter = new TransactionListAdapter(walletAddress, updatedAt, transactionList);
        transactionRecyclerView.setItemAnimator(new DefaultItemAnimator());
        transactionRecyclerView.setAdapter(transactionListAdapter);
    }

    private void onProgress(boolean isVisible) {
        if (isVisible) {
            progressView.setVisibility(View.VISIBLE);
            progressBarView.setVisibility(View.VISIBLE);
        } else {
            progressView.setVisibility(View.GONE);
            progressBarView.setVisibility(View.GONE);
        }
    }
}