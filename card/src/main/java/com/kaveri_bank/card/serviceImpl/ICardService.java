package com.kaveri_bank.card.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaveri_bank.card.dto.CardsDto;
import com.kaveri_bank.card.entity.Cards;
import com.kaveri_bank.card.mapper.CardMapper;
import com.kaveri_bank.card.repository.CardsRepository;
import com.kaveri_bank.card.service.CardService;

@Service
public class ICardService implements CardService{

    @Autowired
    CardsRepository repo;

    @Override
    public void createCard(CardsDto dto)  {

        Cards card = CardMapper.cardDtoToEntity(dto);
        card.setCreatedAt(LocalDateTime.now());
        card.setCreatedBy("SYSTEM");
        // repo.findByMobileNumber(dto.getMobileNumber()).orElseThrow(
        //     ()-> new Exception("mobile number alredy present ...  ")
        // );
        repo.save(card);

        
    }

    @Override
    public CardsDto getCardDetails(String mobileNumber) throws Exception{
        Cards card = (repo.findByMobileNumber(mobileNumber)).get();
        //.orElseThrow(
        //     ()-> new Exception("Cards Not found for the mobile number ..")
        // );
        CardsDto dto = CardMapper.cardEntityToDto(card);
        return dto;
    }

    @Override
    public void editCard(CardsDto dto) throws Exception{
        Cards card = repo.findByMobileNumber(dto.getMobileNumber()).orElseThrow(
            ()-> new Exception("Cards Not found for the mobile number ..")
        );
        Cards car = CardMapper.cardDtoToEntity(dto);
        car.setCardId(card.getCardId());
        car.setCreatedAt(card.getCreatedAt());
        car.setCreatedBy(card.getCreatedBy());
        repo.save(car);
    }

    @Override
    public void deleteCard(String mobileNumber) {
        repo.deleteByMobileNumber(mobileNumber);
    }
    
}
