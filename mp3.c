#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void main(){

// Proceso padre

pid_t pid1, pid2;


	pid1 = fork();

	
	
	if (pid1 == 0){
		sleep(10);
		printf("\nP2\nDespierto !");
	}else {
		pid2 = fork();
		
		if (pid2 == 0){
			printf("\nP3\nPID: %d\nPPID: %d",getpid(),getppid());
		}
		
		wait(NULL);
	}
	
	

}
