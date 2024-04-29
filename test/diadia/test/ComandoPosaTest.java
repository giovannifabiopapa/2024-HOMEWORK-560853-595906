package diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {

	@Test	// Controllo di aver posato un attrezzo in atrio
	public void testComandoPosa_PosoAttrezzoInAtrio() {
		IO io = new IOConsole();
		Partita partita = new Partita();
		Comando posa = new ComandoPosa();
		Attrezzo attrezzo = new Attrezzo("attrezzo", 2);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		posa.setIO(io);
		posa.setParametro("attrezzo");
		posa.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
	}
	
	@Test	// Controllo che se poso attrezzo "a" in atrio non trovo attrezzo "b"
	public void testComandoPosa_PosoAttrezzoInAtrioECercoAltro() {
		IO io = new IOConsole();
		Partita partita = new Partita();
		Comando posa = new ComandoPosa();
		Attrezzo attrezzo = new Attrezzo("attrezzo", 2);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		posa.setIO(io);
		posa.setParametro("attrezzo");
		posa.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("altro"));
	}
	
	@Test	// Controllo che poso attrezzo inesistente in borsa
	public void testComandoPosa_PosoAttrezzoInesistenteInBorsa() {
		IO io = new IOConsole();
		Partita partita = new Partita();
		Comando posa = new ComandoPosa();
		Attrezzo attrezzo = new Attrezzo("attrezzo", 2);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		posa.setIO(io);
		posa.setParametro("altro");
		posa.esegui(partita);
		assertNull(partita.getStanzaCorrente().getAttrezzo("altro"));
	}

}
