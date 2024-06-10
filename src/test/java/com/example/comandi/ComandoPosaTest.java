package com.example.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

import com.example.*;
import com.example.ambienti.*;
import com.example.attrezzi.Attrezzo;

public class ComandoPosaTest {
    ComandoPosa posa;
    Partita partita;
    Labirinto labirinto;
    IO io;
    Attrezzo telecomando;

    @Before
    public void setUp() throws Exception {
        posa = new ComandoPosa();
        labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
            // .addStanzaIniziale("Salotto")
            // .getLabirinto();
        partita = new Partita(labirinto);
        io = new IOConsole(new Scanner(System.in));
        telecomando = new Attrezzo("telecomando", 1);
    }

    @Test
    public void testPosaAttrezzo() {
        partita.getGiocatore().getBorsa().addAttrezzo(telecomando);
        posa.setParametro("telecomando");
        posa.esegui(partita);
        assertEquals(2, partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi());
    }

    @Test
    public void testPosaAttrezzoNonInBorsa() {
        posa.setParametro("telecomando");
        posa.esegui(partita);
        assertEquals(1, partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi());
    }
}