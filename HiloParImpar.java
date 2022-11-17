package ejercicio1;

public class HiloParImpar implements Runnable {
	
	// Min 1
	// Max 2
	private int tipo;
	
	
	HiloParImpar(int tipo) {
		this.tipo = tipo;
	}
	
	
	public void pares() throws InterruptedException {
		for(int i=1; i<=100; i++) {
			
			if (i%2==0) {
				System.out.println(Thread.currentThread().getName()+" "+i);
				Thread.sleep(1);
			}
			
		}
	}
	
	public void impares() throws InterruptedException {
		for(int i=101; i<=200; i++) {
			
			if (i%2!=0) {
				System.out.println(Thread.currentThread().getName()+" "+i);
				Thread.sleep(1);
			}
		}
	}
	
	
	
	public void start() {
		run();
	}
	public void run() {
		
		switch(tipo) {
		case 1: try {
				pares();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		break;
		
		
		
		
		case 2: try {
				impares();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		break;
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		//bucle(2);
		Thread t1 = new Thread(new HiloParImpar(1), "Hilo 1");
		Thread t2 = new Thread(new HiloParImpar(2), "Hilo 2");
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
		
	}
}
