import static org.junit.Assert.*;

import org.junit.Test;

import ambienti.StanzaMagica;
import attrezzi.Attrezzo;

public class StanzaMagicaTest {
    StanzaMagica staMag = new StanzaMagica("Sala delle Meraviglie");
    Attrezzo spada = new Attrezzo("spada", 8);
    Attrezzo ascia = new Attrezzo("ascia", 5);
    Attrezzo scudo = new Attrezzo("scudo", 7);
    Attrezzo martello = new Attrezzo("martello", 10);

    @Test
    public void testAddAttrezzo() {
        assertEquals(true, staMag.addAttrezzo(spada));
    }

    @Test
    public void testModificaAttrezzo() {
        staMag.addAttrezzo(spada);
        staMag.addAttrezzo(ascia);
        staMag.addAttrezzo(scudo);
        staMag.addAttrezzo(martello);
        assertEquals("olletram", staMag.modificaAttrezzo(martello).getNome());
        assertEquals(20, staMag.modificaAttrezzo(martello).getPeso());
    }
}