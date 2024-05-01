package comandi;
import io.IOConsole;
import partita.Partita;

public class ComandoNonValido implements Comando {
    private final static String NOME = "comando non valido";
    IOConsole io = new IOConsole();
    String parametro = null;
    
    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio("Comando non valido");
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