package clase;

public class Meci 
{
	private String echipe;
	
	public Meci(String echipe)
	{
		this.echipe = echipe;
	}
	
	public void start()
	{
		System.out.println("Meciul "+ echipe + " a inceput !");
	}
	
	public void stop()
	{
		System.out.println("Meciul "+ echipe + " s-a terminat");
	}
	
	public String getEchipe()
	{
		return echipe;
	}
}
