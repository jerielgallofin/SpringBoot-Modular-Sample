package com.systems88.memberbalance.core.response.gspapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class GspApiResponse {

	@XmlElement(name = "Header")
	private GspApiResponseHeader header;

	@XmlElement(name = "Parameter")
	private GspApiResponseParam param;

}
