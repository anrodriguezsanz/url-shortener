package com.example.url_shortener;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Entity class representing the mapping between a shortened ID and the original
 * URL.
 */
@Entity
public class UrlMapping {

    @Id
    private String id;
    private String originalUrl;

    public UrlMapping() {
    }

    /**
     * Constructor to create a new URL mapping.
     *
     * @param id          The unique identifier.
     * @param originalUrl The original URL.
     */
    public UrlMapping(String id, String originalUrl) {
        this.id = id;
        this.originalUrl = originalUrl;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}