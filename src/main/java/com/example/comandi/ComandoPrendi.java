package com.example.comandi;

import java.util.Scanner;

import com.example.IOConsole;
import com.example.Partita;
import com.example.attrezzi.Attrezzo;

@SuppressWarnings("unused")

public class ComandoPrendi extends AbstractComando {
    private String nomeAttrezzo;
    private final static String NOME = "prendi";
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);

    @Override
    public void esegui(Partita partita) {
        Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
        int pesoBorsa = partita.getGiocatore().getBorsa().getPeso();
        int pesoBorsaMax = partita.getGiocatore().getBorsa().getPesoMax();
        if (a != null) {
            if (pesoBorsa + a.getPeso() <= pesoBorsaMax) {
                partita.getGiocatore().getBorsa().addAttrezzo(a);
                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
                io.mostraMessaggio("Attrezzo preso!");
            } else {
                io.mostraMessaggio("Borsa piena! Non puoi prendere questo attrezzo.");
            }
        } else {
            io.mostraMessaggio("Attrezzo non esistente!");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
}
