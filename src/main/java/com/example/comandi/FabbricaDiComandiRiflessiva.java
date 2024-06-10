package com.example.comandi;

import java.util.Scanner;

import com.example.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
    private IO io;

    public FabbricaDiComandiRiflessiva(IO io) {
        this.io = io;
    }

    @SuppressWarnings("deprecation")
    @Override
    public Comando costruisciComando(String istruzione) {
        @SuppressWarnings("resource")
        Scanner scannerDiParole = new Scanner(istruzione);
        String nomeComando = null; 
        String parametro = null;
        Comando comando = null;

        if (scannerDiParole.hasNext()) {
            nomeComando = scannerDiParole.next();   // prima parola: nome del comando
        }
        if (scannerDiParole.hasNext()) {
            parametro = scannerDiParole.next();     // seconda parola: eventuale parametro
        }

        try {
            String nomeClasse = "com.example.comandi.Comando";
            nomeClasse += Character.toUpperCase(nomeComando.charAt(0));
            nomeClasse += nomeComando.substring(1);
            comando = (Comando)Class.forName(nomeClasse).newInstance();
            comando.setParametro(parametro);
        } catch (Exception e) {
            comando = new ComandoNonValido();
            this.io.mostraMessaggio("Comando inesistente");
        }
        return comando;
    }
}