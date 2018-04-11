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
  
  printf("Sum =%d\n",i+j);
  printf("mul= %d\n",i*j);
  printf("div= %d\n",i/j);
  printf("min= %d\n",i-j);
  
  return 0;
}

int Sumfunction(int a, int b)
{
  return a+b;
}
