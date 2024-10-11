package com.prueba.controller;

import com.prueba.gestion.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class ResilienceController {

	@Autowired
	private ExternalService resService;

	@GetMapping("/httpbin")
	public String getHttpBinError() {
		return resService.callFromHttpBin();
	}
	@GetMapping("/jsonplace")
	public String getJSONPlaceError() {
		return resService.callFromJSONPlace();
	}


}
