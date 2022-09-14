package com.example.crudoperations.controller;

import com.example.crudoperations.model.EmpDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.crudoperations.repository.EmpDataRepository;
import com.example.crudoperations.model.EmpDataModel;
import com.example.crudoperations.repository.EmpDataRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping("/api")
public class EmpController {
    @Autowired
    EmpDataRepository empDataRepository;
    float val = 50;
    @GetMapping("/emp/{id}")
    public ResponseEntity<EmpDataModel> getemployeedatabyId(@PathVariable("id") float id) {
        EmpDataModel empDataModel = empDataRepository.findById(id);
        //System.out.println("Hello world");
        if (empDataModel != null) {
            return new ResponseEntity<>(empDataModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/emp/{id}")
    public ResponseEntity<String> updateEmpdata(@PathVariable("id") float id, @RequestBody EmpDataModel empDataModel) {
        EmpDataModel _empDataModel = empDataRepository.findById(id);
        if (_empDataModel != null) {
            _empDataModel.setId(id);
            _empDataModel.setFname(empDataModel.getFname());
            _empDataModel.setLname(empDataModel.getLname());
            _empDataModel.setTel(empDataModel.getTel());
            _empDataModel.setAddress(empDataModel.getAddress());
            _empDataModel.setCity(empDataModel.getCity());
            _empDataModel.setState(empDataModel.getState());
            _empDataModel.setZip(empDataModel.getZip());
            empDataRepository.update(_empDataModel);
            return new ResponseEntity<>("Employee data was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find employee data with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/emp/{id}")
    public ResponseEntity<String> deleteEmpdata(@PathVariable("id") float id) {
        try {
            int result = empDataRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find Employee data with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Employee data was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete employee data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/emp")
    public ResponseEntity<List<EmpDataModel>> getAllEmployee(@RequestParam(required = false) String title) {
        try {
            List<EmpDataModel> empDataModels = new ArrayList<EmpDataModel>();
            if (title == null)
                empDataRepository.findAll().forEach(empDataModels::add);
            if (empDataModels.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(empDataModels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/emp")
    public ResponseEntity<String> createEmpdata(@RequestBody EmpDataModel empDataModel) {

        try {
            val= val+1;
            empDataRepository.save(new EmpDataModel(val,empDataModel.getFname(), empDataModel.getLname(),empDataModel.getTel(),empDataModel.getAddress(),empDataModel.getCity(),empDataModel.getState(),empDataModel.getZip()));
            return new ResponseEntity<>("Employee data was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
