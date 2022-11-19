package ejercicio3;

public class HiloSacarDinero extends Thread {
	private CuentaBancaria cuenta;
	private String nombre;
	private int cantidad;
	
	 // Constructor de la clase
	 HiloSacarDinero(CuentaBancaria micuenta, String nombre, int cantidad)
	 {
		 cuenta = micuenta;
		 this.nombre = nombre;
		 this.cantidad = cantidad;
	 }
	 
	 public void run() {
		 
		 if (comprobarOperacion()) {
			 
			 cuenta.setSaldo(cuenta.getSaldo() - cantidad);
			 System.out.println(nombre+" ha sacado -"+cantidad+"€ -> "+cuenta.getSaldo());
		 }else {
			 System.out.println(nombre+" no pudo sacar dinero -> Numeros Rojos");
		 }
		 
	 }
	 
	 
	 
	 
	 private boolean comprobarOperacion() {
		 
		 if ((cuenta.getSaldo() - cantidad) < 0)
			 return false;
			 
		 return true;
	 }

}
