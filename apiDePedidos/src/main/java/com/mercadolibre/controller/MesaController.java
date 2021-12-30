package com.mercadolibre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.model.Mesa;
import com.mercadolibre.service.MesaService;

@RestController
@RequestMapping("/mesa")
public class MesaController {
	@Autowired
	MesaService mesaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarMesa(@PathVariable int id) {
		Mesa mesa = mesaService.getMesaComPedidos(id);
		return ResponseEntity.ok(mesa);
	}

}


