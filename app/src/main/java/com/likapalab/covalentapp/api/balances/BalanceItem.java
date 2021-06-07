package com.likapalab.covalentapp.api.balances;

import com.google.gson.annotations.SerializedName;

public class BalanceItem {

	@SerializedName("quote_rate")
	private double quoteRate;

	@SerializedName("quote")
	private double quote;

	@SerializedName("balance")
	private String balance;

	@SerializedName("logo_url")
	private String logoUrl;

	@SerializedName("nft_data")
	private Object nftData;

	@SerializedName("contract_name")
	private String contractName;

	@SerializedName("supports_erc")
	private Object supportsErc;

	@SerializedName("contract_address")
	private String contractAddress;

	@SerializedName("type")
	private String type;

	@SerializedName("contract_decimals")
	private int contractDecimals;

	@SerializedName("contract_ticker_symbol")
	private String contractTickerSymbol;

	public double getQuoteRate(){
		return quoteRate;
	}

	public double getQuote(){
		return quote;
	}

	public String getBalance(){
		return balance;
	}

	public String getLogoUrl(){
		return logoUrl;
	}

	public Object getNftData(){
		return nftData;
	}

	public String getContractName(){
		return contractName;
	}

	public Object getSupportsErc(){
		return supportsErc;
	}

	public String getContractAddress(){
		return contractAddress;
	}

	public String getType(){
		return type;
	}

	public int getContractDecimals(){
		return contractDecimals;
	}

	public String getContractTickerSymbol(){
		return contractTickerSymbol;
	}
}