package com.nssol.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadbalanceController {
	@Autowired
	RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(LoadbalanceController.class);
	

	@RequestMapping(value = "/product/hello", method = RequestMethod.GET)
	public String productHello() {
		return restTemplate.getForEntity("http://PRODUCT-SERVICE/hello", String.class).getBody();
	}

	@RequestMapping(value = "/order/hello", method = RequestMethod.GET)
	public String orderHello() {
		logger.info("loadbalance calling order service");
		return restTemplate.getForEntity("http://ORDER-SERVICE/hello", String.class).getBody();
	}
}
