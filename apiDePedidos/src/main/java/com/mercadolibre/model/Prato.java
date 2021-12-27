package com.mercadolibre.model;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Prato implements Serializable{

    private static final long serialVersionUID = 8394710934602892657L;
    
    
	private int id;
    private double preco;
    private String descricao;
    private int quantidade;

}