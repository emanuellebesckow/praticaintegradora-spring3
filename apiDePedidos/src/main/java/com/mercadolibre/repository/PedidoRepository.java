package com.mercadolibre.repository;

import com.mercadolibre.model.Pedido;
import com.mercadolibre.model.Prato;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {

    List<Pedido> listaPedidos = new ArrayList<>();

    public Pedido createPedido(Pedido p) {
        listaPedidos.add(p);
        return p;
    }

    public String deletePedidoPorId(int id) {
        for (Pedido p : listaPedidos) {
            if (p.getId() == id) {
                listaPedidos.remove(p);
                return "Apagado com sucesso!";
            }
        }
        return "Não encontrado";
    }


}
