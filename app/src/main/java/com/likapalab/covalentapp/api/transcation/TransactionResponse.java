/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:55
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 17:54
 */

package com.likapalab.covalentapp.api.transcation;

import com.google.gson.annotations.SerializedName;

public class TransactionResponse {

	@SerializedName("error_message")
	private Object errorMessage;

	@SerializedName("data")
	private Data data;

	@SerializedName("error_code")
	private Object errorCode;

	@SerializedName("error")
	private boolean error;

	public Object getErrorMessage(){
		return errorMessage;
	}

	public Data getData(){
		return data;
	}

	public Object getErrorCode(){
		return errorCode;
	}

	public boolean isError(){
		return error;
	}
}