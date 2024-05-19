package diadia.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	private Labirinto labirinto;
	private Partita partita;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
	}

	// Test getStanzaCorrente
	
	@Test // stanza corrente assente
	public void testGetStanzaCorrente() {
		Stanza stanza = new Stanza("atrio");
		partita.setStanzaCorrente(stanza);
		assertEquals("atrio",partita.getStanzaCorrente().getNome());
	}
	
	@Test // stanza corrente esiste ma è sbagliata
	public void testGetStanzaCorrenteSbagliata() {
		Stanza stanza = new Stanza("atrio");
		partita.setStanzaCorrente(stanza);
		assertNotEquals("biblioteca",partita.getStanzaCorrente().getNome());
	}
	
	@Test // stanza corrente è vincente
	public void testGetStanzaCorrenteVincente() {
	//	Partita partita = new Partita();
	//	Stanza stanzaVincente = new Stanza("biblioteca");
		Labirinto labirinto = new Labirinto();
	//	partita.setStanzaCorrente(stanzaVincente);
		assertEquals("Biblioteca",labirinto.getStanzaVincente().getNome());
	}
	
	// Test getCfu
	
	@Test // inizio la partita con 20 cfu
	public void testGetCfuVenti() {
		//Stanza stanza = new Stanza("atrio");
		//partita.setCfu(20);
		assertEquals(20,partita.getGiocatore().getCfu());
	}
	
	@Test // finisco la partita con 0 cfu
	public void testGetCfuZero() {
		//Stanza stanza = new Stanza("atrio");
		partita.getGiocatore().setCfu(0);
		assertEquals(0,partita.getGiocatore().getCfu());
	}
	
	@Test // inizio la partita senza avere 20 cfu
	public void testGetCfuDieci() {
		//Stanza stanza = new Stanza("atrio");
		//partita.setCfu(10);
		assertNotEquals(10,partita.getGiocatore().getCfu());
	}
	
	// Test isFinita

	@Test // La partita finisce perchè ho vinto
	public void testIsFinitaVinto() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Biblioteca",labirinto.getStanzaVincente().getNome());
	}
	
	@Test // La partita finisce perchè ho perso
	public void testIsFinitaPerso() {
		partita.getGiocatore().setCfu(0);
		assertEquals(0,partita.getGiocatore().getCfu());
	}
	
	@Test // La partita finisce perchè ho smesso di giocare
	public void testIsFinita() {
		partita.setFinita();
		partita.isFinita();
		assertTrue(partita.isFinita());
	}
}