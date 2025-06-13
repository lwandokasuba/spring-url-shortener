package com.lwandokasuba.urlshortener.controllers;

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
import com.lwandokasuba.urlshortener.services.ShortUrlService;

@Controller
@RequestMapping(path = "/api/url")
public class ShortUrlController {
  @Autowired
  private ShortUrlService shortUrlService;

  @PostMapping()
  public @ResponseBody ShortUrl addNewShortUrl(@RequestBody ShortUrl url) {
    return shortUrlService.add(url);
  }

  @GetMapping()
  public @ResponseBody Iterable<ShortUrl> getAllUrls() {
    return shortUrlService.getAll();
  }

  @GetMapping(path = "/{id}")
  public @ResponseBody ShortUrl getUrl(@PathVariable Integer id) {
    return shortUrlService.get(id);
  }

  @DeleteMapping(path = "/{id}")
  public @ResponseBody String deleteUrl(@PathVariable Integer id) {
    return shortUrlService.delete(id);
  }

  @PutMapping(path = "/{id}")
  public @ResponseBody ShortUrl updateUrl(@PathVariable Integer id, @RequestBody ShortUrl url) {
    return shortUrlService.update(id, url);
  }
}
