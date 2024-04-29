package diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	@Test		// Controllo il corretto funzionamento del comando vai e del suo parametro nord
	public void FabbricaDiComandiFisarmonicaTest_FunzionamentoVaiNord() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		factory.costruisciComando("vai nord");
		assertEquals("vai", factory.getComando().getNome());
		assertEquals("nord", factory.getComando().getParametro());
	}
	
	@Test		// Controllo su comando non valido
	public void FabbricaDiComandiFisarmonicaTest_ComandoNonValido() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		factory.costruisciComando("");
		assertEquals("non valido", factory.getComando().getNome());
		assertNull(factory.getComando().getParametro());
	}
	
	@Test		// Controllo che vai nord non mi crea un comando posa attrezzo
	public void FabbricaDiComandiFisarmonicaTest_VaiNordNonMiCreaPosaAttrezzo() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		factory.costruisciComando("vai nord");
		assertNotEquals("posa", factory.getComando().getNome());
		assertNotEquals("attrezzo", factory.getComando().getParametro());
	}

}
