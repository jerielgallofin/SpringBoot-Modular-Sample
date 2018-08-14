package com.systems88.memberbalance.api.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.systems88.memberbalance.api.props.MemberBalanceServiceProps;
import com.systems88.memberbalance.api.utility.ErrorCodes;
import com.systems88.memberbalance.core.GameProviderMember;
import com.systems88.memberbalance.core.net.rest.RestHttpClient;
import com.systems88.memberbalance.core.persistence.entities.member.Member;
import com.systems88.memberbalance.core.persistence.entities.reference.Operator;
import com.systems88.memberbalance.core.persistence.service.member.MemberPersistenceService;
import com.systems88.memberbalance.core.persistence.service.reference.ReferencePersistenceService;
import com.systems88.memberbalance.core.request.gspapi.GspApiRequest;
import com.systems88.memberbalance.core.request.gspapi.GspApiRequestHeader;
import com.systems88.memberbalance.core.request.gspapi.GspApiRequestParam;
import com.systems88.memberbalance.core.response.MemberBalanceResponse;
import com.systems88.memberbalance.core.response.MemberBalanceResponseData;
import com.systems88.memberbalance.core.response.gspapi.GspApiResponse;

@Service
public class MemberBalanceService {

	private static final Logger log = LoggerFactory.getLogger(MemberBalanceService.class);
	private ReferencePersistenceService referencePersistenceService;
	private MemberBalanceServiceProps props;
	private MemberPersistenceService memberPersistenceService;
	private RestTemplate restTemplate;

	public MemberBalanceService(ReferencePersistenceService referencePersistenceService,
			MemberPersistenceService memberPersistenceService, RestHttpClient restHttpClient,
			MemberBalanceServiceProps props) {
		this.referencePersistenceService = referencePersistenceService;
		this.memberPersistenceService = memberPersistenceService;
		this.props = props;
		restTemplate = restHttpClient.getDefaultRestTemplate();
	}

	public MemberBalanceResponse getMemberBalance(String gameCode, String memberId) {
		MemberBalanceResponse response = new MemberBalanceResponse();

		Operator operator = referencePersistenceService.findOperatorByOpCode(memberId.substring(0, 2));
		if (operator == null) {
			response.setCode(ErrorCodes.INVALID_MEMBER_ID_CODE);
			response.setMessage(ErrorCodes.INVALID_MEMBER_ID_TEXT);
			return response;
		}

		GspApiResponse gspApiResponse = requestGspApiMemberBalance(gameCode, memberId, operator.getMerchId(),
				operator.getMerchPwd());
		
		if(gspApiResponse == null || !"0".equals(gspApiResponse.getHeader().getErrorCode())) {
			response.setCode(gspApiResponse != null ? gspApiResponse.getHeader().getErrorCode() : ErrorCodes.RESPONSE_NULL_CODE);
			response.setMessage(gspApiResponse != null ? gspApiResponse.getHeader().getErrorMsg() : ErrorCodes.RESPONSE_NULL_TEXT);
			return response;
		}

		response.setCode(ErrorCodes.SUCCESS_CODE);
		response.setMessage(ErrorCodes.SUCCESS_TEXT);
		response.setMemberBalance(new MemberBalanceResponseData(memberId, gspApiResponse.getParam().getBalance(), gspApiResponse.getParam().getCurrency()));
		return response;
	}

	public MemberBalanceResponse getAllMemberBalance(String gameCode, String currency) {
		MemberBalanceResponse response = new MemberBalanceResponse();
		List<MemberBalanceResponseData> listMemberBalanceResponseData = new ArrayList<>();
		GameProviderMember gameProviderMember = GameProviderMember.getGameProviderMemberClassBy(gameCode);
		@SuppressWarnings("unchecked")
		Class<Member> clazz = gameProviderMember.getClazz();

		List<Member> listMember;
		if (currency != null) {
			listMember = memberPersistenceService.getMemberByCurrency(currency, clazz);
		} else {
			listMember = memberPersistenceService.getAllMembers(clazz);
		}
		
		listMember.forEach(member -> {

			Operator operator = referencePersistenceService.findOperatorByOpCode(member.getMemberId().substring(0, 2));
			if (operator == null) {
				log.info("Operator for this member not found. " + member.getMemberId());
				return;
			}

			GspApiResponse gspApiResponse = requestGspApiMemberBalance(gameCode, member.getMemberId(),
					operator.getMerchId(), operator.getMerchPwd());

			if (gspApiResponse == null || !"0".equals(gspApiResponse.getHeader().getErrorCode())) {
				log.info("Error getting response for member: " + member.getMemberId());
				return;
			}
			listMemberBalanceResponseData.add(new MemberBalanceResponseData(gspApiResponse.getParam().getMemberId(),
					gspApiResponse.getParam().getBalance(), gspApiResponse.getParam().getCurrency()));

		});

		response.setCode(ErrorCodes.SUCCESS_CODE);
		response.setMessage(ErrorCodes.SUCCESS_TEXT);
		response.setMemberBalances(listMemberBalanceResponseData);

		return response;
	}

	private GspApiResponse requestGspApiMemberBalance(String gameCode, String memberId, String op, String opPwd) {
		GspApiRequest request = new GspApiRequest();
		request.setHeader(new GspApiRequestHeader("MemberBalance", op, opPwd));
		request.setParam(new GspApiRequestParam(gameCode, memberId));

		GspApiResponse response = null;
		try {
			String responseStr = restTemplate.postForObject(props.getGspApiUrl(), request, String.class);
			log.info("GSPAPI Response: " + responseStr);

			JAXBContext jaxbContext = JAXBContext.newInstance(GspApiResponse.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(responseStr);
			response = (GspApiResponse) unmarshaller.unmarshal(reader);

		} catch (RestClientException | JAXBException e) {
			log.error("", e);
		}

		return response;
	}
	
}
