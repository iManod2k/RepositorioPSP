
public class Deposito {

	public double depLitros;
	private boolean disponible;
	
	Deposito(){
		disponible = true;
		depLitros = 0;
	}
		
	
	public synchronized void cargarAlCamion(Camion camion) {
		
		while(disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		camion.litros += depLitros;
		System.out.println("cargar camion "+Thread.currentThread().getName()+" "+camion.litros);
		
		disponible = true;
		notify();
	}
	
	
	public synchronized void cargarAlDeposito(double litro) {
		
		while(!disponible) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+"carga el deposito con => "+litro);
		
		disponible = false;
		depLitros = litro;
		notify();
	}
}
