package com.example.url_shortener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller class that handles HTTP requests.
 */
@Controller
public class UrlShortenerController {

    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }

    /**
     * Serves the main page of the application.
     *
     * @return The name of the Thymeleaf template to render (url-shortener.html).
     */
    @GetMapping("/")
    public String urlShortener() {
        return "url-shortener";    
    }

    /**
     * Handles the POST request to shorten a URL.
     *
     * @param originalUrl The original URL provided by the user.
     * @return The full shortened URL as a String.
     */
    @PostMapping("/")
    @ResponseBody
    public String shortenUrl(@RequestParam("original-url") String originalUrl) {
        String id = service.shortenUrl(originalUrl);
        return "http://localhost:8080/" + id;
    }

    /**
     * Handles the redirection from a shortened URL ID to the original URL.
     *
     * @param urlId The unique identifier of the shortened URL.
     * @return A redirect string to the original URL if found, or a redirect to the home page if not.
     */
    @GetMapping("/{url_id:[a-zA-Z0-9]+}")
    public String redirectToOriginalUrl(@PathVariable("url_id") String urlId) {
        String originalUrl = service.getOriginalUrl(urlId);
        if (originalUrl != null) {
            return "redirect:" + originalUrl;
        }
        return "redirect:/";
    }
}
