package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	private String parametro;
	private IO io;
	private final static String NOME = "aiuto";
	
	static final private String[] elencoComandi = {"vai","prendi", "posa", "aiuto", "fine", "guarda"};
	
	@Override
	public void esegui(Partita partita) {
			for(int i=0; i< elencoComandi.length; i++) 
				System.out.print(elencoComandi[i]+" ");
			io.mostraMessaggio("");
		}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getNome() {
		return this.NOME;
	}
	
	@Override
	public String getParametro() {
		return null;
	}
}

