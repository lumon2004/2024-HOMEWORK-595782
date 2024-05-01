import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import ambienti.*;
import attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia stanza;
	private Attrezzo lumino;
	@Before
	public void setUp() {
		stanza = new StanzaBuia("StanzaBuia", "lumino");
		lumino = new Attrezzo("lumino", 1);
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(lumino);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String e = "Qui c'è buio pesto!\n";
		assertEquals(e, stanza.getDescrizione());
	}
}
