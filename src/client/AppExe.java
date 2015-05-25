package client;

import clase.Fotbalist;
import clase.Fotbalisti;
import clase.Fundas;
import clase.JucatorFactory;
import clase.Mijlocas;
import clase.Portar;
import clase.Stadion;
import interfete.IFotbalist;

public class AppExe {

	public static void main(String[] args) {
		
		IFotbalist fotbalist;
		JucatorFactory factory = new JucatorFactory();
		
		fotbalist = factory.creareJucator(Fotbalisti.Portar);
		System.out.println(fotbalist.toString());
		fotbalist = factory.creareJucator(Fotbalisti.Fundas);
		System.out.println(fotbalist.toString());
		fotbalist = factory.creareJucator(Fotbalisti.Mijlocas);
		System.out.println(fotbalist.toString());
		fotbalist = factory.creareJucator(Fotbalisti.Atacant);
		System.out.println(fotbalist.toString());
		fotbalist = factory.creareJucator(Fotbalisti.Polivalent);
		System.out.println(fotbalist.toString());
		
		Fotbalist fotbalist1 = new Fotbalist("Vilcan Cosmin", "1930126520010", "1250");
		fotbalist1.setPozitie(new Mijlocas());
		fotbalist1.joaca();
		
		Fotbalist fotbalist2 = new Fotbalist ("Voicu Costin", "1930927410010", "2470");
		fotbalist2.setPozitie(new Fundas());
		fotbalist2.joaca();
		fotbalist2.setPozitie(new Portar());
		fotbalist2.joaca();
		
		Stadion stadion = new Stadion("Santiago Bernabeu", 75000);
		stadion.scenariu("Central", "Real Madrid - Barcelona");
		
		Fotbalist fotbalistFisier = new Fotbalist("Tudor", "1931008134141", "1930");
		fotbalistFisier.getSituatie();
		System.out.println("Fotbalistul " +fotbalistFisier.getNume()+ " este " +fotbalistFisier.getSituatie());

		Fotbalist fotbalistFisier1 = new Fotbalist("Vilcan", "1930126520010", "3930");
		fotbalistFisier1.getSituatie();
		System.out.println("Fotbalistul " +fotbalistFisier1.getNume()+ " este " +fotbalistFisier1.getSituatie());
	}

}
