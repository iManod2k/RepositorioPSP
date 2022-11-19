package ejercicio3;

public class HiloIngresarDinero extends Thread {

	private CuentaBancaria cuenta;
	private String nombre;
	private int cantidad;
	// Constructor de la clase
	HiloIngresarDinero (CuentaBancaria micuenta, String nombre, int cantidad)
	{
		cuenta = micuenta;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public void run() {
		cuenta.setSaldo(cuenta.getSaldo() + cantidad);
		System.out.println(nombre+" ha ingresado +"+cantidad+"€ -> "+cuenta.getSaldo());
	}
}
