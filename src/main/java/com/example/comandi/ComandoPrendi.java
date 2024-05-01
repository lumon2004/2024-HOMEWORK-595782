package comandi;

import attrezzi.Attrezzo;
import io.IOConsole;
import partita.Partita;

public class ComandoPrendi implements Comando {
    private String nomeAttrezzo;
    private final static String NOME = "prendi";
    IOConsole io = new IOConsole();

    @Override
    public void esegui(Partita partita) {
        Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
        partita.getGiocatore().getBorsa().addAttrezzo(a);
        partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
        io.mostraMessaggio("Attrezzo preso!");
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;        
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }

    @Override
    public String getNome() {
        return NOME;
    }
}
