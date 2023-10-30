package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BuergeraemterModel {
	private Buergeramt buergeramt;
	
	public void schreibeBuergeraemterInCsvDatei(Buergeramt ba) throws IOException{
		buergeramt = ba;
		BufferedWriter aus = new BufferedWriter(new FileWriter("Buergeraemter.csv", true));
		aus.write(this.getBuergeramt().gibBuergeramtZurueck(';'));
		aus.close();
	}
	public Buergeramt getBuergeramt() {
		return buergeramt;
	}
}
