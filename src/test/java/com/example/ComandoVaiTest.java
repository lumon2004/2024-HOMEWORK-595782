import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import ambienti.*;
import comandi.ComandoVai;
import partita.Partita;

public class ComandoVaiTest {
    String direzione;
    Partita partita;
    ComandoVai vai;
    Labirinto labirinto;
    Stanza s1;
    Stanza s2;

    @Before
    public void setUp() {
        direzione = "nord";
        vai = new ComandoVai();
        labirinto = new LabirintoBuilder()
            .addStanzaIniziale("Sala Hobby")
            .addAttrezzo("MacBook", 4)
            .addStanzaVincente("Garage")
            .addAdiacenza("Sala Hobby", "Garage", "nord")
            .getLabirinto();
        partita = new Partita(labirinto);
        s1 = new Stanza("Room 1");
        s2 = new Stanza("Room 2");
    }

    @Test
    public void testVaiNull() {
        partita.setStanzaCorrente(s1);
        vai.esegui(partita);
        assertEquals(s1, partita.getStanzaCorrente());
    }

    @Test
    public void testVaiDirezioneEsistente() {
        vai.setParametro("nord");
        vai.esegui(partita);
        assertEquals("Garage", partita.getLabirinto().getStanzaCorrente().getNome());
    }

    @Test
    public void testVaiDirezioneInesistente() {
        vai.setParametro("In fondo a destra");
        vai.esegui(partita);
        assertNotEquals("Garage", partita.getLabirinto().getStanzaCorrente().getNome());
    }
}