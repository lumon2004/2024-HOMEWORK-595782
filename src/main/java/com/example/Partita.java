package com.example;

import com.example.ambienti.Labirinto;
import com.example.giocatore.Giocatore;
import com.example.ambienti.Stanza;

public class Partita {
	private Labirinto labirinto;
	private Giocatore giocatore;
	private boolean finita;
	private Stanza stanzaCorrente;

	public Partita() {
		labirinto = new Labirinto();
		giocatore = new Giocatore();
		labirinto.creaStanze();
		this.finita = false;
		stanzaCorrente = labirinto.getStanzaCorrente();
	}

	public Partita(Labirinto labirinto){
		this.labirinto = labirinto;
		giocatore = new Giocatore();
		this.finita = false;
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaCorrente = stanza;
	}

	public boolean vinta() {
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	public boolean isFinita() {
		return finita || vinta() || (this.getGiocatore().getCfu() == 0);
	}

	public void setFinita() {
		this.finita = true;
	}

    public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu()>0;
	}
}