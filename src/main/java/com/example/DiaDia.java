package com.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.example.ambienti.*;
import com.example.attrezzi.Attrezzo;
import com.example.comandi.*;
import com.example.personaggi.*;

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

	public void gioca() throws Exception {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = io.leggiRiga();

		} while (!processaIstruzione(istruzione));
	}   

	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva(this.io);
		try {
			comandoDaEseguire = factory.costruisciComando(istruzione);
		} catch (NullPointerException npe) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		}
		comandoDaEseguire.esegui(this.partita);

		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
		}
		if (!this.partita.giocatoreIsVivo()) {
			io.mostraMessaggio("Hai esaurito i CFU…");
		}
		return this.partita.isFinita();
	}   

	public static void main(String[] argc) throws Exception {
		Scanner scanner = new Scanner(System.in);
		IO io = new IOConsole(scanner);
		/*Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("Atrio")
			.addAttrezzo("osso", 1)
			.addStanza("Aula N11")
			.addStanza("Aula N10")
			.addAttrezzo("lanterna", 3)
			.addStanza("Laboratorio Campus")
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("Atrio", "Biblioteca", Direzione.nord)
			.addAdiacenza("Atrio", "Aula N11", Direzione.est)
			.addAdiacenza("Atrio", "Aula N10", Direzione.sud)
			.addAdiacenza("Atrio", "Laboratorio Campus", Direzione.ovest)
			.addAdiacenza("Aula N11", "Laboratorio Campus", Direzione.est)
			.addAdiacenza("Aula N11", "Atrio", Direzione.ovest)
			.addAdiacenza("Aula N10", "Atrio", Direzione.nord)
			.addAdiacenza("Aula N10", "Aula N11", Direzione.est)
			.addAdiacenza("Aula N10", "Laboratorio Campus", Direzione.ovest)
			.addAdiacenza("Laboratorio Campus", "Atrio", Direzione.est)
			.addAdiacenza("Laboratorio Campus", "Aula N11", Direzione.ovest)
			.getLabirinto();*/
		/*Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("Pianerottolo")
			.addAttrezzo("torcia", 1)
			.addStanza("Bagno")
			.addAttrezzo("carta igienica", 1)
			.addPersonaggio(new Mago("Merlino", "Sono mago Merlino!", new Attrezzo("bacchetta", 1)))
			.addStanza("Camera piccola")
			.addAttrezzo("vestito", 2)
			.addPersonaggio(new Strega("Morgana", "Sono la strega Morgana!"))
			.addStanza("Camera grande")
			.addAttrezzo("osso", 1)
			.addPersonaggio(new Cane("Mia", "Bau Bau!"))
			.addStanzaVincente("Mansarda")
			.addAdiacenza("Pianerottolo", "Bagno", Direzione.est)
			.addAdiacenza("Pianerottolo", "Camera piccola", Direzione.ovest)
			.addAdiacenza("Pianerottolo", "Camera grande", Direzione.nord)
			.addAdiacenza("Pianerottolo", "Mansarda", Direzione.sud)
			.addAdiacenza("Bagno", "Pianerottolo", Direzione.ovest)
			.addAdiacenza("Camera piccola", "Pianerottolo", Direzione.est)
			.addAdiacenza("Camera grande", "Pianerottolo", Direzione.sud)
			.getLabirinto();*/
		Labirinto labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		scanner.close();
	}
}