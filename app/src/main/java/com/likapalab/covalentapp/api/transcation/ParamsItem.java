/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:55
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 17:54
 */

package com.likapalab.covalentapp.api.transcation;

import com.google.gson.annotations.SerializedName;

public class ParamsItem{

	@SerializedName("indexed")
	private boolean indexed;

	@SerializedName("name")
	private String name;

	@SerializedName("decoded")
	private boolean decoded;

	@SerializedName("type")
	private String type;

	@SerializedName("value")
	private String value;

	public boolean isIndexed(){
		return indexed;
	}

	public String getName(){
		return name;
	}

	public boolean isDecoded(){
		return decoded;
	}

	public String getType(){
		return type;
	}

	public String getValue(){
		return value;
	}
}