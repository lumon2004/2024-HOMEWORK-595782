import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

import ambienti.Stanza;
import attrezzi.Attrezzo;

public class StanzaTest {
	Stanza s1 = new Stanza("s1");
	Stanza s2 = new Stanza("s2");
	Attrezzo a = new Attrezzo("martello", 42);

	@Before
	public void setUp() {
		s1.impostaStanzaAdiacente("sud", s2);
		s1.addAttrezzo(a);
	}

	@Test
	public void testImpostaStanzaAdiacente() {
		assertEquals(s2, s1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testAddAttrezzo() {		
		assertTrue(s1.addAttrezzo(a));
	}

	@Test
	public void testRemoveAttrezzo() {
		assertTrue(s1.removeAttrezzo(a));
	}
}