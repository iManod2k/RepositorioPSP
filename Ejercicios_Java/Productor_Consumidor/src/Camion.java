public class Camion extends Thread {

	private Deposito dep;
	private int numeroCamion;
	double litros = 0;
	
	private int vecesCargado; // Max 5
	
	Camion(Deposito dep, int numeroCamion){
		this.dep = dep;
		this.numeroCamion = numeroCamion;
	}
	
	
	public void run() {
		
		while(vecesCargado < 5) {
			dep.cargarAlCamion(this);
			vecesCargado++;
		}
	}
}