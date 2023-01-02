
public class Principal {

	private static Deposito dep = new Deposito();
	
	public static Camion c1 = new Camion(dep, 1);
	public static Camion c2 = new Camion(dep, 2);
	public static Camion c3 = new Camion(dep, 3);
	
	private static Productor prod = new Productor(dep);
	
	
	
	
	public static void main(String[] args) {
		
		c1.setName("Camion 1");
		c2.setName("Camion 2");
		c3.setName("Camion 3");
		prod.setName("Productor");
		
		prod.start();
		c1.start();
		c2.start();
		c3.start();
	}
}

