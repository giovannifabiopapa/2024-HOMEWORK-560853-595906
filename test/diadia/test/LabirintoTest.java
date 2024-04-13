package diadia.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class LabirintoTest {
	
	/* test per il metodo getStanzaVincente */

	@Test	// controllo che la biblioteca sia la stanza vincente
	public void testGetStanzaVincenteBiblio() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	@Test	// controllo che l'atrio non sia la stanza vincente
	public void testGetStanzaVincenteAtrio() {
		Labirinto labirinto = new Labirinto();
		assertNotEquals(labirinto.getStanzaIniziale().getNome(), labirinto.getStanzaVincente().getNome());
	}
	
	@Test	// controllo che la stanza vincente non sia null
	public void testGetStanzaVincenteEsiste() {
		Labirinto labirinto = new Labirinto();
		assertNotNull(labirinto.getStanzaVincente());
	}
	
	/* test per il metodo getStanzaIniziale */
	
	@Test	// controllo che l'atrio sia la stanza iniziale
	public void testGetStanzaInizialeAtrio() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
	}
	
	@Test	// controllo che la biblioteca non sia la stanza iniziale
	public void testGetStanzaInizialeNonBiblio() {
		Labirinto labirinto = new Labirinto();
		assertNotEquals("Biblioteca", labirinto.getStanzaIniziale().getNome());
	}
	
	@Test	// controllo che la stanza iniziale non sia null
	public void testGetStanzaInizialeNonNulla() {
		Labirinto labirinto = new Labirinto();
		assertNotNull(labirinto.getStanzaIniziale());
	}
}