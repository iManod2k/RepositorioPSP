#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <time.h>



void padre(){
	// Obtengo la fecha y la guardo
	char fecha[20];
	time_t now = time(NULL);
	struct tm *t = localtime(&now);

	strftime(fecha, sizeof(fecha)-1, "%d %m %Y %H:%M \n", t);
	
	
	// Empiezo a Escribir en el PIPE
	
	int  fp;

	fp = open("FIFO1",1);
	write(fp,fecha,sizeof(fecha)-1);
	close(fp);
	
}





void hijo(){

	printf("Soy el proceso hijo con pid %d: ", getpid());

	// Comienzo a Leer el PIPE
	
	int  fp;
	int  p,  bytesleidos;
	char buffer[10];

	p=mkfifo("FIFO1",  S_IFIFO|0666);//permiso  de  lecture y escritura

		fp = open("FIFO1", 0);
		bytesleidos=read(fp,buffer,1) ; 
			while 	(bytesleidos!=0)
			{
				printf("%c",buffer[0]);
				bytesleidos=read(fp,buffer,1)	;//leo  otro  byte
			}
	close(fp); 

}


int main()
{

	pid_t pid;

	pid = fork();
	
		if(pid==0){
			hijo();
		}else {
			padre();
			wait(NULL);
		}

}
