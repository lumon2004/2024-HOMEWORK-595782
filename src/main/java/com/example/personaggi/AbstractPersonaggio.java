package com.example.personaggi;

import com.example.Partita;
import com.example.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
    private String nome;
    private String presentazione;
    private boolean haSalutato;

    public AbstractPersonaggio(String nome, String presentazione) {
        this.nome = nome;
        this.presentazione = presentazione;
        this.haSalutato = false;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPresentazione() {
        return this.presentazione;
    }
    public void setPresentazione(String presentazione) {
        this.presentazione = presentazione;
    }
    public boolean haSalutato() {
        return this.haSalutato;
    }
    public void setHaSalutato(boolean haSalutato) {
        this.haSalutato = haSalutato;
    }

    public String saluta() {
        StringBuilder risposta = new StringBuilder("Ciao, io sono ");
        risposta.append(this.getNome() + ".");
        if (!haSalutato) {
            risposta.append(this.presentazione);
        } else {
            risposta.append("Ci siamo già salutati!");
        }
        this.haSalutato = true;
        return risposta.toString();
    }

    abstract public String agisci(Partita partita);

    @Override
    public String toString() {
        return this.getNome();
    }

    abstract public String riceviRegalo(Attrezzo attrezzo, Partita partita);
}