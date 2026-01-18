package com.example.url_shortener;

import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * Service class for shortening URLs and retrieving them.
 */
@Service
public class UrlShortenerService {
    
    private final UrlRepository repository;

    public UrlShortenerService(UrlRepository repository) {
        this.repository = repository;
    }

    /**
     * Generates a unique ID for the given URL and saves the mapping to the database.
     *
     * @param originalUrl The URL to be shortened.
     * @return The generated unique ID.
     */
    public String shortenUrl(String originalUrl) {
        String id = UUID.randomUUID().toString().substring(0, 5);
        UrlMapping mapping = new UrlMapping(id, originalUrl);
        repository.save(mapping);
        return id;
    }

    /**
     * Retrieves the original URL associated with the given ID.
     *
     * @param id The unique identifier of the shortened URL.
     * @return The original URL if found, or null otherwise.
     */
    public String getOriginalUrl(String id) {
        return repository.findById(id)
                .map(UrlMapping::getOriginalUrl)
                .orElse(null);
    }
}