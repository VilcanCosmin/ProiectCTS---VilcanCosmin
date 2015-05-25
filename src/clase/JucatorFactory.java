package clase;

import interfete.IFotbalist;

public class JucatorFactory 
{
	public IFotbalist creareJucator(Fotbalisti fotbalist)
	{
		switch(fotbalist)
		{
		case Portar: return new Portar("Manuel Neuer", 26);
		case Fundas: return new Fundas("Sergio Ramos", 28);
		case Mijlocas: return new Mijlocas("Cristiano Ronaldo", 30);
		case Atacant: return new Atacant("Lionel Messi", 28);
		case Polivalent: return new Polivalent("Gheorghe Hagi", 38);
		
		}
		
		return null;
	}
}
