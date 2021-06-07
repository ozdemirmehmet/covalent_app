/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:13
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 03.06.2021 23:40
 */

package com.likapalab.covalentapp.ui.home;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.likapalab.covalentapp.Constants;
import com.likapalab.covalentapp.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    //Widgets
    private ImageView iconImageView;
    private View addressView;
    private EditText walletAddressEditText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        init(root);
        return root;
    }

    private void init(View view) {
        iconImageView = view.findViewById(R.id.image_view_icon);
        addressView = view.findViewById(R.id.view_address);
        walletAddressEditText = view.findViewById(R.id.edit_text_wallet_address);

        iconImageView.animate().alpha(1).setDuration(2000).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                iconImageView.animate().translationY(-100).setDuration(1200);
                addressView.animate().translationY(275).alpha(1).setDuration(1200);
                addressView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        }).start();

        view.findViewById(R.id.button_get_wallet).setOnClickListener(view1 -> {
            if (walletAddressEditText.getText().toString().equals("")) {
                Toast.makeText(getActivity(), R.string.toast_text_enter_wallet_address, Toast.LENGTH_LONG).show();
            } else {
                if (isValidAddress(walletAddressEditText.getText().toString())) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.INTENT_PARAMETER_WALLET_ADDRESS, walletAddressEditText.getText().toString());
                    Navigation.findNavController(view1).navigate(R.id.action_navigation_home_to_navigation_dashboard, bundle);
                } else {
                    Toast.makeText(getActivity(), R.string.toast_text_wallet_address_error, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean isValidAddress(String walletAddress) {
        String regex = "^0x[0-9a-f]{40}$";
        if (walletAddress.toLowerCase().matches(regex)) {
            return true;
        }
        return false;
    }
}