package com.mercadolibre.service;

import com.mercadolibre.model.Pedido;
import com.mercadolibre.model.Prato;
import com.mercadolibre.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido adicionarPedidoNaMesa(List<Prato> listaPratos, int idMesa) {

        AtomicReference<Double> totalPratos = new AtomicReference<>((double) 0);

        listaPratos.stream().forEach(prato -> {
            totalPratos.accumulateAndGet(prato.getPreco(), Double::sum);
        });

        Pedido p = Pedido.builder().listaPratos(listaPratos).idMesa(idMesa).total(totalPratos.get()).build();

        pedidoRepository.createPedido(p);
        return p;
    }

}
