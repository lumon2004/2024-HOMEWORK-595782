package com.example.personaggi;

import com.example.Partita;
import com.example.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
    public static final String RINGHIO = "Grrrr!";
    public static final String CIBO_PREFERITO = "osso";

    public Cane(String nome, String presentazione) {
        super(nome, presentazione);
    }

    @Override
    public String agisci(Partita partita) {
        this.morde(partita);
        return RINGHIO;
    }

    public void morde(Partita partita) {
        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
        if (attrezzo.getNome().equals(CIBO_PREFERITO)) {
            partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
            return this.getPresentazione();
        } else {
            partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
            return RINGHIO;
        }
    }
}
