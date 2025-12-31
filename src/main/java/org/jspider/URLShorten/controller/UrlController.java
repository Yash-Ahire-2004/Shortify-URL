package org.jspider.URLShorten.controller;

import java.net.URI;

import org.jspider.URLShorten.dto.ShortUrl;
import org.jspider.URLShorten.service.UrlShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {
	@Autowired
	UrlShortenService service;

	@GetMapping("/getCode")
	public String getCode(@RequestBody ShortUrl url) {
		String code = service.generateUrl(url.getOriginalUrl());
		return "http://localhost/8081/u/" + code;
	}

	@GetMapping("/u/{code}")
	public ResponseEntity geturl(@PathVariable String code) {
		String url = service.getUrl(code);
		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
	}
}