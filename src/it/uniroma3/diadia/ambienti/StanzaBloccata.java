package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza;
		
		if(!hasAttrezzo(attrezzoSbloccante)) {
			if(direzione.equals(direzioneBloccata))
				stanza = this;
			else
				stanza = super.getStanzaAdiacente(direzione);
		}
		else
			stanza = super.getStanzaAdiacente(direzione);
		
		return stanza;
	}
	
	@Override
    public String getDescrizione() {
        if(!hasAttrezzo(attrezzoSbloccante)) {
        	return "Stanza bloccata nella direzione: "+ direzioneBloccata + "\nPrendi il" + attrezzoSbloccante + "e posalo nella stanza";
        }
        else
        	return super.getDescrizione();
    }
}