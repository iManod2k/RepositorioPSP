#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>




int main()
{


int pp1[2], pp2[2];
char buffer[8]; //Del tamaño de un DNI
char b[1];

pid_t pid;


pipe(pp1);
pipe(pp2);


pid = fork();




	if (pid == 0){
	//pipe 1 #1
		close(pp1[0]); // Cerramos el "canal" de Lectura
		write(pp1[1], "50123456", 8);//escribimos
		
		wait(NULL);
	
	//pipe 2 #4
	close(pp2[1]); // Cerramos el "canal" de escritura
	read(pp2[0], b, 1);// Leemos la Letra
	
	printf("%s", b);

	}else {
	//pipe 1 #2
		close(pp1[1]); // Cerramos el "canal" de escritura
		read(pp1[0], buffer, 8);// Leemos el DNI y lo guardamos
		printf("%s\n", buffer);
		
		int dni = atoi(buffer); // Convierto el STRING del DNI a Int
		
		char letra[] = "TRWAGMYFPDXBNJZSQVHLCKE";
		char letraResul[1];
		
		dni = dni % 23;
		letraResul[0] = letra[dni]; // Calculo la Letra
		
			
	//pipe 2 #3
	close(pp2[0]); // Cerramos el "canal" de Lectura
	write(pp2[1], letraResul, 1);// Escribimos la Letra
	
	wait(NULL);
	}

return 0;
}
