package ambienti;
import attrezzi.Attrezzo;

public class Stanza {
    static final private int NUMERO_MASSIMO_DIREZIONI = 4;
    static final private int NUMERO_MASSIMO_ATTREZZI = 10;

    private String nome;
    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;
    private Stanza[] stanzeAdiacenti;
    private int numeroStanzeAdiacenti;
    private String[] direzioni;

    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
    }

    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
        for (int i=0; i<this.direzioni.length; i++) {
            if (direzione.equals(this.direzioni[i])) {
                this.stanzeAdiacenti[i] = stanza;
                aggiornato = true;
            }            
        }
        if (!aggiornato) {
            if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
                this.direzioni[numeroStanzeAdiacenti] = direzione;
                this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
                this.numeroStanzeAdiacenti++;
            }
        }
    }

    public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
        for (int i=0; i<this.numeroStanzeAdiacenti; i++) {
            if (this.direzioni[i].equals(direzione)) {
                stanza = this.stanzeAdiacenti[i];
            }
        }
        return stanza;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescrizione() {
        return this.toString();
    }

    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }

    public int getNumeroAttrezzi() {
        return this.numeroAttrezzi;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi[numeroAttrezzi] = attrezzo;
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }
    
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite:");
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	if (this.numeroAttrezzi > 0) {
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo != null) {
					risultato.append(attrezzo.toString() + " ");
				}
			}
		} else {
			risultato.append("Nessun attrezzo presente");
		}
    	return risultato.toString();
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo.getNome().equals(nomeAttrezzo)) {
				trovato = true;
            }
		}
		return trovato;
	}
    
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++) {
            if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
                return this.attrezzi[i];
            }
        }
        return null; // Restituisce null se l'attrezzo non è presente nella stanza
    }    

    public boolean removeAttrezzo(Attrezzo attrezzo) {
		for (int i = 0; i < this.numeroAttrezzi; i++) {
			if (this.attrezzi[i] != null && this.attrezzi[i].equals(attrezzo)) {
				this.attrezzi[i] = null;
				for (int j = i; j < this.numeroAttrezzi - 1; j++) {
					this.attrezzi[j] = this.attrezzi[j + 1];
				}
				this.numeroAttrezzi--;
				return true;
			}
		}
		return false;
	}

	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++) {
	    	direzioni[i] = this.direzioni[i];
        }
	    return direzioni;
    }
}
