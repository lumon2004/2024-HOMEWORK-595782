package com.example.comandi;

import com.example.Partita;

public interface Comando {
    public void esegui(Partita partita);

    public void setParametro(String parametro);

    public String getParametro();
    
    public String getNome();
}
