#include <stdio.h>
#pragma warning (disable:4996)

int Sumfunction(int a, int b);
int Mul(int num1, int num2);
double Div(double num1, double num2);
int Min(int num1, int num2);

int main()
{
  int i,j;
  int result, mul, div, min;
  
  printf("정수 두개를 입력하시오.\n");
  scanf_s("%d %d",&i,&j);
  
  result = Sumfunction(i,j);
  mul = Mul(i,j);
  div= Div(i,j);
  min= Min(i,j);
  
  printf("Sum =%d\n",result);
  printf("mul= %d\n",i*j);
  printf("div= %d\n",i/j);
  printf("min= %d\n",i-j);
  
  return 0;
}

int Sumfunction(int a, int b)
{
  return a+b;
}

int Mul(int num1, int num2){
  return num1*num2;
}

double Div(double num1, double num2){
  return num1/num2;
}

int Min(int num1, int num2){
  return num1-num2;
}

