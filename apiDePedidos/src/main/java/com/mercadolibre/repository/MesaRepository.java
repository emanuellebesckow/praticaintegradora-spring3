package com.mercadolibre.repository;

import com.mercadolibre.model.Mesa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MesaRepository {

    List<Mesa> listaMesa = new ArrayList<>(
            Arrays.asList(Mesa.builder().id(1).build(),
                    Mesa.builder().id(2).build(),
                    Mesa.builder().id(3).build(),
                    Mesa.builder().id(4).build())

    );

    public List<Mesa> getMesas() {
        return listaMesa;
    }

    public Mesa getMesa(int id) {

        Mesa mesaSelecionada;
        for (Mesa m : listaMesa) {
            if (m.getId() == id) {
                return m;
            }

        }
        return null;
        //Optional<Mesa> mesa = listaMesa.stream().filter(mesa -> mesa.getId() == id).findFirst();
        // return mesa.get();
    }
}



