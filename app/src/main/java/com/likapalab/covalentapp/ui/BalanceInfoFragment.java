/*
 * Created by Mehmet Ozdemir on 06.06.2021 19:20
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 19:20
 */

package com.likapalab.covalentapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.likapalab.covalentapp.Constants;
import com.likapalab.covalentapp.R;
import com.likapalab.covalentapp.api.balances.BalanceItem;
import com.squareup.picasso.Picasso;

public class BalanceInfoFragment extends Fragment {

    BalanceItem balance;

    public BalanceInfoFragment() {
        // Required empty public constructor
    }

    public static BalanceInfoFragment newInstance(BalanceItem balance) {
        BalanceInfoFragment fragment = new BalanceInfoFragment();
        fragment.balance = balance;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_balance_info, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        ImageView iconImageView = view.findViewById(R.id.image_view_icon);
        TextView nameTextView = view.findViewById(R.id.text_view_name);
        TextView balanceTextView = view.findViewById(R.id.text_view_balance);
        TextView valueTextView = view.findViewById(R.id.text_view_value);

        Picasso.get().load(balance.getLogoUrl()).into(iconImageView);
        nameTextView.setText(balance.getContractName());
        balanceTextView.setText(String.valueOf(Long.parseLong(balance.getBalance()) / Math.pow(10, 18)));
        valueTextView.setText("$" + balance.getQuote());

        View parentView = view.findViewById(R.id.view_parent);
        ViewTreeObserver viewTreeObserver = parentView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                parentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                broadcastBalanceInfoViewPagerHeight(parentView.getHeight() + (int) getResources().getDimension(R.dimen.margin_small));
            }
        });
    }

    private void broadcastBalanceInfoViewPagerHeight(int height) {
        Intent intent = new Intent();
        intent.setAction(Constants.INTENT_ACTION_BALANCE_INFO_VIEW_PAGER_HEIGHT_RECEIVED);
        intent.putExtra(Constants.INTENT_PARAMETER_VIEW_PAGER_HEIGHT, height);
        getActivity().sendBroadcast(intent);
    }
}