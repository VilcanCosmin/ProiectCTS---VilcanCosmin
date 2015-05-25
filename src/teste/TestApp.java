package teste;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Fotbalist;

public class TestApp extends TestCase{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructorNume() 
	{
		Fotbalist fotbalist1 = new Fotbalist("Vilcan", "1930126520010","1250");
		assertEquals("Vilcan", fotbalist1.getNume());
		assertEquals("1930126520010", fotbalist1.getCNP());
		assertEquals("1250", fotbalist1.getCodUnic());
	}
	
	public TestApp(String message) { //message e numele metodei pe care vreau sa o adaug suitei
		super(message);
	}
	
	@Test
	public void testConstructorNumeNULL()
	{
		Fotbalist fotbalist2 = new Fotbalist(null, "","");
		assertEquals(null, fotbalist2.getNume());
	}
	
	@Test
	public void testConstructorALLNULL()
	{
		Fotbalist fotbalist3 = new Fotbalist(null, null, null);
		assertEquals(null, fotbalist3.getNume());
		assertEquals(null, fotbalist3.getCNP());
		assertEquals(null, fotbalist3.getCodUnic());
	}
	
	@Test 
	public void testGetInfo() // verifica primul caracter din codul unic
	{
		Fotbalist fotbalist4 = new Fotbalist("Vilcan", "1930126520010","1250");
		assertEquals("Accidentat", fotbalist4.getInfo());
	}
	
	@Test 
	public void testGetInfo2() // verifica primul caracter din codul unic
	{
		Fotbalist fotbalist5 = new Fotbalist("Vilcan", "1930126520010","2250");
		assertEquals("Apt", fotbalist5.getInfo());
	}
	
	@Test 
	public void testGetInfo3() // verifica primul caracter din codul unic
	{
		Fotbalist fotbalist6 = new Fotbalist("Vilcan", "1930126520010","3250");
		assertEquals("Imprumutat", fotbalist6.getInfo());
	}
	
	@Test 
	public void testGetInfo4() // verifica primul caracter din codul unic
	{
		Fotbalist fotbalist6 = new Fotbalist("Vilcan", "1930126520010","4250");
		assertEquals("Liber", fotbalist6.getInfo());
	}
	
	@Test
	public void checkInfoChar(){
		Fotbalist fotbalist = new Fotbalist("Cosmin", "1930126520010", "1260");
		int first = fotbalist.getCodUnic().charAt(0);
		if(first == 1){
			assertEquals("Apt", fotbalist.getInfo());
		}
		else{
			assertEquals("Accidentat", fotbalist.getInfo());
			}
	}
	
	@Test
	public void testCodUnic() // verifica ultimul caracter
	{
		Fotbalist fotbalist7 = new Fotbalist("Vilcan", "1930126520010","1263");
		String cod = fotbalist7.getCodUnic();
		assertFalse(fotbalist7.verificareCodUnic(cod));
	}
	
	@Test
	public void testCodUnic2() // verifica ultimul caracter
	{
		Fotbalist fotbalist8 = new Fotbalist("Vilcan", "1930126520010","1360");
		String cod = fotbalist8.getCodUnic();
		assertTrue(fotbalist8.verificareCodUnic(cod));
	}
	

	@Test
	public void testTotalGoluri() // verificam corectitudinea functiei - valori pozitive
	{
		Fotbalist fotbalist8 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		goluri.add(1);
		goluri.add(0);
		goluri.add(1);
		goluri.add(0);
		goluri.add(1);
		goluri.add(0);
		goluri.add(1);
		goluri.add(1);
		fotbalist8.setGoluri(goluri);
		
		int suma = fotbalist8.totalGoluri();
		assertEquals(5, suma);
	}
	
	@Test
	public void testTotalGoluri2() // // verificam corectitudinea functiei - valori negative
	{
		Fotbalist fotbalist9 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		goluri.add(-1);
		goluri.add(0);
		goluri.add(-1);
		goluri.add(0);
		goluri.add(-1);
		goluri.add(0);
		goluri.add(-1);
		goluri.add(-1);
		fotbalist9.setGoluri(goluri);
		
		int suma = fotbalist9.totalGoluri();
		assertEquals(-5, suma);
	}
	
	@Test
	public void testTotalGoluri3() // // verificam corectitudinea functiei - valori amestecate
	{
		Fotbalist fotbalist10 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		goluri.add(1);
		goluri.add(0);
		goluri.add(-1);
		goluri.add(0);
		goluri.add(-1);
		goluri.add(0);
		goluri.add(1);
		goluri.add(-1);
		fotbalist10.setGoluri(goluri);
		
		int suma = fotbalist10.totalGoluri();
		assertEquals(-1, suma);
	}
	
	@Test
	public void testTotalGoluri4() // // verificam corectitudinea functiei - valori extreme
	{
		Fotbalist fotbalist11 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		goluri.add(1215);
		goluri.add(0);
		goluri.add(-121);
		goluri.add(0);
		goluri.add(-1);
		goluri.add(0);
		goluri.add(7);
		goluri.add(-1);
		fotbalist11.setGoluri(goluri);
		
		int suma = fotbalist11.totalGoluri();
		assertEquals(1099, suma);
	}
		
	@Test
	public void testTotalGoluri5() // // verificam functia pentru valori null. Initial gresita, modificam metoda, filtrand elementele cu prin intermediul if.
	{
		Fotbalist fotbalist12 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		goluri.add(null);
		goluri.add(0);
		goluri.add(null);
		goluri.add(0);
		goluri.add(-1);
		goluri.add(0);
		goluri.add(7);
		goluri.add(-1);
		fotbalist12.setGoluri(goluri);
		
		int suma = fotbalist12.totalGoluri();
		assertEquals(5, suma);
	}
	
	@Test
	public void testTotalGoluri6() // // verificam functia pentru valori DOAR null
	{
		Fotbalist fotbalist13 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		goluri.add(null);
		goluri.add(null);
		goluri.add(null);
		goluri.add(null);
		goluri.add(null);
		goluri.add(null);
		goluri.add(null);
		goluri.add(null);
		fotbalist13.setGoluri(goluri);
		
		int suma = fotbalist13.totalGoluri();
		assertEquals(0, suma);
	}
	
	@Test
	public void testTotalGoluri7() // // verificam functia pentru cazul in care nu adaugam inregistrari in vector
	{
		Fotbalist fotbalist14 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		fotbalist14.setGoluri(goluri);
		int suma = fotbalist14.totalGoluri();
		assertEquals(0, suma);
	}
	
	@Test 
	public void testTotalMeciuri() // verificam numarul total de meciuri
	{
		Fotbalist fotbalist15 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(false);
		meciuri.add(true);
		fotbalist15.setMeciuri(meciuri);
		int suma = fotbalist15.totalMeciuri();
		assertEquals(4, suma);
	}
	
	@Test 
	public void testTotalMeciuri2() // verificam numarul total de meciuri pentru valori doar de 0
	{
		Fotbalist fotbalist16 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		meciuri.add(false);
		meciuri.add(false);
		meciuri.add(false);
		meciuri.add(false);
		meciuri.add(false);
		fotbalist16.setMeciuri(meciuri);
		int suma = fotbalist16.totalMeciuri();
		assertEquals(0, suma);
	}
	
	@Test
	public void testTotalMeciuri3() // verificam functia in cazul in care nu adaugam inregistrari la colectie.
	{
		Fotbalist fotbalist17 = new Fotbalist("Vilcan", "1930126520010","1260");
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		fotbalist17.setMeciuri(meciuri);
		int suma = fotbalist17.totalMeciuri();
		assertEquals(0, suma);
	}
	

	@Test 
	public void testMedieGoluri() // verificam corectitudinea functiei 
	{
		Fotbalist fotbalist22 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		goluri.add(2); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(0);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(false);
		fotbalist22.setGoluri(goluri);
		fotbalist22.setMeciuri(meciuri);

		assertEquals(1, fotbalist22.medieGoluri(), 0.1);
	}
	
	@Test 
	public void testMedieGoluri2() // verificam corectitudinea functiei pentru valori de 0. Observam ca nu se poate imparti la 0, generand eroare. Tratam functia introducand un IF.
	{
		Fotbalist fotbalist23 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(0);
		meciuri.add(false);
		meciuri.add(false);
		meciuri.add(false);
		meciuri.add(false);
		meciuri.add(false);
		fotbalist23.setGoluri(goluri);
		fotbalist23.setMeciuri(meciuri);
		assertEquals(0, fotbalist23.medieGoluri(), 0.1);
	}
	
	@Test 
	public void testMedieGoluri3() // verificam functia pentru cazul in care nu adaugam inregistrari in vector
	{
		Fotbalist fotbalist24 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		fotbalist24.setGoluri(goluri);
		fotbalist24.setMeciuri(meciuri);
		assertEquals(0, fotbalist24.medieGoluri(), 0.1);
	}
	
	@Test
	public void testAcordareBonus() // verificare bonus pentru mai putin de 10 goluri si mai mult de 15 meciuri
	{
		Fotbalist fotbalist24 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		
		goluri.add(2); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(0);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);	
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		
		
		fotbalist24.setGoluri(goluri);
		fotbalist24.setMeciuri(meciuri);
		
		assertFalse(fotbalist24.acordareBonus());
		
	}
	@Test
	public void testAcordareBonus2() // verificare bonus pentru mai mult de 10 goluri, dar mai putin de 15 meciuri
	{
		Fotbalist fotbalist25 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		
		goluri.add(2); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(5); 
		goluri.add(2); 
		goluri.add(7); 
		goluri.add(0); 
		goluri.add(0); 
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(false);
		
		fotbalist25.setGoluri(goluri);
		fotbalist25.setMeciuri(meciuri);
		
		assertFalse(fotbalist25.acordareBonus());
		
	}
	
	@Test
	public void testAcordareBonus3() // verificare bonus pentru mai putin de 10 goluri si mai putin de 15 meciuri
	{
		Fotbalist fotbalist25 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		
		goluri.add(2); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(5); 
		goluri.add(2); 
		goluri.add(7); 
		goluri.add(0); 
		goluri.add(0); 
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(false);
		
		fotbalist25.setGoluri(goluri);
		fotbalist25.setMeciuri(meciuri);
		
		assertFalse(fotbalist25.acordareBonus());
		
	}
	
	@Test
	public void testAcordareBonus4() // verificare bonus pentru mai mult de 10 goluri si mai mult de 15 meciuri, dar cu o medie mai mica de 0.75 goluri pe meci
	{
		Fotbalist fotbalist25 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(3); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(2); 
		goluri.add(3); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(2); 
		goluri.add(2); 
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		
		
		fotbalist25.setGoluri(goluri);
		fotbalist25.setMeciuri(meciuri);
		
		assertFalse(fotbalist25.acordareBonus());
		
	}
	
	@Test
	public void testAcordareBonus5() // verificare bonus pentru mai mult de 10 goluri si mai mult de 15 meciuri si o medie mai mare decat 0.75
	{
		Fotbalist fotbalist25 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(3); 
		goluri.add(0); 
		goluri.add(7); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(2); 
		goluri.add(3); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(2); 
		goluri.add(2); 
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		
		fotbalist25.setGoluri(goluri);
		fotbalist25.setMeciuri(meciuri);
		
		assertTrue(fotbalist25.acordareBonus());
		
	}

	@Test
	public void testValoareBonus() // verificam functia in caz ca jucatorul nu este eligibil pentru acordarea bonusului (putine meciuri).
	{
		Fotbalist fotbalist26 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		
		goluri.add(2); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(5); 
		goluri.add(2); 
		goluri.add(7); 
		goluri.add(0); 
		goluri.add(0); 
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(false);
		
		fotbalist26.setGoluri(goluri);
		fotbalist26.setMeciuri(meciuri);
		
		assertEquals(0, fotbalist26.valoareBonus(), 0.1);
		
	}
	
	@Test
	public void testValoareBonus2() // verificam functia in caz ca jucatorul nu este eligibil pentru acordarea bonusului (putine goluri).
	{
		Fotbalist fotbalist26 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(1); 
		goluri.add(0); 
		goluri.add(1); 
		goluri.add(1); 
		goluri.add(2); 
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		
		fotbalist26.setGoluri(goluri);
		fotbalist26.setMeciuri(meciuri);
		
		assertEquals(0, fotbalist26.valoareBonus(), 0.1);
	}
	
	@Test
	public void testValoareBonus3() // verificam functia pentru medie intre 0.75 si 0.85
	{
		Fotbalist fotbalist26 = new Fotbalist("Popescu", "19429305192052", "2950");
		ArrayList<Integer> goluri = new ArrayList<Integer>();
		ArrayList<Boolean> meciuri = new ArrayList<Boolean>();
		
		goluri.add(2); 
		goluri.add(0); 
		goluri.add(0); 
		goluri.add(5); 
		goluri.add(2); 
		goluri.add(7); 
		goluri.add(0); 
		goluri.add(0); 
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(false);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		meciuri.add(true);
		
		fotbalist26.setGoluri(goluri);
		fotbalist26.setMeciuri(meciuri);
		
		assertEquals(0, fotbalist26.valoareBonus(), 0.1);
		
	}
	
	@Test
	public void testCalculareVarsta() // verificam corectitudinea functiei. symbol =1
	{
		Fotbalist fotbalist27 = new Fotbalist("Vilcan", "1930126520010", "2950");
		fotbalist27.calculareVarsta();
		
		assertEquals(22, fotbalist27.calculareVarsta());
	}
	
	@Test 
	public void testCalculareVarsta2()  // verificam corectitudinea functiei. symbol =5
	{
		Fotbalist fotbalist28 = new Fotbalist("Vilcan", "5010126520010", "2950");
		fotbalist28.calculareVarsta();
		
		assertEquals(14, fotbalist28.calculareVarsta());
		
	}
	
	@Test
	public void testCalculareVarsta3() // verificam corectitudinea functiei. symbol =2
	{
		Fotbalist fotbalist29 = new Fotbalist("Vilcan", "2930126520010", "2950");
		fotbalist29.calculareVarsta();
		
		assertEquals(22, fotbalist29.calculareVarsta());
	}
	
	@Test
	public void testCalculareVarsta4() // verificam corectitudinea functiei. symbol =3
	{
		Fotbalist fotbalist30 = new Fotbalist("Vilcan", "3930126520010", "2950");
		fotbalist30.calculareVarsta();
		
		assertEquals(122, fotbalist30.calculareVarsta());
	}
	
	@Test
	public void testCalculareVarsta5() // verificam corectitudinea functiei. symbol =4
	{
		Fotbalist fotbalist31 = new Fotbalist("Vilcan", "4930126520010", "2950");
		fotbalist31.calculareVarsta();
		
		assertEquals(122, fotbalist31.calculareVarsta());
	}
	
	@Test
	public void testCalculareVarsta6() // verificam corectitudinea functiei. symbol =6
	{
		Fotbalist fotbalist32 = new Fotbalist("Vilcan", "6110126520010", "2950");
		fotbalist32.calculareVarsta();
		
		assertEquals(4, fotbalist32.calculareVarsta());
	}
	
	@Test
	public void testCalculareVarsta7() // verificam corectitudinea functiei. symbol = altul inafara de 1, 2, 3, 4, 5, 6
	{
		Fotbalist fotbalist32 = new Fotbalist("Vilcan", "7110126520010", "2950");
		fotbalist32.calculareVarsta();
		
		assertEquals(0, fotbalist32.calculareVarsta());
	}
	
	@Test
	public void testCalculareVarsta8() // verificam corectitudinea functiei. nenascuti
	{
		Fotbalist fotbalist33 = new Fotbalist("Vilcan", "51626520010", "2950");
		fotbalist33.calculareVarsta();
		
		assertEquals(-1, fotbalist33.calculareVarsta());
	}
	
	@Test
	public void testNotaMaxima() // corectitudinea functiei
	{
		Fotbalist fotbalist33 = new Fotbalist("Vilcan", "51626520010", "2950");
		ArrayList<Integer> note = new ArrayList<Integer>();
		note.add(5);
		note.add(3);
		note.add(7);
		note.add(8);
		
		fotbalist33.setNote(note);
		assertEquals(8, fotbalist33.notaMaxima());
	}
	
	@Test
	public void testNotaMaxima2() // in caz ca avem note de 0
	{
		Fotbalist fotbalist34 = new Fotbalist("Vilcan", "51626520010", "2950");
		ArrayList<Integer> note = new ArrayList<Integer>();
		note.add(5);
		note.add(3);
		note.add(0);
		note.add(0);
		
		fotbalist34.setNote(note);
		assertEquals(5, fotbalist34.notaMaxima());
	}
	
	@Test
	public void testNotaMaxima3() // in caz ca avem toate notele de 0
	{
		Fotbalist fotbalist35 = new Fotbalist("Vilcan", "51626520010", "2950");
		ArrayList<Integer> note = new ArrayList<Integer>();
		note.add(0);
		note.add(0);
		note.add(0);
		note.add(0);
		
		fotbalist35.setNote(note);
		assertEquals(0, fotbalist35.notaMaxima());
	}
	
	@Test
	public void testNotaMaxima4() // in caz ca avem doar o nota
	{
		Fotbalist fotbalist35 = new Fotbalist("Vilcan", "51626520010", "2950");
		ArrayList<Integer> note = new ArrayList<Integer>();
		note.add(8);
		
		fotbalist35.setNote(note);
		assertEquals(8, fotbalist35.notaMaxima());
	}
	
	@Test
	public void testNotaMaxima5() // in caz ca nu avem nicio nota inregistrata
	{
		Fotbalist fotbalist35 = new Fotbalist("Vilcan", "51626520010", "2950");
		ArrayList<Integer> note = new ArrayList<Integer>();
		
		fotbalist35.setNote(note);
		assertEquals(0, fotbalist35.notaMaxima());
	}
	
	@Test
	public void testMedieNote() // verificam corectitudinea functiei
	{
		Fotbalist fotbalist36 = new Fotbalist("Vilcan", "1930126520010", "1950");
		ArrayList<Integer> note = new ArrayList<Integer>();
		
		note.add(4);
		note.add(3);
		note.add(7);
		note.add(10);
		
		fotbalist36.setNote(note);
		assertEquals(6, fotbalist36.medieNote(), 0.05);
	}
	
	@Test
	public void testMedieNote2() // verificam corectitudinea functiei - valori extreme
	{
		Fotbalist fotbalist37 = new Fotbalist("Vilcan", "1930126520010", "1950");
		ArrayList<Integer> note = new ArrayList<Integer>();
		
		note.add(0);
		note.add(0);
		note.add(0);
		note.add(10);
		
		fotbalist37.setNote(note);
		assertEquals(2, fotbalist37.medieNote(), 0.05);
	}
	
	@Test
	public void testMedieNote3() // verificam corectitudinea functiei - doar o nota
	{
		Fotbalist fotbalist37 = new Fotbalist("Vilcan", "1930126520010", "1950");
		ArrayList<Integer> note = new ArrayList<Integer>();
		
		note.add(2);
		
		fotbalist37.setNote(note);
		assertEquals(2, fotbalist37.medieNote(), 0.05);
	}
	
	@Test
	public void testMedieNote4() // verificam corectitudinea functiei - part2
	{
		Fotbalist fotbalist37 = new Fotbalist("Vilcan", "1930126520010", "1950");
		ArrayList<Integer> note = new ArrayList<Integer>();
		
		note.add(2);
		note.add(3);
		note.add(9);
		
		fotbalist37.setNote(note);
		assertEquals(3.5, fotbalist37.medieNote(), 0.5);
	}
	
	@Test
	public void testMedieNote5() // verificam corectitudinea functiei - fara nota la colectie (adaugam if pentru numitor)
	{
		Fotbalist fotbalist38 = new Fotbalist("Vilcan", "1930126520010", "1950");
		ArrayList<Integer> note = new ArrayList<Integer>();

		fotbalist38.setNote(note);
		assertEquals(0, fotbalist38.medieNote(), 0.5);
	}
	
	@Test
	public void testGetSituatie() // pentru 1
	{
		Fotbalist fotbalist38 = new Fotbalist("Vilcan", "1930126520010", "1950");
	}
	
	@Test
	public void testGetSituatie2() // pentru 2
	{
		Fotbalist fotbalist38 = new Fotbalist("Vilcan", "1930126520010", "2950");
		assertEquals("Apt", fotbalist38.getSituatie());
	}
	
	@Test
	public void testGetSituatie3() // pentru 3
	{
		Fotbalist fotbalist38 = new Fotbalist("Vilcan", "1930126520010", "3950");
		assertEquals("Imprumutat", fotbalist38.getSituatie());
	}
	@Test
	public void testGetSituatie4() // pentru 4
	{
		Fotbalist fotbalist38 = new Fotbalist("Vilcan", "1930126520010", "4950");
		assertEquals("Liber", fotbalist38.getSituatie());
	}
	
	@Test
	public void testVerificareCNP() // corectitudine
	{
		Fotbalist fotbalist38 = new Fotbalist("Vilcan", "1930126520010", "1950");
		boolean v = fotbalist38.verificaCNP();

		assertTrue(v);
	}
	
	public void testVerificareCNP2() // verificare pentru un caracter diferit
	{
		Fotbalist fotbalist38 = new Fotbalist("Vilcan", "1930126530010", "1950");
		boolean v = fotbalist38.verificaCNP();
		assertFalse(v);
	}
	

}
