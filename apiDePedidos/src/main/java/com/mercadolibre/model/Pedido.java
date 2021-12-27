package com.mercadolibre.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pedido implements Serializable {

    private static final long serialVersionUID = -6742351743562212951L;
		
	private int id;
    private int idMesa;
    private List<Prato> listaPratos;
    private double total;

}
