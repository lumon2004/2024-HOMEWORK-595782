package comandi;
import io.IOConsole;
import partita.Partita;

public class ComandoGuarda implements Comando {
    IOConsole io = new IOConsole();
    String parametro = null;
    private final static String NOME = "guarda";

    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
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