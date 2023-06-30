package it.polito.tdp.PremierLeague.model;

import java.util.PriorityQueue;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Simulatore {
	// parametri in ingresso
	private int N;
	private int X;
	
	//parametri
	private PremierLeagueDAO dao;
	
	// paramtri in uscita
	private double XMedia;
	private int giornateInsoddisfatte;
	// Stato
	private int ReporterOggi;
	// coda degli eventi
	private PriorityQueue<Event> queue;
	
	public Simulatore(int N, int X) {
		this.N=N;
		this.X=X;
		this.dao=new PremierLeagueDAO();
		this.XMedia=0.0;
		this.queue= new PriorityQueue<>();
		this.giornateInsoddisfatte=0;
		
		
	}
public void  loadEvents() {}
}
