package clase;

import java.util.ArrayList;

public class Loturi {
	
	private int nrJucatori;
	private ArrayList<Fotbalist> fotb;
	
	public Loturi(int nrJucatori)
	{
		this.nrJucatori = nrJucatori;
		fotb = new ArrayList<Fotbalist>();
		for(int i=0; i<nrJucatori; i++)
		{
			fotb.add(new Fotbalist("Fotbalistul"+(i), "", ""));
		}
	}
	
	public void intraPeTeren()
	{
		System.out.println("Jucatorii intra pe teren");
		for(int i=1; i<nrJucatori; i++)
		{
			fotb.get(i).intra();
		}
	}
	
	public void ieseDePeTeren()
	{
		System.out.println("Jucatorii ies de pe teren");
		for(int i=1; i<nrJucatori; i++)
		{
			fotb.get(i).iese();
		}
	}
}
