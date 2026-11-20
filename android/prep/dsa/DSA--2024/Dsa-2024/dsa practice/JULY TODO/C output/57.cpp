#include <stdio.h>
void fun(int);
main(){
	int x=2;
	fun(x++);
	
}
void fun(int x){
	printf("x value: %d\n",x++);
}
