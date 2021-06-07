/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:55
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 17:54
 */

package com.likapalab.covalentapp.api.transcation;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("address")
	private String address;

	@SerializedName("pagination")
	private Pagination pagination;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("chain_id")
	private int chainId;

	@SerializedName("next_update_at")
	private String nextUpdateAt;

	@SerializedName("items")
	private List<TransactionItem> items;

	@SerializedName("quote_currency")
	private String quoteCurrency;

	public String getAddress(){
		return address;
	}

	public Pagination getPagination(){
		return pagination;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getChainId(){
		return chainId;
	}

	public String getNextUpdateAt(){
		return nextUpdateAt;
	}

	public List<TransactionItem> getItems(){
		return items;
	}

	public String getQuoteCurrency(){
		return quoteCurrency;
	}
}