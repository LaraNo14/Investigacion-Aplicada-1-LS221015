package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.productoModel;

@Repository
public interface productoRepository extends CrudRepository<productoModel, Long>{
    public abstract ArrayList<productoModel> findBynombre (String nombre);
}
