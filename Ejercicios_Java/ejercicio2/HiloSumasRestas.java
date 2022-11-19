package ejercicio2;

public class HiloSumasRestas implements Runnable {

	private static int numero=1000;
	private int numveces;
	private String operacion;
	
	
	
	//Constructor de la clase
	 public HiloSumasRestas (int numveces, String operacion) {
		this.numveces = numveces;
		this.operacion = operacion;
	 }
	 
	 
	 
	 
	 
	 //Incrementará numero el numvece indicado
	 public int incrementar (int numveces)
	 {
		 for(int i=0; i<numveces; i++) {
			 numero+=1;
		 }
		 return 0;
	 }
	 
	 //Decrementará numero el numvece indicado
	 public int decrementar (int numveces)
	 {
		 for(int i=0; i<numveces; i++) {
			 numero-=1;
		 }
		 return 0;
	 }
	 
	 
	 
	 
	 
	 public void run() {
		 //Si la operación es “+” se invocará al método incrementar
		 //Si la operación es “-” se invocará al método decrementar
		 
		 switch(operacion){
		 	case "+" :
		 		System.out.println("incrementando "+numveces);
		 		incrementar(numveces);
		 		break;
		 	case "-" :
		 		System.out.println("decrementando "+numveces);
		 		decrementar(numveces);
		 		break;
		 	}

		 System.out.println(" "+numero);
	}
	 
	 
	 public static void main(String[] args) {
		 
		 Thread hilo1 = new Thread(new HiloSumasRestas(100, "+"), "Hilo 1");
		 Thread hilo2 = new Thread(new HiloSumasRestas(100, "-"), "Hilo 2");
		 Thread hilo3 = new Thread(new HiloSumasRestas(1, "+"), "Hilo 3");
		 Thread hilo4 = new Thread(new HiloSumasRestas(1, "-"), "Hilo 4");

		 
		 hilo2.start();
		 hilo3.start();
		 hilo4.start();
		 try {
			hilo2.join();
			hilo3.join();
			hilo4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 hilo1.start();
		 
		 System.out.println("\nResultado final : "+numero);
		 
		 
		 
		 
	}

}
