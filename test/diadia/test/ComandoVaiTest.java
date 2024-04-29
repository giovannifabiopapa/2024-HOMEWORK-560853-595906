package diadia.test;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoVaiTest {
	
	/*
	 * per come ci ha spiegato lui il poliformismo nell'interfaccia comando abbiamo i metodi
	 * quindi il tipo statico è metodo mentre il tipo dinamico rappresenta l'implementazione che segue
	 * 
	 * usare Comando è più comodo perchè se poi quel comandoVai metti caso cambia nome basta che cambi la roba
	 * dopo il new così da fargli seguire l'implementazione giusta
	 */

	@Test	// Controllo che andando ad est mi trovo in N11
	public void testComandoVai_AndandoAdEstMiTrovoInN11() {
		IO io = new IOConsole();
		Partita partita = new Partita();
		Stanza a = partita.getStanzaCorrente().getStanzaAdiacente("est");
		Comando comando = new ComandoVai();
		comando.setIO(io);
		comando.setParametro("est");
		comando.esegui(partita);
		assertEquals(a, partita.getStanzaCorrente());
	}

	@Test	// Controllo che andando ad est non mi trovo in laboratorio
	public void testComandoVai_AndandoAdEstNonMiTrovoInLaboratorio() {
		IO io = new IOConsole();
		Partita partita = new Partita();
		Stanza a = partita.getStanzaCorrente().getStanzaAdiacente("ovest");
		Comando comando = new ComandoVai();
		comando.setIO(io);
		comando.setParametro("est");
		comando.esegui(partita);
		assertNotEquals(a, partita.getStanzaCorrente());
	}
	
	@Test	// Controllo che andando a nord trovo una stanza
	public void testComandoVai_AndandoANordEsisteUnaStanza() {
		IO io = new IOConsole();
		Partita partita = new Partita();
		Comando comando = new ComandoVai();
		comando.setIO(io);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertNotNull(partita.getStanzaCorrente());
	}
}
