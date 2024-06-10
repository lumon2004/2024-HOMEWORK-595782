package com.example.comandi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.example.Partita;
import com.example.ambienti.*;

public class ComandoVaiTest {
    String direzione;
    Partita partita;
    ComandoVai vai;
    Labirinto labirinto;
    Stanza s1;
    Stanza s2;

    @Before
    public void setUp() throws Exception {
        direzione = "nord";
        vai = new ComandoVai();
        labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
            // .addStanzaIniziale("Sala Hobby")
            // .addAttrezzo("MacBook", 4)
            // .addStanzaVincente("Garage")
            // .addAdiacenza("Sala Hobby", "Garage", Direzione.nord)
            // .getLabirinto();
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
        assertEquals("N10", partita.getLabirinto().getStanzaCorrente().getNome());
    }

    @Test
    public void testVaiDirezioneInesistente() {
        vai.setParametro("In fondo a destra");
        vai.esegui(partita);
        assertNotEquals("Garage", partita.getLabirinto().getStanzaCorrente().getNome());
    }
}