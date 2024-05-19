import static org.junit.Assert.*;
import org.junit.Test;

import attrezzi.Attrezzo;
import ambienti.*;

public class LabirintoBuilderTest {
	LabirintoBuilder lb = new LabirintoBuilder();

	@Test
	public void testAddStanza() {
		lb.addStanza("stanzetta");
		assertEquals("stanzetta", lb.getNome2stanza().get("stanzetta").getNome());
	}

	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta() {
		assertEquals(LabirintoBuilder.class, lb.addAttrezzo("cacciavite", 3).getClass());
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta(){
		lb.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
		Attrezzo expected = new Attrezzo("cacciavite", 3);
		assertEquals(expected, lb.getLabirinto().getStanzaCorrente().getAttrezzo("cacciavite"));		
	}

	@Test
    public void testAddAttrezzoConStanza() {
        lb.addStanza("stanzetta");
        lb.addAttrezzo("cacciavite", 3);
        assertTrue(lb.getNome2stanza().get("stanzetta").hasAttrezzo("cacciavite"));
    }
}


