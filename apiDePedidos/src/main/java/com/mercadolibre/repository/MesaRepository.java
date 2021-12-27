package com.mercadolibre.repository;

import com.mercadolibre.model.Mesa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MesaRepository {

    List<Mesa> listaMesa = new ArrayList<>(
            Arrays.asList(Mesa.builder().id(1).build(),
                    Mesa.builder().id(2).build(),
                    Mesa.builder().id(3).build(),
                    Mesa.builder().id(4).build())

    );

    public List<Mesa> getMesa(){
        return listaMesa;
    }

}
