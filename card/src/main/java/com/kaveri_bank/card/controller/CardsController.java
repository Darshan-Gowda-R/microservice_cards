package com.kaveri_bank.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaveri_bank.card.dto.CardsDto;
import com.kaveri_bank.card.dto.ResponseDto;
import com.kaveri_bank.card.service.CardService;

@RestController
@RequestMapping(path = "/cards",produces = MediaType.APPLICATION_JSON_VALUE)
public class CardsController {

    @Autowired
    private CardService service;
    
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> createCard(@RequestBody CardsDto dto){

        try{
            service.createCard(dto);
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("500", e.getMessage()));
        }

        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200_OK", "Card created successfully !!!!"));
        
    }

    @GetMapping("/get")
    public ResponseEntity<CardsDto> createCard(@RequestParam String mobileNumber){
        CardsDto dto = null;
        try{
            dto = service.getCardDetails(mobileNumber);
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CardsDto(0l,"","","",0,0,0));
        }

        return  ResponseEntity.status(HttpStatus.OK).body(dto);
        
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseDto> editCard(@RequestBody CardsDto dto){

        try{
            service.editCard(dto);
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("500", e.getMessage()));
        }

        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200_OK", "Card edited successfully !!!!"));
        
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCard(@RequestParam String mobileNumber){

        try{
            service.deleteCard(mobileNumber);
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("500", e.getMessage()));
        }

        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200_OK", "Card Deleted successfully !!!!"));
        
    }

    

}
