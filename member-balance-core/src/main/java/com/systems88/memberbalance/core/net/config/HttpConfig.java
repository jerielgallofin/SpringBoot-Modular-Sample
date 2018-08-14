package com.systems88.memberbalance.core.net.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.systems88.memberbalance.core.net.rest.RestHttpClient;

@Configuration
public class HttpConfig {

	private RestHttpClient restClient;

	public HttpConfig(RestHttpClient restClient) {
		this.restClient = restClient;
	}

	@Bean
	@Qualifier("restTemplate")
	public RestTemplate restTemplate() {
		return restClient.getDefaultRestTemplate();
	}

}
