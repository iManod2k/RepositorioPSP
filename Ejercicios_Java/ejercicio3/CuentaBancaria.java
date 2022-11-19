package ejercicio3;

public class CuentaBancaria {

	int saldo = 1000;
	
	
	
	void sacarDinero (String nombre, int importe)
	{
	
	//Después de la operación dormir el hilo
		 try {
			 Thread.sleep(1000);
			 Thread hiloSacar = new Thread(new HiloSacarDinero(this, nombre, importe));
			 hiloSacar.start();
		 }
		 catch (InterruptedException e) {
			 e.printStackTrace();
		 }
	
	}
	
	
	
	
	void ingresarDinero (String nombre, int importe)
	{
	
	//Después de la operación dormir el hilo 
		try {
			Thread.sleep(1000);
			Thread hiloIngresar = new Thread(new HiloIngresarDinero(this, nombre, importe));
			hiloIngresar.start();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


	
	
	


	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
}
