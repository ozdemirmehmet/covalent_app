/*
 * Created by Mehmet Ozdemir on 06.06.2021 19:19
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 19:14
 */

package com.likapalab.covalentapp.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.likapalab.covalentapp.api.balances.BalanceItem;
import com.likapalab.covalentapp.ui.BalanceInfoFragment;

import java.util.ArrayList;
import java.util.List;

public class BalanceInfoAdapter extends FragmentStatePagerAdapter {

    //Class Variables
    private List<BalanceItem> balanceList;

    public BalanceInfoAdapter(FragmentManager fm, List<BalanceItem> balanceList) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.balanceList = balanceList;
    }

    @Override
    public Fragment getItem(final int position) {
        if (balanceList != null) {
            return BalanceInfoFragment.newInstance(balanceList.get(position));
        }
        return null;
    }

    @Override
    public int getCount() {
        return balanceList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return balanceList.get(position).getContractName();
    }

    public List<BalanceItem> getBalanceList() {
        return balanceList;
    }
}