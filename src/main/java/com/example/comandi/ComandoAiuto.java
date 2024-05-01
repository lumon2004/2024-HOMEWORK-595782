package comandi;

import io.IOConsole;
import partita.Partita;

public class ComandoAiuto implements Comando {
    static final public String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
    private final static String NOME = "aiuto";
    String parametro = null;
    IOConsole io = new IOConsole();

    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio("Questi sono i comandi del gioco:");
        for (int i=0; i<elencoComandi.length; i++) {
            io.mostraMessaggio(elencoComandi[i]+ " ");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.parametro = null;
    }

    @Override
    public String getParametro() {
        return this.parametro;
    }

    @Override
    public String getNome() {
        return NOME;
    }
}