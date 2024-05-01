package ambienti;

public class StanzaBuia extends Stanza {
    private String nomeAttrezzo;

    public StanzaBuia(String nome, String attrezzoNecessario) {
        super(nome);
        this.nomeAttrezzo = attrezzoNecessario;
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
            return "Qui c'è buio pesto!\n";
        } else {
            return super.toString();
        }
    }
}
