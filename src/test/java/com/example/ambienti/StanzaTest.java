package com.example.ambienti;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.attrezzi.Attrezzo;

public class StanzaTest {
	Stanza s1 = new Stanza("s1");
	Stanza s2= new Stanza("s2");
	Attrezzo m = new Attrezzo("martello", 42);
	Direzione sud;

	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente(sud));
	}

	@Test
	public void testImpostaStanzaAdiacente() {
		s1.setStanzaAdiacente(sud, s2);
		assertEquals(s2, s1.getStanzaAdiacente(sud));
	}
	
	@Test
	public void testAddAttrezzo() {		
		assertTrue(s1.addAttrezzo(m));
	}

	@Test
	public void testGetAttrezzo() {
		s1.addAttrezzo(m);
		assertEquals(m.getNome(), s1.getAttrezzo("martello").getNome());
	}
}