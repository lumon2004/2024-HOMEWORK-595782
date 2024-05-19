package ambienti;
import attrezzi.Attrezzo;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

@SuppressWarnings("unused")

public class Stanza {
    static final private int NUMERO_MASSIMO_DIREZIONI = 4;
    static final private int NUMERO_MASSIMO_ATTREZZI = 10;

    private String nome;
    protected List<Attrezzo> attrezzi;
    protected int numeroAttrezzi;
    private Map<String, Stanza> stanzeAdiacenti;
    private int numeroStanzeAdiacenti;
    private String[] direzioni;

    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new ArrayList<>();
    }

    public void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
        this.stanzeAdiacenti.put(direzione, stanzaAdiacente);
    }

    public Stanza getStanzaAdiacente(String direzione) {
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
        return this.numeroAttrezzi;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi.add(attrezzo);
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
    	risultato.append("\nUscite: ");
    	for (String direzione : this.direzioni) {
    		if (direzione != null) {
    			risultato.append(" " + direzione);
            }
        }
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

	public String[] getDirezioni() {
		return this.stanzeAdiacenti.keySet().toArray(new String[0]);
    }
}
