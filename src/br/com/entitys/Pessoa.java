package br.com.entitys;

import br.com.interfaces.Truncate;
import br.com.interfaces.UpperCase;

/**
 * Created by eml on 27/01/16.
 */
public class Pessoa {
    
	@Truncate(at=5)
	@UpperCase
    private String nome;

    public Pessoa() {
    }

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
}
