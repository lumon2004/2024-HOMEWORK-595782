package ambienti;

import attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
    final static private int SOGLIA_MAGICA_DEFAULT = 3;

    private int contatoreAttrezziPosati;
    private int sogliaMagica;

    public StanzaMagica(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    public StanzaMagica(String nome, int soglia) {
        super(nome);
        this.contatoreAttrezziPosati = 0;
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.contatoreAttrezziPosati++;
        if (this.contatoreAttrezziPosati > this.sogliaMagica) {
            attrezzo = this.modificaAttrezzo(attrezzo);
        }
        if (this.numeroAttrezzi < this.attrezzi.length) {
            this.attrezzi[this.numeroAttrezzi] = attrezzo;
            this.numeroAttrezzi++;
            return true;
        } else {
            return false;
        }
    }

    /*private*/ public Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
        int pesoX2 = attrezzo.getPeso()*2;
        nomeInvertito = nomeInvertito.reverse();
        attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
        return attrezzo;
    }
}