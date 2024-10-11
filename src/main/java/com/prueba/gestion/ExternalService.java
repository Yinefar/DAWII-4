package com.prueba.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class ExternalService {

	@Autowired
	private RestTemplate restTemplate;

	@CircuitBreaker(name = "prueba", fallbackMethod = "fallback")
	//@Retry(name = "prueba", fallbackMethod = "fallback")

	public String callFromHttpBin() {
		return restTemplate.getForObject("http://httpbin.org/delay/15", String.class);
		//return restTemplate.getForObject("http://httpbin.org/status/500", String.class);
	}
	public String fallback(Throwable t) {
		return "Servicio temporalmente no disponible" + t.getMessage();
	}


}
