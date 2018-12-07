package com.ensi.coart.artistservice.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.ensi.coart.artistservice.domain.Artist;
import com.ensi.coart.artistservice.repository.ArtistRepository;
import com.ensi.coart.commons.dto.ArtistDTO;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ArtistService {

    private ArtistRepository artistRepository; 

   
    public ArtistDTO create(ArtistDTO artistDTO){
        return mapToDto(
            this.artistRepository.save(
                new Artist( 
                    artistDTO.getName(), 
                    artistDTO.getStyle()
                )
            )
        );
    }
    
    public List<ArtistDTO> findAll(){
        return this.artistRepository.findAll()
                .stream()
                .map(ArtistService::mapToDto)
                .collect(Collectors.toList()); 
    }

    public ArtistDTO  findById(Long id) {
        return this.artistRepository.findById(id).map(ArtistService::mapToDto).orElse(null); 
    }

    public List<ArtistDTO> findByStyle(String style){
        return this.artistRepository.findByStyle(style)
                .stream()
                .map(ArtistService::mapToDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id){
        Artist artist = this.artistRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find artist with id " + id)); 
        
        artist.setEnabled(false); 
        this.artistRepository.save(artist); 
    }

    public static ArtistDTO mapToDto(Artist artist) {
        if(artist != null){
            return new ArtistDTO(
                artist.getId(),
                artist.getName(), 
                artist.getStyle().toString(),
                artist.getEnabled()
            ); 
        }
        return null; 
    }
}