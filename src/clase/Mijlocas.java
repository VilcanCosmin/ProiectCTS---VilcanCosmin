package clase;

import interfete.IFotbalist;
import interfete.IPozitie;

public class Mijlocas implements IFotbalist, IPozitie 
{
	
	private String nume;
	private int varsta;
	private String pozitie;
	
	
	
	public Mijlocas() {
		super();
	}



	public Mijlocas(String nume, int varsta)
	{
		this.nume = nume;
		this.varsta = varsta;
	}
	
	
	
	public String getNume() {
		return nume;
	}



	public void setNume(String nume) {
		this.nume = nume;
	}



	public int getVarsta() {
		return varsta;
	}



	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}



	public String getPozitie() {
		return pozitie;
	}



	public void setPozitie(String pozitie) {
		this.pozitie = pozitie;
	}



	public String toString() {
		return "Mijlocas: nume=" + nume + ", varsta=" + varsta;
				
	}



	@Override
	public void joaca(String nume) {
		System.out.println(nume + " joaca pe pozitia: MIJLOCAS");
		
	}
}
