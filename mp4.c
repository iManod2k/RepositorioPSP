#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include<sys/wait.h>
void main()
{ 
 printf("CCC \n");
 if (fork()!=0) 
 {
 wait(NULL);
 printf("AAA \n");
 }else {
 printf("BBB \n");
 } 
 
 exit(0);
}
