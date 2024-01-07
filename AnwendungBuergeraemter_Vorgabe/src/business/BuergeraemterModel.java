package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ownUtil.Observable;
import ownUtil.Observer;

import factories.ConcreteCreator;
import factories.Creator;
import factories.Product;

public class BuergeraemterModel implements Observable {
	private Buergeramt buergeramt;
	private static BuergeraemterModel instance;
	private ArrayList<Observer> observers = new ArrayList<>();
	public void addObserver(Observer o) {
		observers.add(o);
	}
	public void notifyObservers() {
		for(Observer o:observers) {
			o.update();
		}
	}
	
	private BuergeraemterModel() {
		
	}
	
	public static BuergeraemterModel getInstance() {
		if(instance == null) {
			instance = new BuergeraemterModel();
			} 
		return instance;
	}
	
	public void observerhinzufuegen(Observer o) {
		addObserver(o);
	}
	public void setBuergeramt(Buergeramt ba) {
		this.buergeramt = ba;
		
		
		notifyObservers();
	}
	
/*	
 * 
	public void schreibeBuergeraemterInCsvDatei(Buergeramt ba) throws IOException{
		buergeramt = ba;
		BufferedWriter aus = new BufferedWriter(new FileWriter("Buergeraemter.csv", true));
		aus.write(this.getBuergeramt().gibBuergeramtZurueck(';'));
		aus.close();
	}*/
	
	public void schreibeBuergeraemterInCsvDatei(Buergeramt ba)
	throws IOException{
		buergeramt = ba;
		Creator c = new ConcreteCreator();
		Product writer = c.factoryMethod("csv");
		writer.fuegeInDateiHinzu(this.buergeramt);
		writer.schliesseDatei();
	}
	public void schreibeBuergeraemterInTxtDatei(Buergeramt ba)
			throws IOException{
				buergeramt = ba;
				Creator c = new ConcreteCreator();
				Product writer = c.factoryMethod("txt");
				writer.fuegeInDateiHinzu(this.buergeramt);
				writer.schliesseDatei();
			}
	public Buergeramt getBuergeramt() {
		return buergeramt;
	}
}
