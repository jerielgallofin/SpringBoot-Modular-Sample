package com.systems88.memberbalance.core.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberBalanceResponseData {

	private String memberId;
	private BigDecimal balance;
	private String currency;

	public MemberBalanceResponseData() {

	}

	public MemberBalanceResponseData(String memberId, BigDecimal balance, String currency) {
		this.memberId = memberId;
		this.balance = balance;
		this.currency = currency;
	}

}
