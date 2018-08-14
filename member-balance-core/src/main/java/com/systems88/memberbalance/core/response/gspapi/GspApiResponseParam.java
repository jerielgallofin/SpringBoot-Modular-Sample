package com.systems88.memberbalance.core.response.gspapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Parameter")
public class GspApiResponseParam {

	@XmlElement(name = "GameCode")
	private String gameCode;

	@XmlElement(name = "MemberID")
	private String memberId;

	@XmlElement(name = "Currency")
	private String currency;

	@XmlElement(name = "Balance")
	private BigDecimal balance;

}
