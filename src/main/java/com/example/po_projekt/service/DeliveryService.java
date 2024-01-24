package com.example.po_projekt.service;
import com.example.po_projekt.entity.Delivery;
import com.example.po_projekt.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    private static long nextId = 1;

    public DeliveryService() {
    }

    private boolean isEmpty() {
        return deliveryRepository.count() == 0;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryRepository.findAll();
    }

    public void addDelivery(Delivery delivery) {
//        validateProduct(product);
//        delivery.setId(nextId);
        deliveryRepository.save(delivery);
//        nextId++;
    }

    public Delivery getDeliveryById(long id) {
        var value = deliveryRepository.findById(id);
        return value.isEmpty() ? null : value.get();
    }

    public Delivery getDelivery(Delivery delivery) {
        return getDeliveryById(delivery.getId());
    }

    public void updateDelivery(Delivery delivery, Integer id)
    {
        Delivery dev = getDeliveryById(id);
        dev.setName(delivery.getName());
        dev.setLastname(delivery.getLastname());
        dev.setStreet(delivery.getStreet());
        dev.setNumberOfHouse(delivery.getNumberOfHouse());
        dev.setNumberOfApartment(delivery.getNumberOfApartment());
        dev.setZipCode(delivery.getZipCode());
        dev.setCity(delivery.getCity());
        dev.setStatus(delivery.getStatus());
        deliveryRepository.save(dev);
    }


    public void deleteDelivery(Delivery delivery) {
        deliveryRepository.deleteById(delivery.getId());
    }

    public void deleteDeliveryById(long id) {
        deliveryRepository.deleteById(id);
    }
}
