package com.ensi.coart.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDTO {

    private Long id;
    private String name;
    private String style; 
    private Boolean enabled;
    
    
}