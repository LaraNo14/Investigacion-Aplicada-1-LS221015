package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.productoModel;
import com.example.demo.repositories.productoRepository;

@Service
public class productoService {
    @Autowired
    productoRepository productoRepository;

    public ArrayList<productoModel> obtenerProductos(){
        return (ArrayList<productoModel>) productoRepository.findAll();
    }

    public productoModel guardarProducto(productoModel productoModel){
        return productoRepository.save(productoModel);
    }

    public Optional<productoModel> obtenerPorId(long id){
        return productoRepository.findById(id);
    }

    public ArrayList<productoModel> obtenerPorNombre(String nombre){
        return productoRepository.findBynombre(nombre);
    }

    public boolean eliminarProducto(Long id){
        try{
            productoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
