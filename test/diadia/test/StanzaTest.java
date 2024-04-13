package diadia.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	// Test getAttrezzo

	@Test // stanza vuota
	public void testGetAttrezzo_stanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getAttrezzo("inesistente"));
	}
	
	@Test // stanza non vuota
	public void testGetAttrezzo_stanzaNonVuota_presente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo",0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzo("attrezzo"));
	}
	
	@Test // stanza non vuota assente
	public void testGetAttrezzo_stanzaNonVuota_attrezzoNonpresente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo",0);
		stanza.addAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo("Nome attrezzo non presente"));
	}
	
	// Test getStanzaAdiacente
	
	@Test // stanza adiacente assente
	public void testGetStanzaAdiacente_stanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getStanzaAdiacente("inesistente"));
	}
	
	@Test // stanza impostata
	public void testGetStanzaAdiacenteNonVuotaPresente() {
		Stanza stanza = new Stanza("stanza");
		Stanza adiacente = new Stanza("stanzaAdiacente");
		stanza.impostaStanzaAdiacente("sud",adiacente);
		assertNotNull(stanza.getStanzaAdiacente("sud"));
	}
	
	@Test // testo se vado avanti e poi torno indietro mi trovo nella stessa stanza
	public void testGetStanzaAdiacenteAvantiIndietro() {
		Stanza stanza = new Stanza("stanza");
		Stanza adiacente = new Stanza("stanzaAdiacente");
		stanza.impostaStanzaAdiacente("est", adiacente);
		adiacente.impostaStanzaAdiacente("ovest", stanza);
		assertEquals(stanza.getStanzaAdiacente("ovest"),adiacente.getStanzaAdiacente("est"));
	}
	
	// Test hasAttrezzo
	
	@Test // attrezzo assente
	public void testHasAttrezzoEsiste() {
		Stanza vuota = new Stanza("vuota");
		assertEquals(false,vuota.hasAttrezzo("inesistente"));
	}
	
	@Test // esiste attrezzo con quel nome
	public void testHasAttrezzoPresente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("coltello",10);
		stanza.addAttrezzo(attrezzo);
		assertEquals(true,stanza.hasAttrezzo("coltello"));
	}
	
	@Test // esiste attrezzo ma non con il nome che cerco
	public void testHasAttrezzoPresenteAttrezzoSbagliato() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("coltello",10);
		stanza.addAttrezzo(attrezzo);
		assertEquals(false,stanza.hasAttrezzo("lama"));
	}
}