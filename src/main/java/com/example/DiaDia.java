import java.util.Scanner;

import ambienti.Stanza;
import attrezzi.Attrezzo;

public class DiaDia {
	static final private String MESSAGGIO_BENVENUTO = "Ti trovi nell'Università, ma oggi è diversa dal solito...\nMeglio andare al più presto in biblioteca a studiare. Ma dov'è?\nI locali sono popolati da strani personaggi, alcuni amici, altri... chissa!\nCi sono attrezzi che potrebbero servirti nell'impresa:\npuoi raccoglierli, usarli, posarli quando ti sembrano inutili\no regalarli se pensi che possano ingraziarti qualcuno.\n\nPer conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia(IOConsole console) {
		this.io = console;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		@SuppressWarnings("unused")
		Scanner scannerDiLinee;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = io.leggiRiga();
		} while (!processaIstruzione(istruzione));

	}   

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()==null) {
			io.mostraMessaggio("Non hai inserito alcun comando!");
			return false;
		} else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
		} else {
			io.mostraMessaggio("Comando sconosciuto");
		}

		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else {
			return false;
		}
	}   

	private void aiuto() {
		System.out.println("\n");
		for(int i=0; i< elencoComandi.length; i++) {
			io.mostraMessaggio(elencoComandi[i] + " ");
		}
		io.mostraMessaggio("");
	}

	private void vai(String direzione) {
		if (direzione==null) {
			io.mostraMessaggio("Dove vuoi andare? Non hai specificato nessuna direzione!");
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null/* && (direzione.equals("nord") || direzione.equals("est") || direzione.equals("sud") || direzione.equals("ovest")) */) {
			io.mostraMessaggio("Direzione inesistente! Non c'è nulla da questa parte.");
		} else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio("Stanza corrente: " + partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa: " + partita.getGiocatore().getBorsa().toString());
	}

	private void prendi(String nomeAttrezzo) {
		Attrezzo a = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getGiocatore().getBorsa().addAttrezzo(a);
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
	}

	private void posa(String nomeAttrezzo) {
		Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);

	}
	
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}