package com.example.comandi;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.IOConsole;
import com.example.Partita;
import com.example.ambienti.*;
import java.util.Scanner;

public class ComandoPrendiTest {
    IOConsole io;
    Partita partita;
    ComandoPrendi prendi;
    Labirinto labirinto;
    ComandoVai vai;
    Direzione sud;

    @Before
    public void setUp() throws Exception {
        io = new IOConsole(new Scanner(System.in));
        labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
            // .addStanzaIniziale("Camera da letto")
            // .addAttrezzo("candela", 1)
            // .addStanzaVincente("Bagno")
            // .addAdiacenza("Camera da letto", "Bagno", sud)
            // .getLabirinto();
        partita = new Partita(labirinto);
        prendi = new ComandoPrendi();
        vai = new ComandoVai();
    }

    @Test
    public void testAttrezzoPreso() {
        prendi.setParametro("martello");
        prendi.esegui(partita);
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }

    @Test
    public void testAttrezzoNonPreso() {
        prendi.setParametro("paperino");
        prendi.esegui(partita);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("paperino"));
    }
}