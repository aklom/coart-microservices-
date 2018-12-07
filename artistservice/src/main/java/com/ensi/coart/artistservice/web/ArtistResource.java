package com.ensi.coart.artistservice.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.ensi.coart.artistservice.service.ArtistService;
import com.ensi.coart.commons.dto.ArtistDTO;
import com.ensi.coart.commons.utils.Web;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(Web.API + "artists")
public class ArtistResource {

    private final ArtistService artistService; 

    @GetMapping
    public List<ArtistDTO> findAll(){
        return this.artistService.findAll(); 
    }

    /*@GetMapping
    public List<ArtistDTO> findAllEnabled(){
        return this.artistService.findAllEnabled(); 
    }*/

    @GetMapping("/{id}")
    public ArtistDTO findById(@PathVariable Long id){
        return this.artistService.findById(id); 
    }

    @GetMapping("/style/{style}")
    public List<ArtistDTO> findByStyle(@PathVariable String style){
        return this.artistService.findByStyle(style); 
    }

    @PostMapping
    public ArtistDTO create(ArtistDTO artistDTO){
        return this.artistService.create(artistDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.artistService.delete(id);
    }
}