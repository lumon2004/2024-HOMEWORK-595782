import java.util.Scanner;

import ambienti.*;
import attrezzi.Attrezzo;
import comandi.Comando;
import comandi.FabbricaDiComandi;
import comandi.FabbricaDiComandiFisarmonica;
import io.*;
import partita.Partita;

@SuppressWarnings("unused")

public class DiaDia {
	static final private String MESSAGGIO_BENVENUTO = "Ti trovi nell'Università, ma oggi è diversa dal solito...\nMeglio andare al più presto in biblioteca a studiare. Ma dov'è?\nI locali sono popolati da strani personaggi, alcuni amici, altri... chissa!\nCi sono attrezzi che potrebbero servirti nell'impresa:\npuoi raccoglierli, usarli, posarli quando ti sembrano inutili\no regalarli se pensi che possano ingraziarti qualcuno.\n\nPer conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi", "posa"};

	private Partita partita;
	private IO io;

	public DiaDia(IO IO) {
		this.io = IO;
		this.partita = new Partita();
	}

	public DiaDia(IO console, Labirinto labirinto) {
		this.io = console;
		this.partita = new Partita(labirinto);
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = io.leggiRiga();

		} while (!processaIstruzione(istruzione));
	}   

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();

		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);

		if(this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
		}
		return this.partita.isFinita();
	}   

	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("Atrio")
			.addAttrezzo("osso", 1)
			.addStanza("Aula N11")
			.addStanza("Aula N10")
			.addAttrezzo("lanterna", 3)
			.addStanza("Laboratorio Campus")
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("Atrio", "Biblioteca", "nord")
			.addAdiacenza("Atrio", "Aula N11", "est")
			.addAdiacenza("Atrio", "Aula N10", "sud")
			.addAdiacenza("Atrio", "Laboratorio Campus", "ovest")
			.addAdiacenza("Aula N11", "Laboratorio Campus", "est")
			.addAdiacenza("Aula N11", "Atrio", "ovest")
			.addAdiacenza("Aula N10", "Atrio", "nord")
			.addAdiacenza("Aula N10", "Aula N11", "est")
			.addAdiacenza("Aula N10", "Laboratorio Campus", "ovest")
			.addAdiacenza("Laboratorio Campus", "Atrio", "est")
			.addAdiacenza("Laboratorio Campus", "Aula N11", "ovest")
			.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
	}
}