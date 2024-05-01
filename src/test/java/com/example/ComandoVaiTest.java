import static org.junit.Assert.*;

import org.junit.Test;

import comandi.ComandoVai;
import partita.Partita;

public class ComandoVaiTest {
    String direzione = "sud";
    Partita partita = new Partita();
    ComandoVai vai = new ComandoVai();

    @Test
    public void testEsegui() {
        vai.setParametro("sud");
        vai.esegui(partita);

        assertEquals(19, partita.getGiocatore().getCfu());
        assertEquals("Aula N10", partita.getStanzaCorrente().getNome());
    }

    @Test
    public void testSetParametro() {
        vai.setParametro(null);
        assertEquals(null, vai.getParametro());
    }
}