package com.mercadolibre.controller;

import com.mercadolibre.model.Pedido;
import com.mercadolibre.model.Prato;
import com.mercadolibre.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<?> mostrarPedidos(){
        List<Pedido> pedido = pedidoService.findAll();
        return ResponseEntity.ok(pedido);
    }

    @PostMapping(value = "/mesa/{idMesa}")
    public ResponseEntity<?> criarPedido(@RequestBody List<Prato> pratos, @PathVariable int idMesa){
        Pedido pedido = pedidoService.adicionarPratoAoPedido(pratos, idMesa);
        return ResponseEntity.ok(pedido);
    }

}
