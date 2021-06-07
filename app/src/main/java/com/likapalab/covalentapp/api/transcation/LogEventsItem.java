/*
 * Created by Mehmet Ozdemir on 06.06.2021 17:55
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 17:54
 */

package com.likapalab.covalentapp.api.transcation;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LogEventsItem{

	@SerializedName("sender_contract_ticker_symbol")
	private Object senderContractTickerSymbol;

	@SerializedName("log_offset")
	private int logOffset;

	@SerializedName("tx_hash")
	private String txHash;

	@SerializedName("sender_name")
	private Object senderName;

	@SerializedName("block_height")
	private int blockHeight;

	@SerializedName("sender_contract_decimals")
	private Object senderContractDecimals;

	@SerializedName("sender_logo_url")
	private Object senderLogoUrl;

	@SerializedName("sender_address")
	private String senderAddress;

	@SerializedName("sender_address_label")
	private Object senderAddressLabel;

	@SerializedName("raw_log_data")
	private String rawLogData;

	@SerializedName("tx_offset")
	private int txOffset;

	@SerializedName("raw_log_topics")
	private List<String> rawLogTopics;

	@SerializedName("decoded")
	private Decoded decoded;

	@SerializedName("_raw_log_topics_bytes")
	private Object rawLogTopicsBytes;

	@SerializedName("block_signed_at")
	private String blockSignedAt;

	public Object getSenderContractTickerSymbol(){
		return senderContractTickerSymbol;
	}

	public int getLogOffset(){
		return logOffset;
	}

	public String getTxHash(){
		return txHash;
	}

	public Object getSenderName(){
		return senderName;
	}

	public int getBlockHeight(){
		return blockHeight;
	}

	public Object getSenderContractDecimals(){
		return senderContractDecimals;
	}

	public Object getSenderLogoUrl(){
		return senderLogoUrl;
	}

	public String getSenderAddress(){
		return senderAddress;
	}

	public Object getSenderAddressLabel(){
		return senderAddressLabel;
	}

	public String getRawLogData(){
		return rawLogData;
	}

	public int getTxOffset(){
		return txOffset;
	}

	public List<String> getRawLogTopics(){
		return rawLogTopics;
	}

	public Decoded getDecoded(){
		return decoded;
	}

	public Object getRawLogTopicsBytes(){
		return rawLogTopicsBytes;
	}

	public String getBlockSignedAt(){
		return blockSignedAt;
	}
}