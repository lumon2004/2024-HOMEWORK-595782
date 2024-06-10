package com.example.comandi;

import com.example.IO;
import com.example.Partita;
import com.example.personaggi.AbstractPersonaggio;

public abstract class ComandoInteragisci extends AbstractComando {
    private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?";
    private String messaggio;
    private IO io;

    @Override
    public void esegui(Partita partita) {
        AbstractPersonaggio personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
        if (personaggio != null) {
            this.messaggio = personaggio.agisci(partita);
            io.mostraMessaggio(this.messaggio);
        } else {
            io.mostraMessaggio(MESSAGGIO_CON_CHI);
        }
    }

    public String getMessaggio() {
        return this.messaggio;
    }

    public void setIo(IO io) {
        this.io = io;
    }
}
