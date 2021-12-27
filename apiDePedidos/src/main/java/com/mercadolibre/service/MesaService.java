package com.mercadolibre.service;

import com.mercadolibre.model.Mesa;
import com.mercadolibre.model.Pedido;
import com.mercadolibre.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Service
public class MesaService {

    @Autowired
    MesaRepository mesaRepository;
    @Autowired
    PedidoService pedidoService;

    public Mesa listarPedidoNaMesa(int idMesa){

        List<Pedido> pedidos = pedidoService.findAll();

        List<Pedido> pedidosMesa = pedidos.stream().filter(pedido -> pedido.getIdMesa() == idMesa).collect(toList());

       AtomicReference<Double> totalMesa = new AtomicReference<>((double) 0); //referencia atomica para o stream que faz calculo

        pedidosMesa.stream().forEach(pedido -> {
            totalMesa.accumulateAndGet(pedido.getTotal(), Double::sum);
        });

       mesaRepository.getMesas();
        return null;
    }

}
