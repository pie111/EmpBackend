package com.example.crudoperations.repository;
import com.example.crudoperations.model.EmpDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.crudoperations.model.EmpDataModel;

import java.util.List;

@Repository
public class JdbcEmpRepository implements EmpDataRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
   @Override
    public EmpDataModel findById(float id) {
        try {
            EmpDataModel empDataModel = jdbcTemplate.queryForObject("SELECT * FROM empdata WHERE id=?",
                    BeanPropertyRowMapper.newInstance(EmpDataModel.class), id);
            System.out.println("Hello world");
            return empDataModel;
        } catch (IncorrectResultSizeDataAccessException e) {
            System.out.println("Hello world");
            return null;
        }
    }

    @Override
    public int update(EmpDataModel empDataModel) {
        return jdbcTemplate.update("UPDATE empdata SET fname=?, lname=?, tel=?, address=?, city=?, state=?, zip=? WHERE id=?",
                new Object[] { empDataModel.getFname(), empDataModel.getLname(),empDataModel.getTel(),empDataModel.getAddress(),empDataModel.getCity(),empDataModel.getState(),empDataModel.getZip(), empDataModel.getId() });
    }
   @Override
    public int deleteById(float id) {
        return jdbcTemplate.update("DELETE FROM empdata WHERE id=?", id);
    }
    @Override
    public int save(EmpDataModel empDataModel) {
        System.out.println("Jdbc working");
       return jdbcTemplate.update("INSERT INTO empdata (id,fname, lname, tel,address,city,state,zip) VALUES(?,?,?,?,?,?,?,?)",
                new Object[] { empDataModel.getId(), empDataModel.getFname(), empDataModel.getLname(),empDataModel.getTel(),empDataModel.getAddress(),empDataModel.getCity(),empDataModel.getState(),empDataModel.getZip() });

    }
    @Override
    public List<EmpDataModel> findAll() {
        return jdbcTemplate.query("SELECT * from empdata", BeanPropertyRowMapper.newInstance(EmpDataModel.class));
    }

}
