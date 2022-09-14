package com.example.crudoperations.repository;
import java.util.List;
import com.example.crudoperations.model.EmpDataModel;

public interface EmpDataRepository {
    int save(EmpDataModel empDataModel);
    int update(EmpDataModel empDataModel);
    int deleteById(float id);
    List<EmpDataModel> findAll();
    EmpDataModel findById(float id);

}
