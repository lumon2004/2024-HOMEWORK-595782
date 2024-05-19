package giocatore;

import attrezzi.Attrezzo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			return false;
		}
		if (this.numeroAttrezzi==10) {
			return false;
		}
		this.attrezzi.add(attrezzo);
		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return this.pesoMax;
	}

	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.stream()
			.filter(attrezzo -> attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
			.findFirst().
			orElse(null);
	}

	public int getPeso() {
		int peso = 0;
		if (numeroAttrezzi==0) {
			return peso;
		} else {
			return this.attrezzi.stream()
				.mapToInt(Attrezzo::getPeso)
				.sum();
		}
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if (nomeAttrezzo != null) {
			Iterator<Attrezzo> iterator = this.attrezzi.iterator();
			while (iterator.hasNext()) {
				Attrezzo att = iterator.next();
				if (att != null && att.getNome().equals(nomeAttrezzo)) {
					a = att;
					iterator.remove();
					this.numeroAttrezzi--;
					break;
				}
			}
		}
		return a;
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> attrezziOrdinati = new ArrayList<>(this.attrezzi);
		attrezziOrdinati.sort(Comparator.comparingInt(Attrezzo::getPeso).thenComparing(Attrezzo::getNome));
		return attrezziOrdinati;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<>(Comparator.comparing(Attrezzo::getNome).thenComparing(Attrezzo::getPeso));
		attrezziOrdinati.addAll(this.attrezzi);
		return attrezziOrdinati;
	}

	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
        return this.attrezzi.stream().collect(Collectors.groupingBy(Attrezzo::getPeso, Collectors.toSet()));
    }

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty() && this.attrezzi != null) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg):\n\tOrdinato per peso: " + this.getContenutoOrdinatoPerPeso().toString() + "\n\tOrdinato per nome: " + this.getContenutoOrdinatoPerNome().toString() + "\n\tRaggruppato per peso: " + this.getContenutoRaggruppatoPerPeso().toString());
		} else {
			s.append("Borsa vuota");
		}
		return s.toString();
	}
}