import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import ambienti.*;
import attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private StanzaBloccata sb;
	private Stanza s;
	private Attrezzo a;
	
	@Before
	public void setUp() {
		sb = new StanzaBloccata("StanzaBloccata", "ovest", "grimaldello");
		s = new Stanza("Stanzetta");
		a = new Attrezzo("grimaldello", 1);
		sb.impostaStanzaAdiacente("ovest", s);
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(sb, sb.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente("ovest"));		
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String e = "Non hai modo di proseguire!\n";
		assertEquals(e, sb.getDescrizione());		
	}

}
