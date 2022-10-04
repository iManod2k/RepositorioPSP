#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void main(){

	pid_t pid;
	pid = fork();
	
		if (pid == 0){
			printf("El PID del hijo es: %d", getpid());
			system("whoami");
		}else {
			wait(NULL);
			printf("El PID del Padre es: %d", getpid());
		}
		
	sleep(5);
	printf("6");
}
