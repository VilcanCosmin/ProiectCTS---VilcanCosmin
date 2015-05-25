package teste;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class MainSuite {

	public static void main(String[] args) {
		TestSuite suita = new TestSuite();
		suita.addTest(new TestApp("testConstructorNume"));
		suita.addTest(new TestApp("testGetInfo"));
		suita.addTest(new TestApp("testCodUnic"));
		suita.addTest(new TestApp("testTotalGoluri"));
		suita.addTest(new TestApp("testTotalMeciuri"));
		suita.addTest(new TestApp("testMedieGoluri"));
		suita.addTest(new TestApp("testAcordareBonus"));
		suita.addTest(new TestApp("testValoareBonus"));
		suita.addTest(new TestApp("testCalculareVarsta"));
		suita.addTest(new TestApp("testNotaMaxima"));
		suita.addTest(new TestApp("testMedieNote"));
		suita.addTest(new TestApp("testVerificareCNP"));
		
		TestRunner.run(suita);
		
	}

}
