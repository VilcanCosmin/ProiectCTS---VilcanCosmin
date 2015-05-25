package clase;

public class Teren 
{
	private String nume;
	
	public Teren(String nume)
	{
		this.nume = nume;
	}
	
	public String getNume()
	{
		return nume;
	}
	
	public void deschiderePorti()
	{
		System.out.println("S-au deschis portile la terenul "+nume);
	}
	
	public void inchiderePorti()
	{
		System.out.println("S-au inchis portile la terenul "+nume);
	}
}
