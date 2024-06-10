package com.example.personaggi;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import com.example.Partita;
import com.example.ambienti.*;
import com.example.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
    public static final String MESSAGGIO_BUONO = "Ti mando nella stanza più vicina con più attrezzi!";
    public static final String MESSAGGIO_CATTIVO = "Non mi hai salutata… te ne pentirai!";

    public Strega(String nome, String presentazione) {
        super(nome, presentazione);
    }

    @Override
    public String agisci(Partita partita) {
        String msg;

        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
        Direzione[] direzioni = stanzaCorrente.getDirezioni();
        List<Stanza> adiacenti = new ArrayList<>();

        for (Direzione direzione : direzioni) {
            Stanza stanzaAdiacente = stanzaCorrente.getStanzaAdiacente(direzione);
            if (stanzaAdiacente != null) {
                adiacenti.add(stanzaAdiacente);
            }
        }

        Stanza stanzaTarget = null;
        if (this.haSalutato()) {
            stanzaTarget = adiacenti.stream()
                .max(Comparator.comparingInt(Stanza::getNumeroAttrezzi))
                .orElse(null);
                msg = MESSAGGIO_BUONO;
            } else {
                stanzaTarget = adiacenti.stream()
                .min(Comparator.comparingInt(Stanza::getNumeroAttrezzi))
                .orElse(null);
                msg = MESSAGGIO_CATTIVO;
            }
        if (stanzaTarget != null) {
            partita.getLabirinto().setStanzaCorrente(stanzaTarget);
        }
        return msg;
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
        if (attrezzo != null) {
            // lo trattiene
        }
        return "[Ridacchia]";
    }
}
