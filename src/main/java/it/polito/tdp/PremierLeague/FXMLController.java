/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.PremierLeague;

import java.net.URL;
import java.util.ResourceBundle;

import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.PremierLeague.model.Model;
import it.polito.tdp.PremierLeague.model.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="btnCreaGrafo"
	private Button btnCreaGrafo; // Value injected by FXMLLoader

	@FXML // fx:id="btnClassifica"
	private Button btnClassifica; // Value injected by FXMLLoader

	@FXML // fx:id="btnSimula"
	private Button btnSimula; // Value injected by FXMLLoader

	@FXML // fx:id="cmbSquadra"
	private ComboBox<Team> cmbSquadra; // Value injected by FXMLLoader

	@FXML // fx:id="txtN"
	private TextField txtN; // Value injected by FXMLLoader

	@FXML // fx:id="txtX"
	private TextField txtX; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doClassifica(ActionEvent event) {
		this.txtResult.clear();
		if (this.cmbSquadra.getValue() != null) {
			Team t = this.cmbSquadra.getValue();
			this.txtResult.appendText("MIGLIORI\n");
			for (DefaultWeightedEdge de : model.migliori(t)) {
				this.txtResult.appendText(de.toString() + " " + model.getGrafo().getEdgeWeight(de) + "\n");
			}

			this.txtResult.appendText("PEGGIORI\n");

			for (DefaultWeightedEdge de : model.peggiori(t)) {
				this.txtResult.appendText(de.toString() + " " + model.getGrafo().getEdgeWeight(de) + "\n");
			}

		} else {
			this.txtResult.appendText("campo vuoto");
		}

	}

	@FXML
	void doCreaGrafo(ActionEvent event) {
		this.txtResult.clear();
		this.txtResult.appendText(model.CreaGrafo());
		this.txtResult.appendText("#VERTICI: " + model.getGrafo().vertexSet().size() + "\n");
		this.txtResult.appendText("#ARCHI : " + model.getGrafo().edgeSet().size() + "\n");
		this.cmbSquadra.getItems().addAll(model.getDao().listAllTeams());

	}

	@FXML
	void doSimula(ActionEvent event) {
		if (this.txtN.getText().compareTo("") == 0 || this.txtX.getText().compareTo("") == 0) {
			int input = 0;
			int input2=0;
			try {
				input = Integer.parseInt(this.txtN.getText());
				input = Integer.parseInt(this.txtN.getText());
			} catch (NumberFormatException ne) {
				this.txtResult.appendText("X o N non validi \n");
			}
		} else {
			this.txtResult.appendText("Campo vuoto\n");
		}

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnClassifica != null : "fx:id=\"btnClassifica\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
		assert cmbSquadra != null : "fx:id=\"cmbSquadra\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtN != null : "fx:id=\"txtN\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtX != null : "fx:id=\"txtX\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
