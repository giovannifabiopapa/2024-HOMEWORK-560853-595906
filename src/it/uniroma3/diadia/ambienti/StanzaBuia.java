package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	private String attrezzoLuminoso;
	
	public StanzaBuia(String nome, String attrezzoLuminoso) {
		super(nome);
		this.attrezzoLuminoso = attrezzoLuminoso;
	}
	
	@Override
    public String getDescrizione() {
        if(!hasAttrezzo(attrezzoLuminoso)) {
        	return "Qui c'è buio pesto";
        }
        else
        	return super.getDescrizione();
    }
}