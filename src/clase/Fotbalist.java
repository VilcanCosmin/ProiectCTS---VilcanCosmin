package clase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import interfete.IPozitie;

public class Fotbalist 
{
	private String nume;
	private String CNP;
	private IPozitie pozitie;
	private String codUnic;
	private ArrayList<Integer> goluri;
	private ArrayList<Boolean> meciuri;
	private ArrayList<Integer> note;
	Fotbalist fotbalist;
	int varsta;
	
	public Fotbalist() {
		super();
	}

	public Fotbalist(String nume, String cNP, String codUnic) {
		super();
		this.nume = nume;
		CNP = cNP;
		this.codUnic = codUnic;
	}
	
	public void joaca(){
		pozitie.joaca(nume);
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public IPozitie getPozitie() {
		return pozitie;
	}

	public void setPozitie(IPozitie pozitie) {
		this.pozitie = pozitie;
	}
	
	public String getCodUnic() {
		return codUnic;
	}
	
	public void setCodUnic(String codUnic) {
		this.codUnic = codUnic;
	}

	public ArrayList<Integer> getGoluri() {
		return goluri;
	}

	public void setGoluri(ArrayList<Integer> goluri) {
		this.goluri = goluri;
	}

	public ArrayList<Integer> getNote() {
		return note;
	}

	public void setNote(ArrayList<Integer> note) {
		this.note = note;
	}

	public ArrayList<Boolean> getMeciuri() {
		return meciuri;
	}

	public void setMeciuri(ArrayList<Boolean> meciuri) {
		this.meciuri = meciuri;
	}

	public String getInfo() 
	{
		switch(codUnic.charAt(0))
		{
		case '1': return "Accidentat";
		case '2': return "Apt";
		case '3': return "Imprumutat";
		case '4': return "Liber";
		}
		
		return "N/A";
	}
	
	public int calculareVarsta()
	{
		
		switch(CNP.charAt(0))
		{
		case '1': return Calendar.getInstance().get(1) - (1900 + Integer.parseInt("" + CNP.charAt(1) + CNP.charAt(2)));
		case '2': return Calendar.getInstance().get(1) - (1900 + Integer.parseInt("" + CNP.charAt(1) + CNP.charAt(2)));
		case '3': return Calendar.getInstance().get(1) - (1800 + Integer.parseInt("" + CNP.charAt(1) + CNP.charAt(2)));
		case '4': return Calendar.getInstance().get(1) - (1800 + Integer.parseInt("" + CNP.charAt(1) + CNP.charAt(2))); 
		case '5': return Calendar.getInstance().get(1) - (2000 + Integer.parseInt("" + CNP.charAt(1) + CNP.charAt(2)));
		case '6': return Calendar.getInstance().get(1) - (2000 + Integer.parseInt("" + CNP.charAt(1) + CNP.charAt(2)));
		}
		
		return 0;
				
		
	}
	
	public boolean verificareCodUnic(String cod)
	{
		
		int ultim = cod.charAt(3);
		boolean contor = false;
		
		for(int i = 0; i< 2; i++)
		{
			int s = 0;
			s = s + Integer.parseInt(""+cod.charAt(i));
		}
		
		if(ultim == '0')
		{
			contor = true;
		}

		return contor;

	}
	
	public int totalGoluri() // pozitiv = gol, negativ = autogol
	{
		
		int total = 0;
		int k = 0;
		
		for(int i = 0; i < goluri.size(); i++)
		{
			if(goluri.get(i) != null)
			{
			 total = total + goluri.get(i);
			 k = k + 1;
			}
		}
		
		return total;
	}
	
	public int totalMeciuri()
	{
		int k = 0;
		
		for(int i = 0; i < meciuri.size(); i++)
		{
			if(meciuri.get(i) == true)
			{
				k = k + 1;
			}
		}
		
		return k;
	}
	
	public float medieGoluri()
	{
		int goluri = totalGoluri();
		int meciuri = totalMeciuri();
		float calcul = 0;
		
		if(meciuri > 0)
		{
			calcul = goluri / meciuri;
		}
		return calcul;

		
	}
	
	public boolean acordareBonus()
	{
		float medie = medieGoluri();
		int goluri = totalGoluri();
		int meciuri = totalMeciuri();
		boolean contor = false;
		
		if(goluri >= 10 && meciuri >= 15)
		{
			if(medie >= 0.75)
			{
				contor = true;
			}
		}
		
		return contor;
	}
	
	public float valoareBonus()
	{
		
		float medie = medieGoluri();
		if(acordareBonus() == true){
		if(medie < 0.85)
			{
				return 200 * medie;	
			}
		if(medie > 0.85)
			{
				return 300 * medie;
			}
		if(medie >=1)
			{
				return 500 * medie;
			}
		}
		
		return 0;

		
	}
			

	
	public int notaMaxima()
	{
		int maxim = 0;
		for(int i = 0; i < note.size(); i++)
		{
			if(note.get(i) > maxim)
				maxim = note.get(i);
		}
		
		return maxim;
	}
	
	public float medieNote()
	{
		int sumaN = 0;
		int numitor = note.size();
		float medieN = 0;
		for(int i = 0; i <note.size(); i++)
		{
			sumaN = sumaN + note.get(i);
		}
		if(numitor > 0){
			medieN = sumaN / numitor;
		}
		
		
		return medieN;
	}
	
	public String getSituatie()
	{
		HashMap<Integer, String> situatie = new HashMap<Integer, String>();
		
		try
		{
			FileReader reader = new FileReader("Situatie.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String linie = null;
			while((linie = bufferedReader.readLine()) != null && linie.length() > 0)
			{
				situatie.put(Integer.parseInt(linie.split("	")[0]), linie.split("	")[1]);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return situatie.get(Integer.parseInt(""+codUnic.charAt(0)));
	}
	
	public boolean verificaCNP()
	{
		int s = 0;
		String sablon = "279146358279";
		for(int i=0; i<12;i++)
		{
			s += Integer.parseInt(""+sablon.charAt(i))*Integer.parseInt(""+CNP.charAt(i));
		}
		int cifra = s%11;
		if(cifra == 10)
			cifra = 1;
		return cifra == Integer.parseInt(""+CNP.charAt(12));
	}
		
	
	
	public void iese()
	{
		System.out.println(nume+" iese de pe teren!");
	}
	
	public void intra()
	{
		System.out.println(nume+" intra pe teren!");
	}
	
	
}
