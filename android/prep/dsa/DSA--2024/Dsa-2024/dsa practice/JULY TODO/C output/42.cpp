#include <stdio.h>
main(){
	int x = 10;
	int y=15;
	if(++x>10 || ++y>15){
		x++;
	}else{
		y++;
	}
	printf("x:%f y:%f",x,y);
}
