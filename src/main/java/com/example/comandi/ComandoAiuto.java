package com.example.comandi;

import com.example.IOConsole;
import com.example.Partita;
import java.util.Scanner;

@SuppressWarnings("unused")

public class ComandoAiuto extends AbstractComando {
    static final public String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "interagisci", "saluta", "regala", "aiuto", "fine"};
    private final static String NOME = "aiuto";
    String parametro = null;
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);

    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio("Questi sono i comandi del gioco:");
        for (int i=0; i<elencoComandi.length; i++) {
            io.mostraMessaggio(elencoComandi[i]+ " ");
        }
    }
}