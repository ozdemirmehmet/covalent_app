/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:55
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 17:54
 */

package com.likapalab.covalentapp.api.transcation;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Decoded{

	@SerializedName("signature")
	private String signature;

	@SerializedName("name")
	private String name;

	@SerializedName("params")
	private List<ParamsItem> params;

	public String getSignature(){
		return signature;
	}

	public String getName(){
		return name;
	}

	public List<ParamsItem> getParams(){
		return params;
	}
}