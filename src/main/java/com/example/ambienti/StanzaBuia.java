package com.example.ambienti;

public class StanzaBuia extends Stanza {
    private String nomeAttrezzo;

    public StanzaBuia(String nome, String attrezzoNecessario) {
        super(nome);
        this.nomeAttrezzo = attrezzoNecessario;
    }
    
    @Override
    public String getDescrizione() {
        if (!this.hasAttrezzo(nomeAttrezzo)) {
            return "Qui c'è buio pesto!\n";
        } else {
            return super.getDescrizione();
        }
    }
}
