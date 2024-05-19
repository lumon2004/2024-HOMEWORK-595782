import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ambienti.*;
import comandi.ComandoPrendi;
import comandi.ComandoVai;
import io.IOConsole;
import partita.Partita;

public class ComandoPrendiTest {
    IOConsole io;
    Partita partita;
    ComandoPrendi prendi;
    Labirinto labirinto;
    ComandoVai vai;

    @Before
    public void setUp() {
        io = new IOConsole();
        labirinto = new LabirintoBuilder()
            .addStanzaIniziale("Camera da letto")
            .addAttrezzo("candela", 1)
            .addStanzaVincente("Bagno")
            .addAdiacenza("Camera da letto", "Bagno", "sud")
            .getLabirinto();
        partita = new Partita(labirinto);
        prendi = new ComandoPrendi();
        vai = new ComandoVai();
    }

    @Test
    public void testAttrezzoPreso() {
        prendi.setParametro("candela");
        prendi.esegui(partita);
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("candela"));
    }
}