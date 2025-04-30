package com.kaveri_bank.card.mapper;

import com.kaveri_bank.card.dto.CardsDto;
import com.kaveri_bank.card.entity.Cards;

public class CardMapper {
    

    public static CardsDto cardEntityToDto(Cards cards){
        return new CardsDto(cards.getCardId(), cards.getMobileNumber(), cards.getCardNumber(), cards.getCardType(), cards.getTotalLimit(), cards.getAmountUsed(),cards.getAvailableAmount());
    }

    public static Cards cardDtoToEntity(CardsDto cards){
        return new Cards(null ,cards.getMobileNumber(), cards.getCardNumber(), cards.getCardType(), cards.getTotalLimit(), cards.getAmountUsed(),cards.getAvailableAmount());
    }

}
