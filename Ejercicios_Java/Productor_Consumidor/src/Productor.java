import java.text.DecimalFormat;
import java.util.Random;

public class Productor extends Thread {

	private Deposito dep;
	
	Productor(Deposito dep){
		this.dep = dep;
	}
	
	
	public void run() {
		llenarDeposito();
	}
	
	
	void llenarDeposito() {
		
		for(int i=0; i < 15; i++) {	
			double numeroRandom = new Random().nextDouble(1000);
			dep.cargarAlDeposito((Math.round(numeroRandom*100.00)/100.00)); 
		}
	}
	
}