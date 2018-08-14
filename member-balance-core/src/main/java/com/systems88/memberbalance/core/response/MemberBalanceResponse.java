package com.systems88.memberbalance.core.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberBalanceResponse {

	private String code;
	private String message;
	private MemberBalanceResponseData memberBalance;
	private List<MemberBalanceResponseData> memberBalances;

}
