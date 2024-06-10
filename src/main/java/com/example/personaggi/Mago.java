package com.example.personaggi;

import com.example.Partita;
import com.example.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
    private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, con una mia magica azione troverai un nuovo oggetto per il tuo borsone!";
    private static final String MESSAGGIO_SCUSE = "Mi dispiace, ma non ho più nulla!";
    private Attrezzo attrezzo;
    
    public Mago(String nome, String presentazione, Attrezzo attrezzo) {
        super(nome, presentazione);
        this.attrezzo = attrezzo;
    }

    public Attrezzo getAttrezzo() {
        return this.attrezzo;
    }

    @Override
    public String agisci(Partita partita) {
        String msg;
        if (this.attrezzo != null) {
            partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
            this.attrezzo = null;
            msg = MESSAGGIO_DONO;
        } else {
            msg = MESSAGGIO_SCUSE;
        }
        return msg;
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
        if (attrezzo != null) {
            partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo.getNome()).setPeso(attrezzo.getPeso()/2);
            partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
        }
        return MESSAGGIO_DONO;
    }
}
