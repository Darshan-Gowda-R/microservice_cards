package com.kaveri_bank.card.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kaveri_bank.card.entity.Cards;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface  CardsRepository  extends JpaRepository<Cards,Long>{

    Optional<Cards> findByMobileNumber(String mobileNumber);
    
    void deleteByMobileNumber(String mobileNumber);
    
}
