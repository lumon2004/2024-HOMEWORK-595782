package giocatore;
import attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			return false;
		}
		if (this.numeroAttrezzi==10) {
			return false;
		}
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null) {
				if (attrezzo.getNome().equals(nomeAttrezzo)) {
					attrezzoCercato = attrezzo;
					break;
				}
			}
		}
		return attrezzoCercato;	
	}

	public int getPeso() {
		int peso = 0;
		if (numeroAttrezzi==0) {
			return peso;
		} else {
			for (int i= 0; i<this.numeroAttrezzi; i++) {
				peso += this.attrezzi[i].getPeso();
			}
		}
		return peso;
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
			int i = 0;
			for (Attrezzo att : this.attrezzi) {
				if(att != null) {
					if(att.getNome().equals(nomeAttrezzo)) {
						a = att;
						this.attrezzi[i] = null;
						this.numeroAttrezzi--;
					}
				}
				i++;
			}
		}
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty() && this.attrezzi != null) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++) {
				if (this.attrezzi[i] != null) {
					s.append(attrezzi[i].toString()+" ");
				} else {
					s.append("Elemento attrezzo[" + i + "] è null ");
				}
			}
		} else {
			s.append("Borsa vuota");
		}
		return s.toString();
	}
}