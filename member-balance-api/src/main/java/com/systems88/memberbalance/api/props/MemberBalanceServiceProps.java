package com.systems88.memberbalance.api.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "memberbalance.service.props")
public class MemberBalanceServiceProps {

	private String gspApiUrl;

	public String getGspApiUrl() {
		return gspApiUrl;
	}

	public void setGspApiUrl(String gspApiUrl) {
		this.gspApiUrl = gspApiUrl;
	}

}
