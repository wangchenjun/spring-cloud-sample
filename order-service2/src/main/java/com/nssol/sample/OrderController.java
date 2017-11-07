package com.nssol.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	private Logger logger = LoggerFactory.getLogger(OrderController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> hello() {
		logger.info("called by order service");
		return new ResponseEntity<>("Hello order service2", HttpStatus.OK);
	}
}
