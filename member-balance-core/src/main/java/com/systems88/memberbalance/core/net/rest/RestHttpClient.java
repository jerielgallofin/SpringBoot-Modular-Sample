package com.systems88.memberbalance.core.net.rest;

import org.springframework.web.client.RestTemplate;

public interface RestHttpClient {

	public RestTemplate getDefaultRestTemplate();

}
