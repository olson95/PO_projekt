package com.example.po_projekt.controller;

import com.example.po_projekt.entity.Form;
import com.example.po_projekt.service.FormService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FormController {
    private final FormService formService;



    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("/contact")
    public String add(Model model) {
        model.addAttribute("form", new Form());
        return "/contact";
    }

    @PostMapping("/contact")
    public String add(@ModelAttribute Form form) {
        formService.addForm(form);
        return "redirect:/shop";
    }



}
