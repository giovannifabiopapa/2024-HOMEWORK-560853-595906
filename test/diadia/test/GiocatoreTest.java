package diadia.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	// Test getCfu
	
	@Test // inizio la partita con 20 cfu
	public void testGetCfuVenti() {
		Giocatore giocatore = new Giocatore();
		assertEquals(20,giocatore.getCfu());
	}
	
	@Test // finisco la partita con 0 cfu
	public void testGetCfuZero() {
		Giocatore giocatore = new Giocatore();
		giocatore.setCfu(0);
		assertEquals(0,giocatore.getCfu());
	}
	
	@Test // inizio la partita senza avere 20 cfu
	public void testGetCfuDieci() {
		Giocatore giocatore = new Giocatore();
		assertNotEquals(10,giocatore.getCfu());
	}
	
	// Test getBorsa
	
	@Test // verifico che la borsa sia vuota
	public void testGetBorsaVuota() {
		Giocatore giocatore = new Giocatore();
		assertTrue(giocatore.getBorsa().isEmpty());
	}
	
	@Test // verifico che la borsa sia piena
	public void testGetBorsaPiena() {
		Giocatore giocatore = new Giocatore();
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("attrezzo",9);
		borsa.addAttrezzo(attrezzo);
		giocatore.getBorsa().addAttrezzo(attrezzo);
		assertFalse(giocatore.getBorsa().isEmpty());
	}
	
	@Test // nella borsa ho un determinato attrezzo
	public void testGetBorsa() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("attrezzo",9);
		borsa.addAttrezzo(attrezzo);
		assertEquals(9, borsa.getAttrezzo("attrezzo").getPeso());
	}
}