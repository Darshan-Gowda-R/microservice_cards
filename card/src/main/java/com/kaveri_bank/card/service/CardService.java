package com.kaveri_bank.card.service;

import com.kaveri_bank.card.dto.CardsDto;

public interface CardService {
    
    public void createCard(CardsDto dto) throws  Exception;

    public CardsDto getCardDetails(String mobileNumber)throws  Exception;

    public void editCard(CardsDto dto) throws  Exception;

    public void deleteCard(String mobileNumber)throws  Exception;

}
