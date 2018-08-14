package com.systems88.memberbalance.core.net.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestHttpClientImpl implements RestHttpClient {

	private static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 100;
	private static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 100;
	private static final int DEFAULT_READ_TIMEOUT_MILLISECONDS = 30 * 1000;

	@Override
	public RestTemplate getDefaultRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(getHttpRequestFactory(getHttpClient()));
		setMessageCustomConverters(restTemplate.getMessageConverters());
		return restTemplate;
	}
	
	private ClientHttpRequestFactory getHttpRequestFactory(HttpClient httpClient) {
		return new HttpComponentsClientHttpRequestFactory(httpClient);
	}

	private HttpClient getHttpClient() {

		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(DEFAULT_READ_TIMEOUT_MILLISECONDS)
				.setConnectionRequestTimeout(DEFAULT_READ_TIMEOUT_MILLISECONDS)
				.setSocketTimeout(DEFAULT_READ_TIMEOUT_MILLISECONDS).build();

		return HttpClientBuilder.create().setMaxConnTotal(DEFAULT_MAX_TOTAL_CONNECTIONS)
				.setMaxConnPerRoute(DEFAULT_MAX_CONNECTIONS_PER_ROUTE).setDefaultRequestConfig(requestConfig).build();
	}

	protected void setMessageCustomConverters(List<HttpMessageConverter<?>> messageConverters) {
		List<MediaType> mediaTypes = new ArrayList<>();

		for (HttpMessageConverter<?> converter : messageConverters) {
			if (converter instanceof Jaxb2RootElementHttpMessageConverter) {
				mediaTypes.add(MediaType.TEXT_HTML);
				mediaTypes.add(MediaType.TEXT_XML);
				mediaTypes.add(MediaType.APPLICATION_XML);
				((Jaxb2RootElementHttpMessageConverter) converter).setSupportedMediaTypes(mediaTypes);
			}
			if (converter instanceof MappingJackson2HttpMessageConverter) {
				mediaTypes.add(MediaType.TEXT_PLAIN);
				mediaTypes.add(MediaType.TEXT_HTML);
				mediaTypes.add(MediaType.APPLICATION_JSON);
				mediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
				mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
				((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(mediaTypes);
			}
		}
	}


}
