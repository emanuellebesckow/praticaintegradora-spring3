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

    //TODO - Colocar quantidade no calculo do total

    @Autowired
    PedidoRepository pedidoRepository;

    private static int ID = 0;

    public Pedido adicionarPratoAoPedido(List<Prato> listaPratos, int idMesa) {
        AtomicReference<Double> totalPratos = new AtomicReference<>((double) 0); //referencia atomica para o stream

        listaPratos.stream().forEach(prato -> {
            totalPratos.accumulateAndGet((prato.getPreco()*prato.getQuantidade()), Double::sum);
        });

        ID ++;
        Pedido pedido = Pedido.builder().listaPratos(listaPratos).idMesa(idMesa).id(ID).total(totalPratos.get()).build();

        pedidoRepository.createPedido(pedido);
        return pedido;
    }

    public List<Pedido> findAll() {
        return pedidoRepository.getPedido();
    }
}
