package diadia.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	/* test per il metodo getPeso */
	
	@Test	// controllo che il peso massimo sia dieci
	public void testGetPesoDieci() {
		Borsa borsa = new Borsa();
		assertEquals(10, borsa.getPesoMax());
	}
	
	@Test	// controllo che il peso iniziale sia zero
	public void testGetPesoIniziale() {
		Borsa borsa = new Borsa();
		assertEquals(0, borsa.getPeso());
	}
	
	@Test	// controllo che il peso dopo aver aggiunto due attrezzi sia giusto (3)
	public void testGetPesoConDueAttrezzi() {
		Borsa borsa = new Borsa();
		Attrezzo a1 = new Attrezzo("spada",1);
		Attrezzo a2 = new Attrezzo("spada",2);
		borsa.addAttrezzo(a1);
		borsa.addAttrezzo(a2);
		assertEquals(borsa.getPeso(), (a1.getPeso() + a2.getPeso()));
	}
	
	/* test per il metodo removeAttrezzo */
	
	@Test	// controllo che non posso rimuovere nulla dalla borsa vuota
	public void testRemoveAttrezzoNulla() {
		Borsa borsa = new Borsa();
		assertNull(borsa.removeAttrezzo("spada"));
	}
	
	@Test	// controllo che la rimozione per nome avvenga correttamente
	public void testRemoveAttrezzoNome() {
		Borsa borsa = new Borsa();
		Attrezzo a1 = new Attrezzo("spada",1);
		borsa.addAttrezzo(a1);
		borsa.removeAttrezzo("spada");
		assertTrue(borsa.isEmpty());
	}
	
	@Test	// controllo che non rimuovo nulla se non ho quello che cerco
	public void testRemoveAttrezzoNomeDiverso() {
		Borsa borsa = new Borsa();
		Attrezzo a1 = new Attrezzo("spada",1);
		borsa.addAttrezzo(a1);
		borsa.removeAttrezzo("ascia");
		assertFalse(borsa.isEmpty());
	}
	
	/* test per il metodo addAttrezzo */

	@Test	// controllo che l'attrezzo venga aggiunto correttamente
	public void testAddAttrezzo() {
		Borsa borsa = new Borsa();
		Attrezzo a1 = new Attrezzo("spada",1);
		borsa.addAttrezzo(a1);
		assertFalse(borsa.isEmpty());
	}
	
	@Test	// controllo che non si possa aggiungere un attrezzo con peso superiore a 10
	public void testAddAttrezzoNonRiuscitoPesoMaggioreDieci() {
		Borsa borsa = new Borsa();
		Attrezzo a1 = new Attrezzo("spada",12);
		borsa.addAttrezzo(a1);
		assertTrue(borsa.isEmpty());
	}
	
	/* test per il metodo isEmpty */
	
	@Test	// controllo che inizialmente la borsa sia vuota
	public void testIsEmpty() {
		Borsa borsa = new Borsa();
		assertTrue(borsa.isEmpty());
	}
	
	@Test	// controllo che dopo aver aggiunto un attrezzo la borsa non sia più vuota
	public void testIsNotEmpty() {
		Borsa borsa = new Borsa();
		Attrezzo a1 = new Attrezzo("spada",5);
		borsa.addAttrezzo(a1);
		assertFalse(borsa.isEmpty());
	}
}