package com.example.po_projekt.service;

import com.example.po_projekt.entity.Form;
import com.example.po_projekt.entity.Offer;
import com.example.po_projekt.repository.FormRepository;
import com.example.po_projekt.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    @Autowired
    OfferRepository offerRepository;

    private static long nextId = 1;

    public OfferService() {
    }

    private boolean isEmpty() {
        return offerRepository.count() == 0;
    }

    public List<Offer> getOfferList() {
        return offerRepository.findAll();
    }

    public void addOffer(Offer offer) {
//        validateProduct(product);
        offer.setId(nextId);
        offerRepository.save(offer);
        nextId++;
    }

    public Offer getOfferById(long id) {
        var value = offerRepository.findById(id);
        return value.isEmpty() ? null : value.get();
    }

    public Offer getOffer(Offer offer) {
        return getOfferById(offer.getId());
    }

    public void updateOffer(Offer offer) {
        offerRepository.save(offer);
    }



    public void deleteOffer(Offer offer) {
        offerRepository.deleteById(offer.getId());
    }

    public void deleteOfferById(long id) {
        offerRepository.deleteById(id);
    }
}
