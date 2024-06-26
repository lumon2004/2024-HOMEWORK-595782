package com.example.comandi;

import java.util.Scanner;

import com.example.IOConsole;
import com.example.Partita;
import com.example.attrezzi.Attrezzo;

@SuppressWarnings("unused")

public class ComandoPosa extends AbstractComando {
    private String nomeAttrezzo;
    private final static String NOME = "posa";
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);

    @Override
    public void esegui(Partita partita) {
        Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
        if (a != null) {
            partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
            partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
            io.mostraMessaggio("Attrezzo posato!");
        } else {
            io.mostraMessaggio("Non hai questo attrezzo nella borsa!");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
}