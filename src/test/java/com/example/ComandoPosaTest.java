import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ambienti.*;
import comandi.ComandoPosa;
import io.IOConsole;
import partita.Partita;
import attrezzi.Attrezzo;

public class ComandoPosaTest {
    IOConsole io;
    Partita partita;
    ComandoPosa posa;
    Attrezzo scudo;
    Labirinto labirinto;

    @Before
    public void setUp() {
        io = new IOConsole();
        labirinto = new LabirintoBuilder()
            .addStanzaIniziale("Cucina")
            .addAttrezzo("coltello", 1)
            .addStanzaVincente("Salone")
            .addAdiacenza("Cucina", "Salone", "nord")
            .getLabirinto();
        partita = new Partita(labirinto);
        posa = new ComandoPosa();
        scudo = new Attrezzo("scudo", 5);
    }

    @Test
    public void testAttrezzoPosato() {
        partita.getGiocatore().getBorsa().addAttrezzo(scudo);
        posa.setParametro("scudo");
        posa.esegui(partita);
        assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("scudo"));
    }

    @Test
    public void testAttrezzoPosatoNull() {
        posa.setParametro("forchetta");
        posa.esegui(partita);
        assertFalse(partita.getStanzaCorrente().hasAttrezzo("forchetta"));
    }
}