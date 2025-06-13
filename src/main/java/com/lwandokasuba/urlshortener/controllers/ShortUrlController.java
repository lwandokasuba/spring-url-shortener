package com.lwandokasuba.urlshortener.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lwandokasuba.urlshortener.models.ShortUrl;
import com.lwandokasuba.urlshortener.repositories.ShortUrlRepository;

@Controller
@RequestMapping(path = "/api/url")
public class ShortUrlController {
  @Autowired
  private ShortUrlRepository shortUrlRepository;

  @PostMapping()
  public @ResponseBody ShortUrl addNewShortUrl(@RequestBody ShortUrl url) {
    return shortUrlRepository.save(url);
  }

  @GetMapping()
  public @ResponseBody Iterable<ShortUrl> getAllUrls() {
    return shortUrlRepository.findAll();
  }

  @GetMapping(path = "/{id}")
  public @ResponseBody ShortUrl getUrl(@PathVariable Integer id) {
    Optional<ShortUrl> url = shortUrlRepository.findById(id);
    if (url.isPresent()) {
      return url.get();
    }

    return null;
  }

  @DeleteMapping(path = "/{id}")
  public @ResponseBody String deleteUrl(@PathVariable Integer id) {
    shortUrlRepository.deleteById(id);
    return new String("Deleted");
  }

  @PutMapping(path = "/{id}")
  public @ResponseBody ShortUrl updateUrl(@PathVariable Integer id, @RequestBody ShortUrl url) {
    ShortUrl urlToUpdate = shortUrlRepository.findById(id).get();
    if (url.getLongUrl() != null && url.getLongUrl().isEmpty() != true) {
      urlToUpdate.setLongUrl(url.getLongUrl());
    }
    if (url.getShortUrl() != null && url.getShortUrl().isEmpty() != true) {
      urlToUpdate.setShortUrl(url.getShortUrl());
    }
    return shortUrlRepository.save(urlToUpdate);
  }
}
