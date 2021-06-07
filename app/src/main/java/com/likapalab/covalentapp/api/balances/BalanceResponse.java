package com.likapalab.covalentapp.api.balances;

import com.google.gson.annotations.SerializedName;

public class BalanceResponse {

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