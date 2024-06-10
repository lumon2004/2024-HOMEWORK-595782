package com.example.comandi;
import java.util.Scanner;

import com.example.IOConsole;
import com.example.Partita;

@SuppressWarnings("unused")

public class ComandoGuarda extends AbstractComando {
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);
    String parametro = null;
    private final static String NOME = "guarda";

    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
    }
}