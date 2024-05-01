package ambienti;

public class StanzaBloccata extends Stanza {
    String direzioneBloccata;
    String nomeAttrezzo;

    public StanzaBloccata (String nome, String dirBloc, String attrezzoUtile) {
        super(nome);
        this.direzioneBloccata = dirBloc;
        this.nomeAttrezzo = attrezzoUtile;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzioneBloccata) {
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
        int trovato = 0;
        for (int i=0; i<super.getNumeroAttrezzi(); i++) {
            if (nomeAttrezzo.equals(super.getAttrezzo(nomeAttrezzo).getNome())) {
                trovato = 1;
                break;
            }
        }
        if (trovato == 0) {
            return "Non hai modo di proseguire!\n";
        } else {
            return super.toString();
        }
    }
}
