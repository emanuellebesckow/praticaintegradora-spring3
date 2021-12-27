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
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1286232969462275287L;
	
    private int id;
    private List<Pedido> pedidos;
    private double total;

}
