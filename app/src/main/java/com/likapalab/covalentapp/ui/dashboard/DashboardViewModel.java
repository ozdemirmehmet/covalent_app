/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:13
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 03.06.2021 23:41
 */

package com.likapalab.covalentapp.ui.dashboard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.likapalab.covalentapp.api.balances.BalanceResponse;
import com.likapalab.covalentapp.api.services.CovalentService;
import com.likapalab.covalentapp.api.transcation.TransactionResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DashboardViewModel extends ViewModel {

    private MutableLiveData<BalanceResponse> balanceResponse;
    private MutableLiveData<TransactionResponse> transactionsResponse;
    private MutableLiveData<Boolean> onProgress;

    public DashboardViewModel() {
        onProgress = new MutableLiveData<>(false);
        balanceResponse = new MutableLiveData<>();
        transactionsResponse = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getOnProgress() {
        return onProgress;
    }

    public void getBalances(String address, String apiKey) {
        onProgress.postValue(true);
        CovalentService.getCovalentServices().getTokenBalancesApiRequest("1", address, apiKey).enqueue(new Callback<BalanceResponse>() {
            @Override
            public void onResponse(Call<BalanceResponse> call, Response<BalanceResponse> response) {
                onProgress.postValue(false);
                onProgress.postValue(false);
                balanceResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<BalanceResponse> call, Throwable t) {
                onProgress.postValue(false);
            }
        });
    }

    public MutableLiveData<BalanceResponse> getBalanceResponse() {
        return balanceResponse;
    }

    public void getTransactions(String address, String apiKey) {
        onProgress.postValue(true);
        CovalentService.getCovalentServices().getTransactionsApiRequest("1", address, apiKey).enqueue(new Callback<TransactionResponse>() {
            @Override
            public void onResponse(retrofit2.Call<TransactionResponse> call, Response<TransactionResponse> response) {
                onProgress.postValue(false);
                onProgress.postValue(false);
                transactionsResponse.postValue(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<TransactionResponse> call, Throwable t) {
                onProgress.postValue(false);
            }
        });
    }

    public MutableLiveData<TransactionResponse> getTransactionsResponse() {
        return transactionsResponse;
    }
}