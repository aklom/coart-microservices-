/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.coart.exhibitionservice.service;


import com.ensi.coart.exhibitionservice.domain.Exhibition;
import com.ensi.coart.exhibitionservice.repository.ExhibitionRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
 *
 * @author Ibti
 */
@Service
@Transactional
public class ExhibitionService {

    private ExhibitionRepository exhibitionRepository;

    public ExhibitionService(ExhibitionRepository exhibitionRepository) {
		super();
		this.exhibitionRepository = exhibitionRepository;
	}
    public List<ExhibitionDTO> findAll() {
	        return this.exhibitionRepository.findAll()
	                .stream()
	                .map(ExhibitionService::mapToDTO)
	                .collect(Collectors.toList());
	    }
    
    // @Transactional(dontRollbackOn = true)
	public ExhibitionDTO findById(Long id) {
	       return this.exhibitionRepository.findById(id).map(ExhibitionService::mapToDTO).orElse(null);
	}
	 
	public ExhibitionDTO create(ExhibitionDTO exhibitionDTO) {

	        return mapToDTO(this.exhibitionRepository.save(
	                new Exhibition(
	                        exhibitionDTO.getTitleExhibition(),
	                        exhibitionDTO.getStartDay(),
	                        exhibitionDTO.getEndDay()
                        )));
	}
         
        public void delete(Long id) {
	        this.exhibitionRepository.deleteById(id);
	}
        
        public static ExhibitionDTO mapToDTO(Exhibition exhibition) {
	        if (exhibition != null) {
	            return new ExhibitionDTO(
	                    exhibition.getTitleExhibition(),
	                    exhibition.getStartDay(),
	                    exhibition.getEndDay()
                           
	            );
	        }
	        return null;
	    }
}
