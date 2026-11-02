#include <stdio.h>
main(){
	int a  = 7;
	switch(a){
		case 1:
		case 5:
		case 6:
		printf("Hyderabad\n");
		break;
		
		case 2:
		printf("Bangalore\n");
		
		case 3:
		case 7:
		case 10:
		printf("Chennai\n")	;
		break;
		
		default:
			printf("Delhi\n");
	}
}
