package diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPrendiTest {

	@Test	// Controllo che se prendo osso, in borsa ho osso
	public void testComandoPrendi_PrendendoOssoRitrovoOssoInBorsa() {
		IO io = new IOConsole();
		Giocatore giocatore = new Giocatore();
		Partita partita = new Partita();
		Comando prendi = new ComandoPrendi();
		prendi.setIO(io);
		prendi.setParametro("osso");
		prendi.esegui(partita);
		assertEquals("osso", partita.getGiocatore().getBorsa().getAttrezzo("osso").getNome());
	}
	
	@Test	// Controllo che se prendo osso, in borsa non ho spada
	public void testComandoPrendi_PrendendoOssoNonRitrovoSpadaInBorsa() {
		IO io = new IOConsole();
		Giocatore giocatore = new Giocatore();
		Partita partita = new Partita();
		Comando prendi = new ComandoPrendi();
		prendi.setIO(io);
		prendi.setParametro("osso");
		prendi.esegui(partita);
		assertNotEquals("spada", partita.getGiocatore().getBorsa().getAttrezzo("osso").getNome());
	}
	
	@Test	// Controllo che sto pendendo un attrezzo inesistenze
	public void testComandoPrendi_PrendoAttrezzoInesistente() {
		IO io = new IOConsole();
		Giocatore giocatore = new Giocatore();
		Partita partita = new Partita();
		Comando prendi = new ComandoPrendi();
		prendi.setIO(io);
		prendi.setParametro("attezzo");
		prendi.esegui(partita);
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo("attrezzo"));
	}

}
