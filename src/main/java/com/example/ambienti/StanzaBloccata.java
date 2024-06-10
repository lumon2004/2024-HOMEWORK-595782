package com.example.ambienti;

public class StanzaBloccata extends Stanza {
    Direzione direzioneBloccata;
    String nomeAttrezzo;

    public StanzaBloccata (String nome, Direzione dirBloc, String attrezzoUtile) {
        super(nome);
        this.direzioneBloccata = dirBloc;
        this.nomeAttrezzo = attrezzoUtile;
    }

    @Override
    public Stanza getStanzaAdiacente(Direzione direzioneBloccata) {
        int trovato = 0;
        for (int i=0; i<super.getNumeroAttrezzi(); i++) {
            if (nomeAttrezzo.equals(super.getAttrezzo(nomeAttrezzo).getNome())) {
                trovato = 1;
                break;
            }
        }
        if (trovato == 0) {
            return this;
        } else {
            return super.getStanzaAdiacente(direzioneBloccata);
        }
    }

    @Override
    public String getDescrizione() {        
        if (!this.hasAttrezzo(nomeAttrezzo)) {
            return "Non hai modo di proseguire!\n";
        } else {
            return super.toString();
        }
    }
}
