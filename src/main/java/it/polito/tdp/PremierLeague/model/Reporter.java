package it.polito.tdp.PremierLeague.model;

public class Reporter {
private int idReporter;
private int idSquadra;
public Reporter(int idReporter, int idSquadra) {
	super();
	this.idReporter = idReporter;
	this.idSquadra = idSquadra;
}
public int getIdReporter() {
	return idReporter;
}
public void setIdReporter(int idReporter) {
	this.idReporter = idReporter;
}
public int getIdSquadra() {
	return idSquadra;
}
public void setIdSquadra(int idSquadra) {
	this.idSquadra = idSquadra;
}



}
