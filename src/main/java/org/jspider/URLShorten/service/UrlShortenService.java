package org.jspider.URLShorten.service;

import org.jspider.URLShorten.dto.ShortUrl;
import org.jspider.URLShorten.repository.ShortenUrlJpaRespository;
import org.jspider.URLShorten.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenService {
	@Autowired
	ShortenUrlJpaRespository jpa;

	public String generateUrl(String originalUrl) {
		String code = UrlUtil.generateCode();
		ShortUrl url = new ShortUrl();
		url.setOriginalUrl(originalUrl);
		url.setUrl(code);
		jpa.save(url);
		return code;
	}

	public String getUrl(String code) {
		return jpa.findByUrl(code).orElseThrow(() -> new RuntimeException()).getOriginalUrl();
	}
}