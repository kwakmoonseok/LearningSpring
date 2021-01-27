package Generic;

public class GenericPrinterTest {
	public static void main(String[] args) {
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
		
		Powder powder = new Powder();
		powderPrinter.setMeterial(powder);
		
		System.out.println(powderPrinter);
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		
		Plastic plastic = new Plastic();
		plasticPrinter.setMeterial(plastic);
		
		System.out.println(plasticPrinter);
	}
}
