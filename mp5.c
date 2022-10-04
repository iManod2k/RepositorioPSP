#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main()
{ 
 pid_t pid1, pid2; 
 
 printf("1 AAA \n");
 
 pid1 = fork();
 
 if (pid1==0) 
 {
 
 printf("2 BBB \n");
 } 
 else 
 {
 wait(NULL); 
 pid2 = fork();

 printf("3 CCC \n");
 
 } 
 
 exit(0);
}
