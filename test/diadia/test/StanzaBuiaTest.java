package diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	@Test	// verifico che nella stanza ci sia l'attrezzo luminoso
	public void getDescrizione_StanzaBuiaHaAttrezzoLuminoso() {
		Stanza stanza = new StanzaBuia("buia", "torcia");
		Attrezzo attrezzo = new Attrezzo("torcia",3);
		stanza.addAttrezzo(attrezzo);
		assertNotEquals("Qui c'è buio pesto", stanza.getDescrizione());
	}
	
	@Test	// verifico che nella stanza non ci sia l'attrezzo luminoso
	public void getDescrizione_StanzaBuiaNonHaAttrezzoLuminoso() {
		Stanza stanza = new StanzaBuia("buia", "torcia");
		Attrezzo attrezzo = new Attrezzo("lanterna",3);
		stanza.addAttrezzo(attrezzo);
		assertEquals("Qui c'è buio pesto", stanza.getDescrizione());
	}
}