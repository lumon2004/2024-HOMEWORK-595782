package com.example.comandi;

import com.example.personaggi.AbstractPersonaggio;

import java.util.Scanner;

import com.example.IOConsole;
import com.example.Partita;
import com.example.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
    private String nomeAttrezzo;
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);

    @Override
    public void esegui(Partita partita) {
        Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
        AbstractPersonaggio aP = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
        if (a != null && aP != null) {            
            partita.getLabirinto().getStanzaCorrente().getPersonaggio().riceviRegalo(a, partita);
            partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
            io.mostraMessaggio("Attrezzo regalato!");
        } else {
            io.mostraMessaggio("Non puoi regalarlo, non ce l'hai!");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
}
