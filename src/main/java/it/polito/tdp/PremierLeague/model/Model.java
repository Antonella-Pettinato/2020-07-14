package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	private PremierLeagueDAO dao;
	private DefaultDirectedWeightedGraph<Team, DefaultWeightedEdge> grafo;
	public Model() {
		dao= new PremierLeagueDAO();
		this.grafo= new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
	}
	
	
	
	public String CreaGrafo() {
		List<Team> teams= dao.vertici();
		Graphs.addAllVertices(grafo, teams);
		for(Team t:teams) {
			int punteggio=0;
			for(Integer i:t.esiti) {
				if(i==0)punteggio++;
				if(i==1)punteggio=punteggio+3;
				
			}
			t.punteggio=punteggio;
		}
		for(Team t1:teams) {
			for(Team t2:teams) {
				if(t1!=t2) {
					if(t1.punteggio-t2.punteggio!=0) {
						if(t1.punteggio>t2.punteggio) {
							double peso=t1.punteggio-t2.punteggio;
							Graphs.addEdgeWithVertices(grafo, t1, t2, peso);
						}
						if(t1.punteggio<t2.punteggio) {
							double peso=t2.punteggio-t1.punteggio;
							Graphs.addEdgeWithVertices(grafo, t2, t1, peso);
						}
					}
				}
			}
		}
		return "Grafo creato!\n";
		
		
		
	}
public Set<DefaultWeightedEdge> migliori(Team t){
	//List<Team> migliori= new ArrayList<>();
	return (grafo.incomingEdgesOf(t));
	
}
public Set<DefaultWeightedEdge> peggiori(Team t){
	//List<Team> migliori= new ArrayList<>();
	return (grafo.outgoingEdgesOf(t));
	
}


	public DefaultDirectedWeightedGraph<Team, DefaultWeightedEdge> getGrafo() {
	return grafo;
}



public void setGrafo(DefaultDirectedWeightedGraph<Team, DefaultWeightedEdge> grafo) {
	this.grafo = grafo;
}



	public PremierLeagueDAO getDao() {
		return dao;
	}



	public void setDao(PremierLeagueDAO dao) {
		this.dao = dao;
	}
	
}
