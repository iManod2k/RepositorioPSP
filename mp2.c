#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void main(){
	
// Proceso papa
	pid_t hijo, nieto;
	int pidhijo;
	
	hijo = fork();
	
	
		if(hijo == 0){
			
			nieto = fork();
			
			if(nieto == 0){
				printf("nieto---\nPID:%d\nPPID:%d\n\n",getpid(),getppid());
			}else {
				// Espera q que el nieto acabe
				wait(NULL);
				printf("hijo---\nPID:%d\nPPID:%d\n\n",getpid(),getppid());
			}
			
		}else {
				// Espera q que el hijo acabe
				wait(NULL);
				printf("padre---\nPID:%d\nPPID:%d\n",getpid(),getppid());
				printf("mi hijo--- tiene el PID: %d", hijo);
		}

}
