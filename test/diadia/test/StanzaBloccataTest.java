package diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	@Test		// il passepartout sblocca la stanza
	public void getStanzaAdiacenteTest_PassepartoutSbloccaLaStanza2() {
		Stanza stanza1 = new Stanza("stanza");
		Stanza stanza2 = new StanzaBloccata("bloccata", "nord", "passepartout");
		stanza2.impostaStanzaAdiacente("nord", stanza1);
		Attrezzo attrezzo = new Attrezzo("passepartout", 5);
		stanza2.addAttrezzo(attrezzo);
		assertEquals(stanza1, stanza2.getStanzaAdiacente("nord"));
	}
	
	@Test		// la chiave non sblocca la stanza
	public void getStanzaAdiacenteTest_ChiaveNonSbloccaStanza2() {
		Stanza stanza1 = new Stanza("stanza");
		Stanza stanza2 = new StanzaBloccata("bloccata", "nord", "passepartout");
		stanza2.impostaStanzaAdiacente("nord", stanza1);
		Attrezzo attrezzo = new Attrezzo("chiave", 5);
		stanza2.addAttrezzo(attrezzo);
		assertNotEquals(stanza1, stanza2.getStanzaAdiacente("nord"));
	}
	
	@Test		// il passepartout non mi serve per andare in stanza3
	public void getStanzaAdiacenteTest_PassepartoutNonServePerAndareInStanza3() {
		Stanza stanza1 = new Stanza("stanza");
		Stanza stanza2 = new StanzaBloccata("bloccata", "nord", "passepartout");
		Stanza stanza3 = new Stanza("nuova");
		stanza2.impostaStanzaAdiacente("nord", stanza1);
		stanza2.impostaStanzaAdiacente("est", stanza3);
		Attrezzo attrezzo = new Attrezzo("passepartout", 5);
		stanza2.addAttrezzo(attrezzo);
		assertEquals(stanza3, stanza2.getStanzaAdiacente("est"));
	}
}