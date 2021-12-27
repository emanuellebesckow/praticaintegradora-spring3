package com.mercadolibre.service;

import com.mercadolibre.model.Mesa;
import com.mercadolibre.model.Pedido;
import com.mercadolibre.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Service
public class MesaService {

    @Autowired
    MesaRepository mesaRepository;
    @Autowired
    PedidoService pedidoService;

    public Mesa listarPedidoNaMesa(int idMesa){

        List<Pedido> pedidos = pedidoService.findAll();

        pedidos.stream().filter(pedido -> pedido.getId() == idMesa);

        AtomicReference<Double> totalMesa = new AtomicReference<>((double) 0); //referencia atomica para o stream que faz calculo

        pedidos.stream().forEach(pedido -> {
            totalMesa.accumulateAndGet(pedido.getTotal(), Double::sum);
        });

        return null;
    }



}
