package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.productoModel;
import com.example.demo.services.*;

@RestController
@RequestMapping("/producto")
public class productoController {
    @Autowired
    productoService productoService;

    @GetMapping()
    public ArrayList<productoModel> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    @PostMapping()
    public productoModel guardarProducto(@RequestBody productoModel producto){
        return this.productoService.guardarProducto(producto);

    }

    @GetMapping("/{id}")
    public Optional<productoModel> obtenerPorId(@PathVariable long id){
        return productoService.obtenerPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public ArrayList<productoModel> obtenerPorNombre(@PathVariable String nombre){
        return productoService.obtenerPorNombre(nombre);
    }

    @DeleteMapping (path = "/{id}")
    public String eliminarPorId(@PathVariable ("id") Long id){
        boolean ok = this.productoService.eliminarProducto(id);
        if(ok){
            return "Producto eliminado correctamente";
        }else{
            return "No se pudo eliminar el producto";
        }
    }
    

}
