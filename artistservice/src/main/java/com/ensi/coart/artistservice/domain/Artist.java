package com.ensi.coart.artistservice.domain; 

import com.ensi.coart.artistservice.domain.enumeration.ArtistStyle;
import com.ensi.coart.commons.domain.AbstractEntity;

import java.util.List;

import javax.persistence.*;
import lombok.*; 
import com.ensi.coart.commons.domain.AbstractEntity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="artist")
public class Artist extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "style")
    private String style; 

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    public Artist(String name, String style){
        this.name = name; 
        this.style = style; 
        this.enabled = true; 
    }
        
}