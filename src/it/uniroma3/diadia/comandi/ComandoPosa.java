package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;
	private IO io;
	private final static String NOME = "posa";
	
	/* implemento il metodo 'posa' */
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null)
			io.mostraMessaggio("Cosa vuoi posare?");
		else {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
				if(partita.getStanzaCorrente().addAttrezzo(a))
					partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				else
					io.mostraMessaggio("Impossibile posarlo nella stanza");
			}
			else
				io.mostraMessaggio("L'attrezzo cercato non è presente");
		}
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return this.NOME;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
