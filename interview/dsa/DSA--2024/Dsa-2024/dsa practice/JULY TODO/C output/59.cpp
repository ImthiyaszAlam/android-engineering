#include <stdio.h>
main(){
int a  = 3;
	abc(a);
}

void abc(int a){
	printf("%d",a);
	if(a){
		abc(a-1);
	}
	printf("%d\n",a);
}
