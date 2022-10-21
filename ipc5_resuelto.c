#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include<time.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <string.h>


char letra[1];



void escribirPipe(char dni[], char pipe[]){

	// Empiezo a Escribir en el PIPE
	int  fp;
	fp = open(pipe,1);
	
	write(fp,dni,strlen(dni)+1);

	close(fp);
}



void calcularDni(char dni[]){

	char letrasValidas[23] = "TRWAGMYFPDXBNJZSQVHLCKE";
	char dniSinLetra[9];
	
	strcpy(dniSinLetra, dni);
	dniSinLetra[8] = ' ';
	
	
	int restoNumeroDni = (atoi(dniSinLetra)%23)-1;
	
	
	
	
	if (dni[8] == letrasValidas[restoNumeroDni]) {
		printf("DNI Valido !");
		
		char resultadoLetra[1] = {dni[8]};
		letra[0] = (char)dni[8];
		
		escribirPipe( dni, "FIFO2");
		
		}else {
		printf("Incorrecto: Tendria que tener la letra %c", letrasValidas[restoNumeroDni]);
		}
}





void leerPipe(char pipe[]){
	
	char dni[9];
	int cont = 0;

	// Comienzo a Leer el PIPE
	
	int  fp;
	int  p,  bytesleidos;
	char buffer[10];

	p=mkfifo(pipe,  S_IFIFO|0666);//permiso  de  lecture y escritura
	
	fp = open(pipe, 0);
	
	
	do{
		bytesleidos=read(fp,buffer,1)	;//leo  otro  byte
		dni[cont] = buffer[0];
		printf("%c", buffer[0]);
		cont++;
	}while(bytesleidos != 0);
	
	
	if (strlen(dni) == 1){
	printf("LA LETRA ES %c", dni[0]);
	}
	
	calcularDni(dni);
	
	
	close(fp); 
}





void hijo(){
	escribirPipe("06602578J", "FIFO1");
	
		wait(NULL);

	leerPipe("FIFO2");
}

void padre(){
	leerPipe("FIFO1");
	
	escribirPipe(letra, "FIFO2");
}








int main(){

pid_t pid;
pid = fork();
		

	if(pid==0){
		hijo();
		
	}else {
		padre();
	}
	
return 0;
}












