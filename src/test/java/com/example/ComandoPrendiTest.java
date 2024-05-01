import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comandi.ComandoPrendi;
import io.IOConsole;
import partita.Partita;

public class ComandoPrendiTest {
    IOConsole io;
    Partita partita;
    ComandoPrendi prendi;

    @Before
    public void setUp() {
        io = new IOConsole();
        partita = new Partita();
        prendi = new ComandoPrendi();
    }

    @Test
    public void testEsegui() {
        prendi.setParametro("osso");
        prendi.esegui(partita);

        assertEquals(0, partita.getStanzaCorrente().getNumeroAttrezzi());
    }
}