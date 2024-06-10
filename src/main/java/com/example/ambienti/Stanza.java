package com.example.ambienti;
import com.example.attrezzi.Attrezzo;
import com.example.personaggi.AbstractPersonaggio;

import java.util.*;

public class Stanza {
    static final private int NUMERO_MASSIMO_DIREZIONI = 4;
    static final private int NUMERO_MASSIMO_ATTREZZI = 10;

    private String nome;
    protected List<Attrezzo> attrezzi;
    private Map<Direzione, Stanza> stanzeAdiacenti;
    @SuppressWarnings("unused")
    private Direzione[] direzioni;
    private AbstractPersonaggio personaggio;

    public Stanza(String nome) {
        this.nome = nome;
        this.direzioni = new Direzione[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new ArrayList<>();
        this.personaggio = null;
    }

	public void setStanzaAdiacente(Direzione direzione, Stanza stanza) {
		boolean aggiornato = false;
		
		if (stanzeAdiacenti.containsKey(direzione)) {
			this.stanzeAdiacenti.put(direzione,stanza);
			aggiornato = true;
		}
		if (!aggiornato) {
			if (this.stanzeAdiacenti.size() < NUMERO_MASSIMO_DIREZIONI) {
				this.stanzeAdiacenti.put(direzione,stanza);
			}
        }
	}

    public Stanza getStanzaAdiacente(Direzione direzione) {
        return this.stanzeAdiacenti.get(direzione);
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescrizione() {
        return this.toString();
    }

    public List<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    public int getNumeroAttrezzi() {
        return this.attrezzi.size();
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi.add(attrezzo);
        	return true;
        }
        else {
        	return false;
        }
    }
    
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append("Sei in " + this.nome);
    	risultato.append("\nUscite: ");
        for (Map.Entry<Direzione,Stanza> entry : this.stanzeAdiacenti.entrySet()) {
            risultato.append(" " + entry.getKey());
        }
    	risultato.append("\nAttrezzi nella stanza: ");
    	if (this.attrezzi.size() > 0) {
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo != null) {
					risultato.append(attrezzo.toString() + " ");
				}
			}
		} else {
			risultato.append("nessun attrezzo presente");
		}
        risultato.append("\nPersonaggio nella stanza: ");
        if (personaggio != null) {            
            risultato.append(personaggio.toString() + " ");
        } else {
            risultato.append("nessun personaggio presente");
        }
    	return risultato.toString();
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.stream()
			.anyMatch(attrezzo -> attrezzo.getNome().equals(nomeAttrezzo));
	}

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Optional<Attrezzo> attrezzoCercato = this.attrezzi.stream()
			.filter(attrezzo -> attrezzo.getNome().equals(nomeAttrezzo))
			.findFirst();			
    	return attrezzoCercato.orElse(null);
	}

    public boolean removeAttrezzo(Attrezzo attrezzo) {
        return this.attrezzi.remove(attrezzo);
	}

	public Direzione[] getDirezioni() {
		return this.stanzeAdiacenti.keySet().toArray(new Direzione[0]);
    }

    public void setPersonaggio(AbstractPersonaggio personaggio) {
        this.personaggio = personaggio;
    }

    public AbstractPersonaggio getPersonaggio() {
        return this.personaggio;
    }
}
