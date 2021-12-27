package com.mercadolibre.repository;


import com.mercadolibre.model.Prato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PratoRepository {

    List<Prato> listaPratos = new ArrayList<>(
            Arrays.asList(Prato.builder().id(1).preco(10.50).descricao("Guarnição de arroz").build(),
                    Prato.builder().id(2).preco(10.50).descricao("Guarnição de feijão").build(),
                    Prato.builder().id(3).preco(15).descricao("Porção de fritas").build(),
                    Prato.builder().id(4).preco(5.60).descricao("Ovo frito").build(),
                    Prato.builder().id(5).preco(10).descricao("Frango assado").build(),
                    Prato.builder().id(6).preco(7).descricao("Guarnição Farofa").build())
    );

    public Prato createPrato(Prato prato) {
        listaPratos.add(prato);
        return prato;
    }

    public Prato updatePrato(Prato prato) {
        for (Prato p : listaPratos) {
            if (p.getId() == prato.getId()) {
                listaPratos.set(listaPratos.indexOf(p), prato);
                return prato;
            }
        }
        return null;
    }

    public String deletePratoPorId(int id) {
        for (Prato p : listaPratos) {
            if (p.getId() == id) {
                listaPratos.remove(p);
                return "Apagado com sucesso!";
            }
        }
        return null;
    }

    public List<Prato> getPratos() {
        return listaPratos;
    }

    public <Optional> Prato getPratoPorId(int id) {
        for (Prato p : listaPratos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


}