package com.example.comandi;

import com.example.IO;
import com.example.Partita;

public abstract class AbstractComando implements Comando {
    private IO io;
	private String parametro;
	private final static String NOME = "AbstractComando";

	abstract public void esegui(Partita partita);

	@Override
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public IO getIo() {
		return this.io;
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
