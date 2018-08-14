package com.systems88.memberbalance.core.request.gspapi;

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
public class GspApiRequestParam {

	@XmlElement(name = "GameCode")
	private String gameCode;

	@XmlElement(name = "MemberID")
	private String memberId;

	public GspApiRequestParam() {

	}

	public GspApiRequestParam(String gameCode, String memberId) {
		this.gameCode = gameCode;
		this.memberId = memberId;
	}

}
