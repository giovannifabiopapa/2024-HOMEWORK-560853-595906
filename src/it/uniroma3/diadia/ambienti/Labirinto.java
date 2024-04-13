package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	public Labirinto() {
		creaStanze();
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo spada = new Attrezzo("spada",0);
		Attrezzo pistola = new Attrezzo("pistola",0);
		Attrezzo ascia = new Attrezzo("ascia",0);
		Attrezzo martello = new Attrezzo("martello",12);
		Attrezzo falce = new Attrezzo("falce",9);
		Attrezzo rastrello = new Attrezzo("rastrello",0);
		Attrezzo zaino = new Attrezzo("zaino",0);
		Attrezzo sasso = new Attrezzo("sasso",0);
		Attrezzo torcia = new Attrezzo("torcia",0);
		Attrezzo penna = new Attrezzo("penna",0);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		aulaN10.addAttrezzo(spada);
		atrio.addAttrezzo(pistola);
		atrio.addAttrezzo(ascia);
		atrio.addAttrezzo(martello);
		atrio.addAttrezzo(falce);
		atrio.addAttrezzo(rastrello);
		atrio.addAttrezzo(zaino);
		aulaN10.addAttrezzo(sasso);
		aulaN10.addAttrezzo(torcia);
		aulaN10.addAttrezzo(penna);

		// il gioco comincia nell'atrio
        this.stanzaIniziale = atrio;
		this.stanzaVincente = biblioteca;
    }
    
    public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
}