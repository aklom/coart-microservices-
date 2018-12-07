package com.ensi.coart.artistservice.repository;

import java.util.List;

import com.ensi.coart.artistservice.domain.Artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    public List<Artist> findByStyle(String style); 
}