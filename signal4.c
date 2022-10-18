#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

/* gestión de señales en proceso padre       */
void manejador_Hijo(int cod)
{
 printf("Hijo recibe señal número..");
}


void manejador_Padre(int cod)
{
 printf("Papa recibe señal del hijo.. %d", cod);
}





int main()
{
  int pid_hijo;  
  pid_hijo = fork(); //creamos hijo   
  
  switch(pid_hijo)
  {
     case -1:
          printf( "Error al crear el proceso hijo...\n");
          exit( -1 );        
     case 0:   //HIJO > Envia señal al papa 	
		signal(SIGUSR1, manejador_Hijo); //Capturo señales   
		pause();
          break;    
     default: //PADRE
     		kill(pid_hijo,SIGUSR1);
          break;
  } 
  return 0;
}
