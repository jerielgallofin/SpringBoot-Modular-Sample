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
@XmlRootElement(name = "Request")
public class GspApiRequest {

	@XmlElement(name = "Header")
	private GspApiRequestHeader header;

	@XmlElement(name = "Parameter")
	private GspApiRequestParam param;

}
