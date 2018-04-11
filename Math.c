#include <stdio.h>
#pragma warning (disable:4996)
int Sumfunction(int a, int b);

int main()
{
  int i,j;
  int result;
  
  printf("정수 두개를 입력하시오.\n");
  scanf("%d %d",&i,&j);
  
  result = Sumfunction(i,j);
  
  printf("Sum =%d",i+j);
  printf("mul= %d",i*j);
  printf("div= %d",i/j);
  printf("min= %d",i-j);
  
  return 0;
}

int Sumfunction(int a, int b)
{
  return a+b;
}
