package com.example.po_projekt.controller;

import com.example.po_projekt.entity.Delivery;
import com.example.po_projekt.service.DeliveryService;
import com.example.po_projekt.service.DevStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final DevStatusService devStatusService;

    public DeliveryController(DeliveryService deliveryService, DevStatusService devStatusService){
        this.deliveryService = deliveryService;
        this.devStatusService = devStatusService;
    }

    @GetMapping("/deliveries")
    public String deliveriesPage(Model model){
        List<Delivery> deliveryList = deliveryService.getDeliveryList();
        model.addAttribute("deliveryList", deliveryList);
        return"/deliveries";
    }

    @GetMapping("/addDelivery")
    public String add(Model model){
        model.addAttribute("delivery", new Delivery());
        model.addAttribute("statuses", devStatusService.getDevStatuses());
        return "/addDelivery";
    }

    @PostMapping("/addDelivery")
    public String add(@ModelAttribute Delivery delivery){
        deliveryService.addDelivery(delivery);
        return "redirect:/deliveries";
    }



    @GetMapping(value = {"/{devId}/editDelivery"})
    public String edit(Model model, @PathVariable Integer devId){
        model.addAttribute("delivery", deliveryService.getDeliveryById(devId));
        model.addAttribute("statuses", devStatusService.getDevStatuses());
        return "/editDelivery";
    }

    @PostMapping(value = {"{devId}/editDelivery"})
    public String edit(@ModelAttribute Delivery delivery, @PathVariable Integer devId) {
        deliveryService.updateDelivery(delivery, devId);
        return "redirect:/deliveries";
    }

    @GetMapping("/removeDelivery")
    public String remove(@RequestParam("id") long id) {
        deliveryService.deleteDeliveryById(id);
        return "redirect:/deliveries";
    }
}

