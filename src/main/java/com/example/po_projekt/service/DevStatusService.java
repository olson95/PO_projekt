package com.example.po_projekt.service;

import com.example.po_projekt.entity.DevStatus;
import com.example.po_projekt.repository.DevStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevStatusService {

    @Autowired
    private DevStatusRepository devStatusRepository;

    private static long catId = 1;

    public List<DevStatus> getDevStatuses(){
        return devStatusRepository.findAll();
    }

    public DevStatus getDevStatusById(long id){
        var value = devStatusRepository.findById(id);
        return value.isEmpty()?null:value.get();
    }

    public void addDevStatus(DevStatus devStatus){
        devStatus.setId(catId);
        devStatusRepository.save(devStatus);
        catId++;
    }

    public void updateDevStatus(DevStatus devStatus){
        devStatusRepository.save(devStatus);
    }

    public void deleteDevStatusById(long id) {
        devStatusRepository.deleteById(id);
    }
}

