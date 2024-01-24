package com.example.po_projekt.service;

import com.example.po_projekt.entity.Form;
import com.example.po_projekt.entity.Product;
import com.example.po_projekt.repository.FormRepository;
import com.example.po_projekt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FormService {
    @Autowired
    FormRepository formRepository;

    private static long nextId = 1;

    public FormService() {
    }

    private boolean isEmpty() {
        return formRepository.count() == 0;
    }

    public List<Form> getFormList() {
        return formRepository.findAll();
    }

    public void addForm(Form form) {
//        validateProduct(product);
        form.setId(nextId);
        form.setDate(LocalDate.now());
        formRepository.save(form);
        nextId++;
    }

    public Form getFormById(long id) {
        var value = formRepository.findById(id);
        return value.isEmpty() ? null : value.get();
    }

    public Form getForm(Form form) {
        return getFormById(form.getId());
    }

    public void updateForm(Form form) {
        formRepository.save(form);
    }



    public void deleteForm(Form form) {
        formRepository.deleteById(form.getId());
    }

    public void deleteFormById(long id) {
        formRepository.deleteById(id);
    }
}
