package ejercicio1;

public class HiloParImparEjecutar implements Runnable {
	
	// Min 1
	// Max 2
	private int tipo;
	
	
	HiloParImparEjecutar(int tipo) {
		this.tipo = tipo;
	}
	
	
	public void pares() throws InterruptedException {
		for(int i=1; i<=100; i++) {
			
			if (i%2==0) {
				System.out.println(Thread.currentThread().getName()+" generando numero par "+i);
				Thread.sleep(1);
			}
			
		}
	}
	
	public void impares() throws InterruptedException {
		for(int i=101; i<=200; i++) {
			
			if (i%2!=0) {
				System.out.println(Thread.currentThread().getName()+" generando numero impar "+i);
				Thread.sleep(1);
			}
		}
	}
	
	
	
	public void start() {
		run();
	}
	
	public void run() {
		
		switch(tipo) {
			case 1:
				try {
					pares();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			break;
			
			case 2:
				try {
					impares();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			break;
			
			default: System.out.println("Error...");
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		//bucle(2);
		Thread t1 = new Thread(new HiloParImparEjecutar(1), "Hilo 1");
		Thread t2 = new Thread(new HiloParImparEjecutar(2), "Hilo 2");
		
		
		
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		
		
	}
}
