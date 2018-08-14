package com.systems88.memberbalance.api.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.systems88.memberbalance.api.service.MemberBalanceService;
import com.systems88.memberbalance.core.response.MemberBalanceResponse;

@RestController
public class MemberBalanceResource {

	private MemberBalanceService memberBalanceService;

	public MemberBalanceResource(MemberBalanceService memberBalanceService) {
		this.memberBalanceService = memberBalanceService;
	}
	
	@GetMapping(value = "/get_balance")
	public MemberBalanceResponse getMemberBalance(@RequestParam(value = "game_code", required = true) String gameCode,
			@RequestParam(value = "member_id", required = true) String memberId) {
		return memberBalanceService.getMemberBalance(gameCode, memberId);
	}

	@GetMapping(value = "/get_all_balance")
	public MemberBalanceResponse getAllMemberBalance(
			@RequestParam(value = "game_code", required = true) String gameCode,
			@RequestParam(value = "currency", required = false) String currency) {
		return memberBalanceService.getAllMemberBalance(gameCode, currency);
	}

}
