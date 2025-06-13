package com.lwandokasuba.urlshortener.repositories;

import org.springframework.stereotype.Repository;

import com.lwandokasuba.urlshortener.models.ShortUrl;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ShortUrlRepository extends CrudRepository<ShortUrl, Integer> {
  
}
