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
@XmlRootElement(name = "Header")
public class GspApiRequestHeader {

	@XmlElement(name = "Method")
	private String method;

	@XmlElement(name = "Op")
	private String op;

	@XmlElement(name = "OPpwd")
	private String opPwd;


	public GspApiRequestHeader(String method, String op, String opPwd) {
		this.method = method;
		this.op = op;
		this.opPwd = opPwd;
	}

	public GspApiRequestHeader() {

	}

}
