package ejercicio3;

public class HiloCajeroAutomático {
	 
	 public static void main(String[] args)
	 {
		 
		 //ingresarDinero
		 //sacarDinero
		 CuentaBancaria cb = new CuentaBancaria();
		 cb.sacarDinero("Padre", 200);
		 cb.sacarDinero("Madre", 800);
		 cb.sacarDinero("Hijo1", 300);
		 cb.sacarDinero("Hijo2", 800);
	 }	 
}