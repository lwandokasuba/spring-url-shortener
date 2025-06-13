package com.lwandokasuba.urlshortener.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwandokasuba.urlshortener.models.ShortUrl;
import com.lwandokasuba.urlshortener.repositories.ShortUrlRepository;

@Service
public class ShortUrlService {
  @Autowired
  ShortUrlRepository shortUrlRepository;

  public ShortUrl add(ShortUrl url) {
    return shortUrlRepository.save(url);
  }

  public Iterable<ShortUrl> getAll() {
    return shortUrlRepository.findAll();
  }

  public ShortUrl get(Integer id) {
    Optional<ShortUrl> url = shortUrlRepository.findById(id);
    if (url.isPresent()) {
      return url.get();
    }

    return null;
  }

  public String delete(Integer id) {
    shortUrlRepository.deleteById(id);
    return new String("Deleted");
  }

  public ShortUrl update(Integer id, ShortUrl url) {
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
