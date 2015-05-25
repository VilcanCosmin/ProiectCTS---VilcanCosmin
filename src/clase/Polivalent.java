package clase;

import interfete.IFotbalist;
import interfete.IPozitie;

public class Polivalent implements IFotbalist, IPozitie 
{
	
	private String nume;
	private int varsta;
	private String pozitie;
	
	
	
	public Polivalent() {
		super();
	}

	public Polivalent(String nume, int varsta)
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

	@Override
	public String toString() {
		return "Polivalent: nume=" + nume + ", varsta=" + varsta;
				
	}

	@Override
	public void joaca(String nume) {
		System.out.println(nume + " joaca pe pozitia: POLIVALENT");
		
	}
	
	
}
