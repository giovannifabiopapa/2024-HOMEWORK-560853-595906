package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private String nomeAttrezzo;
	private IO io;
	private final static String NOME = "prendi";
	
	/* implemento il metodo 'prendi' */
	@Override
	public void esegui(Partita partita) {
		if(this.nomeAttrezzo == null)
			io.mostraMessaggio("Cosa vuoi prendere?");
		else {
			if(partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {
				Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
				if(partita.getGiocatore().getBorsa().addAttrezzo(a))
					partita.getStanzaCorrente().removeAttrezzo(a);
				else
					io.mostraMessaggio("La borsa era piena");
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
