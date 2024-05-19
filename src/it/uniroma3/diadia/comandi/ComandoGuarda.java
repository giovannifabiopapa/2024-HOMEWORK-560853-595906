package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	private IO io;
	private final static String NOME = "guarda";

	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}

	@Override
	public String getNome() {
		return ComandoGuarda.NOME;
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public void setParametro(String parametro) {
	}
}
