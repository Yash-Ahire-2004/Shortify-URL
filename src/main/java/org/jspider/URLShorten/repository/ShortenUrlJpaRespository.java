package org.jspider.URLShorten.repository;

import java.util.Optional;

import org.jspider.URLShorten.dto.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortenUrlJpaRespository extends JpaRepository<ShortUrl, Long> {

	Optional<ShortUrl> findByUrl(String code);
}