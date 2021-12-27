package com.mercadolibre.repository;

import com.mercadolibre.model.Pedido;
import com.mercadolibre.model.Prato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {

    List<Pedido> listaPedidos = new ArrayList<>();

    public Pedido createPedido(Pedido p) {
        listaPedidos.add(p);
        return p;
    }

}
