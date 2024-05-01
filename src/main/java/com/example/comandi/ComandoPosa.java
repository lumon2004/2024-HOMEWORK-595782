package comandi;

import attrezzi.Attrezzo;
import io.IOConsole;
import partita.Partita;

public class ComandoPosa implements Comando {
    private String nomeAttrezzo;
    private final static String NOME = "posa";
    IOConsole io = new IOConsole();

    @Override
    public void esegui(Partita partita) {
        Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
        io.mostraMessaggio("Attrezzo posato!");
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