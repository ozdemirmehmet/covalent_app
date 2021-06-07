/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:55
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 17:54
 */

package com.likapalab.covalentapp.api.transcation;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TransactionItem {

	@SerializedName("gas_price")
	private long gasPrice;

	@SerializedName("gas_offered")
	private int gasOffered;

	@SerializedName("gas_spent")
	private int gasSpent;

	@SerializedName("gas_quote")
	private double gasQuote;

	@SerializedName("to_address_label")
	private Object toAddressLabel;

	@SerializedName("value_quote")
	private double valueQuote;

	@SerializedName("tx_hash")
	private String txHash;

	@SerializedName("to_address")
	private String toAddress;

	@SerializedName("block_height")
	private int blockHeight;

	@SerializedName("log_events")
	private List<LogEventsItem> logEvents;

	@SerializedName("gas_quote_rate")
	private double gasQuoteRate;

	@SerializedName("from_address_label")
	private Object fromAddressLabel;

	@SerializedName("tx_offset")
	private int txOffset;

	@SerializedName("block_signed_at")
	private String blockSignedAt;

	@SerializedName("from_address")
	private String fromAddress;

	@SerializedName("value")
	private String value;

	@SerializedName("successful")
	private boolean successful;

	public long getGasPrice(){
		return gasPrice;
	}

	public int getGasOffered(){
		return gasOffered;
	}

	public int getGasSpent(){
		return gasSpent;
	}

	public double getGasQuote(){
		return gasQuote;
	}

	public Object getToAddressLabel(){
		return toAddressLabel;
	}

	public double getValueQuote(){
		return valueQuote;
	}

	public String getTxHash(){
		return txHash;
	}

	public String getToAddress(){
		return toAddress;
	}

	public int getBlockHeight(){
		return blockHeight;
	}

	public List<LogEventsItem> getLogEvents(){
		return logEvents;
	}

	public double getGasQuoteRate(){
		return gasQuoteRate;
	}

	public Object getFromAddressLabel(){
		return fromAddressLabel;
	}

	public int getTxOffset(){
		return txOffset;
	}

	public String getBlockSignedAt(){
		return blockSignedAt;
	}

	public String getFromAddress(){
		return fromAddress;
	}

	public String getValue(){
		return value;
	}

	public boolean isSuccessful(){
		return successful;
	}
}