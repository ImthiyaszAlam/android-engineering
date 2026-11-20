#include <stdio.h>
main(){
	int i,c=0,n=5;
	for(i=1;i<=n;i++){
		if(n%i ==0){
			c++;
		}
	}
	if(c ==2){
		printf("is prime");
	}else{
		printf("is not a prime");
	}
}
