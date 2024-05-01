package comandi;

import ambienti.Stanza;
import io.IOConsole;
import partita.Partita;

public class ComandoVai implements Comando {
    private String direzione;
    IOConsole io = new IOConsole();
    private final static String NOME = "vai";

    @Override
    public void esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
        Stanza prossimaStanza = null;

        if (direzione == null) {
            io.mostraMessaggio("Dove vuoi andare?\nDevi specificare una direzione");
            return;
        }

        prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

        if (prossimaStanza == null) {
            io.mostraMessaggio("Direzione inesistente");
            return;
        }
        
        partita.getLabirinto().setStanzaCorrente(prossimaStanza);
        io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    @Override
    public String getParametro() {
        return this.direzione;
    }

    @Override
    public String getNome() {
        return NOME;
    }
}
