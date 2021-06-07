/*
 * Created by Mehmet Ozdemir on 06.06.2021 16:43
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 16:42
 */

package com.likapalab.covalentapp.models.interfaces;

import com.likapalab.covalentapp.api.balances.BalanceResponse;
import com.likapalab.covalentapp.api.transcation.TransactionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ICovalentServices {

    @GET("/v1/{chain_id}/address/{address}/balances_v2/")
    Call<BalanceResponse> getTokenBalancesApiRequest(@Path("chain_id") String chainId, @Path("address") String address, @Query("key") String apiKey);

    @GET("/v1/{chain_id}/address/{address}/transactions_v2/")
    Call<TransactionResponse> getTransactionsApiRequest(@Path("chain_id") String chainId, @Path("address") String address, @Query("key") String apiKey);

}
