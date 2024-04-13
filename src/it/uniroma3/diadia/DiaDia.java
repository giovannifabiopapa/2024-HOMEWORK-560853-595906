package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO , 560853, 595906
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai","prendi", "posa", "aiuto", "fine"};

	private Partita partita;
	private IOConsole console;
	// costruttore DiaDia
	public DiaDia(IOConsole io) {
		this.console = io;				// creo oggetto per leggere e scannerizzare
		this.partita = new Partita();	// creo partita
	}

	public void gioca() {
		String istruzione; 

		this.console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
		istruzione = this.console.leggiRiga();
		while (!processaIstruzione(istruzione));
			//scannerDiLinee.close();
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		if(istruzione.isEmpty())
			return false;
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			this.console.mostraMessaggio("Comando sconosciuto");
		
		if(this.partita.isFinita()) {
			if (this.partita.vinta())
				this.console.mostraMessaggio("Hai vinto!");
			else
				this.console.mostraMessaggio("Hai perso!");
			return true;
		} else	
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		this.console.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		this.console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione() + "CFU : " + partita.getGiocatore().getCfu());
	}
	
	/* Aggiungo prendi e posa */
	
	/* implemento il metodo 'prendi' */
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo == null)
			this.console.mostraMessaggio("Cosa vuoi prendere?");
		else {
			if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
				Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				if(this.partita.getGiocatore().getBorsa().addAttrezzo(a))
					this.partita.getStanzaCorrente().removeAttrezzo(a);
				else
					this.console.mostraMessaggio("La borsa era piena");
			}
			else
				this.console.mostraMessaggio("L'attrezzo cercato non è presente");
		}
		this.console.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}
	
	/* implemento il metodo 'posa' */
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null)
			this.console.mostraMessaggio("Cosa vuoi posare?");
		else {
			if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
				if(this.partita.getStanzaCorrente().addAttrezzo(a))
					this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				else
					this.console.mostraMessaggio("Impossibile posarlo nella stanza");
			}
			else
				this.console.mostraMessaggio("L'attrezzo cercato non è presente");
		}
		this.console.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);	// crea ogetto diadia
		gioco.gioca();
	}
}