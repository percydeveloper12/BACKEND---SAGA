package com.upn.reclutamiento.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upn.reclutamiento.demo.model.Cargo;
import com.upn.reclutamiento.demo.repository.CargoRepository;

@RestController
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping("/api/cargos")
    public List<Cargo> listarCargos() {
        return cargoRepository.findAll();
    }
}
