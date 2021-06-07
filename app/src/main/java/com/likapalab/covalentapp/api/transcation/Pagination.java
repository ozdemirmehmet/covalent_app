/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:55
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 17:54
 */

package com.likapalab.covalentapp.api.transcation;

import com.google.gson.annotations.SerializedName;

public class Pagination{

	@SerializedName("page_number")
	private int pageNumber;

	@SerializedName("total_count")
	private Object totalCount;

	@SerializedName("has_more")
	private boolean hasMore;

	@SerializedName("page_size")
	private int pageSize;

	public int getPageNumber(){
		return pageNumber;
	}

	public Object getTotalCount(){
		return totalCount;
	}

	public boolean isHasMore(){
		return hasMore;
	}

	public int getPageSize(){
		return pageSize;
	}
}