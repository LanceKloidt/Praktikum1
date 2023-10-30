package ownUtil;
import gui.BuergeraemterView;
import javafx.stage.Stage;
import business.BuergeraemterModel;

public class BuergeraemterControl {
	private BuergeraemterModel baModel;
	private BuergeraemterView baView;
	
	public BuergeraemterControl(Stage st) {
		baModel = new BuergeraemterModel();
		baView = new BuergeraemterView(st, baModel, this);
	}
}
