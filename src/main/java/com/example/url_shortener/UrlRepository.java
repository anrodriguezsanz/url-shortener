package com.example.url_shortener;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing UrlMapping data in the database and
 * provide standard CRUD operations.
 */
@Repository
public interface UrlRepository extends JpaRepository<UrlMapping, String> {
}