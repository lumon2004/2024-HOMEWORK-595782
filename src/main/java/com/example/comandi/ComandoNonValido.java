package com.example.comandi;
import java.util.Scanner;

import com.example.IOConsole;
import com.example.Partita;

@SuppressWarnings("unused")

public class ComandoNonValido extends AbstractComando {
    private final static String NOME = "comando non valido";
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);
    String parametro = null;
    
    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio("Comando non valido");
    }
}