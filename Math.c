#include <stdio.h>
#pragma warning (disable:4996)

int Sumfunction(int num1, int num2);
int Mul(int num1, int num2);
double Div(double num1, double num2);
int Min(int num1, int num2);

int main()
{
  int i,j;
  int sum, mul,min;
  double div;
  
  printf("정수 두개를 입력하시오.\n");
  scanf_s("%d %d",&i,&j);
  
  sum = Sumfunction(i,j);
  mul = Mul(i,j);
  div= Div(i,j);
  min= Min(i,j);
  
  printf("Sum =%d\n",sum);
  printf("mul= %d\n",mul);
  printf("div= %f\n",div);
  printf("min= %d\n",min);
  
  return 0;
}

int Sumfunction(int num1, int num2)
{
  return num1+num2;
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

