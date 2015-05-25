package clase;

public class Stadion 
{
	private String nume;
	private int capacitate;
	private Teren teren;
	private Loturi jucatori;
	private Meci meci;
	
	public Stadion(String nume, int capacitate)
	{
		this.setNume(nume);
		this.setCapacitate(capacitate);
	}
	
	public void scenariu(String numeTeren, String numeMeci)
	{
		teren = new Teren(numeTeren);
		jucatori = new Loturi(23);
		meci = new Meci(numeMeci);
		teren.deschiderePorti();
		jucatori.intraPeTeren();
		meci.start();
		meci.stop();
		jucatori.ieseDePeTeren();
		teren.inchiderePorti();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getCapacitate() {
		return capacitate;
	}

	public void setCapacitate(int capacitate) {
		this.capacitate = capacitate;
	}
}
