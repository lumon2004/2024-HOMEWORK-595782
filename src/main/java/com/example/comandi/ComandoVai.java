package com.example.comandi;

import java.util.Scanner;

import com.example.IOConsole;
import com.example.Partita;
import com.example.ambienti.*;

@SuppressWarnings("unused")

public class ComandoVai extends AbstractComando {
    Direzione direzione;
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);
    private final static String NOME = "vai";

    @Override
    public void esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
        Stanza prossimaStanza = null;

        if (direzione == null) {
            io.mostraMessaggio("Dove vuoi andare?\nDevi specificare una direzione");
            return;
        }
        prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
        if (prossimaStanza == null) {
            io.mostraMessaggio("Direzione inesistente");
            return;
        }
        
        partita.getLabirinto().setStanzaCorrente(prossimaStanza);
        io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
    }

    public void setParametro(String parametro) {
        try {
            this.direzione = Direzione.valueOf(parametro.toString());
        } catch (IllegalArgumentException e) {
            this.direzione = null;
        }
    }
}
