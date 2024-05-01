import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import comandi.ComandoPosa;
import io.IOConsole;
import partita.Partita;
import attrezzi.Attrezzo;

public class ComandoPosaTest {
    IOConsole io;
    Partita partita;
    ComandoPosa posa;
    Attrezzo scudo;

    @Before
    public void setUp() {
        io = new IOConsole();
        partita = new Partita();
        posa = new ComandoPosa();
        scudo = new Attrezzo("scudo", 5);
    }

    @Test
    public void testEsegui() {
        posa.setParametro("scudo");
        posa.esegui(partita);

        assertEquals(2, partita.getStanzaCorrente().getNumeroAttrezzi());
    }
}