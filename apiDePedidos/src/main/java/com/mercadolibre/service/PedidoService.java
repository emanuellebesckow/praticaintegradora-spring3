package com.mercadolibre.service;

import com.mercadolibre.model.Pedido;
import com.mercadolibre.model.Prato;
import com.mercadolibre.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido adicionarPedidoNaMesa(List<Prato> listaPratos, int idMesa) {
        AtomicReference<Double> totalPratos = new AtomicReference<>((double) 0); //referencia atomica para o stream

        listaPratos.stream().forEach(prato -> {
            totalPratos.accumulateAndGet(prato.getPreco(), Double::sum);
        });

        Pedido p = Pedido.builder().listaPratos(listaPratos).idMesa(idMesa).total(totalPratos.get()).build();

        pedidoRepository.createPedido(p);
        return p;
    }

    public List<Pedido> findAll() {
        return pedidoRepository.getPedido();
    }
}
