package com.example.attrezzi;

import java.util.Objects;

public class Attrezzo {
    private String nome;
    private int peso;

    public Attrezzo(String nome, int peso) {
        this.peso = peso;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String toString() {
        return this.getNome() + " (" + this.getPeso() + " kg)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attrezzo that = (Attrezzo) o;
        return this.getPeso() == that.getPeso() && this.getNome().equals(that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, peso);
    }
}
