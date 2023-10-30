package ownUtil;
import gui.BuergeraemterView;
import javafx.stage.Stage;

import java.io.IOException;

import business.BuergeraemterModel;
import business.Buergeramt;

public class BuergeraemterControl {
	private BuergeraemterModel baModel;
	private BuergeraemterView baView;
	
	public BuergeraemterControl(Stage st) {
		baModel = new BuergeraemterModel();
		baView = new BuergeraemterView(st, baModel, this);
	}
	
	public void schreibeBuergeraemterInDatei(String typ, Buergeramt ba) {
		try {
			if("csv".equals(typ)) {
				baModel.schreibeBuergeraemterInCsvDatei(ba);
			} else {
				baView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		}catch(IOException exc) {
			baView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
			
		}
		catch(Exception exc) {
			baView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
			
		}
	}
}
