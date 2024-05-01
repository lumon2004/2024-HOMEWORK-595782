package comandi;
import io.IOConsole;
import partita.Partita;

public class ComandoFine implements Comando {
    String parametro = null;
    IOConsole io = new IOConsole();
    private final static String NOME = "fine";

    @Override
    public void esegui(Partita partita) {
        partita.setFinita();
        io.mostraMessaggio("Grazie di aver giocato!");
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
