package com.example.comandi;
import java.util.Scanner;

import com.example.IOConsole;
import com.example.Partita;

@SuppressWarnings("unused")

public class ComandoFine extends AbstractComando {
    String parametro = null;
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);
    private final static String NOME = "fine";

    @Override
    public void esegui(Partita partita) {
        partita.setFinita();
        io.mostraMessaggio("Grazie di aver giocato!");
    }
}
