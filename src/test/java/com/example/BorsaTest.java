import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

import attrezzi.Attrezzo;
import giocatore.Borsa;

public class BorsaTest {
	Borsa b;
	Attrezzo falce;
	Attrezzo sega;
	
	@Before
	public void setUp() {
		b = new Borsa();
		falce = new Attrezzo("falce", 2);
		sega = new Attrezzo("sega", 16);
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(falce));
		assertFalse(b.addAttrezzo(sega));	// sega pesa più di 10kg e borsa non può portarlo
	}

	@Test
	public void testGetAttrezzo() {
		b.addAttrezzo(falce);
		assertEquals(falce, b.getAttrezzo("falce"));
	}

	@Test
	public void testRemoveAttrezzo() {
		b.addAttrezzo(falce);
		assertEquals(falce, b.removeAttrezzo("falce"));
		assertNull(b.getAttrezzo("falce"));
	}

	@Test
	public void testGetContenutoOrdinatoPerPesoUguale() {
		sega.setPeso(falce.getPeso());
		b.addAttrezzo(falce);
		b.addAttrezzo(sega);
		List<Attrezzo> borsaOrdinata = b.getContenutoOrdinatoPerPeso();
		assertEquals("[falce (2 kg), sega (2 kg)]", borsaOrdinata.toString());
	}

	@Test
	public void testGetContenutoOrdinatoPerPesoDiverso() {
		sega.setPeso(falce.getPeso());
		falce.setPeso(4);
		b.addAttrezzo(falce);
		b.addAttrezzo(sega);
		List<Attrezzo> borsaOrdinata = b.getContenutoOrdinatoPerPeso();
		assertEquals("[sega (2 kg), falce (4 kg)]", borsaOrdinata.toString());
	}

	@Test
	public void testGetContenutoOrdinatoPerNomeUguale() {
		Attrezzo a1 = new Attrezzo("martello", 3);
		Attrezzo a2 = new Attrezzo("martello", 5);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		SortedSet<Attrezzo> borsaOrdinata = b.getContenutoOrdinatoPerNome();
		assertEquals("[martello (3 kg), martello (5 kg)]", borsaOrdinata.toString());
	}

	@Test
	public void testGetContenutoOrdinatoPerNomeDiverso() {
		Attrezzo a1 = new Attrezzo("matita", 1);
		Attrezzo a2 = new Attrezzo("penna", 1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a1);
		SortedSet<Attrezzo> borsaOrdinata = b.getContenutoOrdinatoPerNome();
		assertEquals("[matita (1 kg), penna (1 kg)]", borsaOrdinata.toString());
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo martello = new Attrezzo("martello", 3);
		Attrezzo scudo = new Attrezzo("scudo", 2);
		Attrezzo pistola = new Attrezzo("pistola", 3);
		b.addAttrezzo(martello);
		b.addAttrezzo(falce);
		b.addAttrezzo(scudo);
		b.addAttrezzo(pistola);
		Map<Integer, Set<Attrezzo>> borsaOrdinata = b.getContenutoRaggruppatoPerPeso();
		assertEquals("{2=[scudo (2 kg), falce (2 kg)], 3=[martello (3 kg), pistola (3 kg)]}", borsaOrdinata.toString());
	}
}