package com.example.comandi;

import com.example.IO;
import com.example.Partita;

public class ComandoSaluta extends AbstractComando {
    private IO io;
	@Override
	public void esegui(Partita partita) {
		if (partita.getLabirinto().getStanzaCorrente().getPersonaggio() != null) {
			io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().saluta());
        } else {
			io.mostraMessaggio("Non c'è alcun personaggio in questa stanza!");
        }
	}
    
    public void setIO(IO io) {
        this.io = io;
    }
}
