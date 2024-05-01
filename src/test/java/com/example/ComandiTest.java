import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comandi.*;
import partita.Partita;

public class ComandiTest {
    Partita partita;
    ComandoVai vai;
    ComandoPrendi prendi;
    ComandoPosa posa;
    
    @Before
    public void setUp() {
        partita = new Partita();
        vai = new ComandoVai();
        prendi = new ComandoPrendi();
        posa = new ComandoPosa();
    }

    @Test
    public void testDoppioPrendi() {
        /* sei in atrio */
        assertEquals("Atrio", partita.getLabirinto().getStanzaCorrente().getNome());

        /* prendi osso */
        prendi.setParametro("osso");
        prendi.esegui(partita);
        assertEquals(0, partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi());

        /* vai sud */
        vai.setParametro("sud");
        vai.esegui(partita);
        assertEquals("Aula N10", partita.getLabirinto().getStanzaCorrente().getNome());
        
        /* sei in Aula N10, posa osso */
        posa.setParametro("osso");
        posa.esegui(partita);

        /* controlla che osso sia in atrio */        
        assertEquals(2, partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi());
    }
}