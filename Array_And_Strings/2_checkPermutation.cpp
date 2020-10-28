// Given 2 strings , check if one is permutaion of the other

#include<iostream>
using namespace std;

bool check(char* a, char* b, int m, int n)
{
	if(m!=n)
		return false;
	int alpha_count[256];
	for(int i=0;i<256;i++)
		alpha_count[i] = 0;
	for(int i=0;i<m;i++)
		alpha_count[(int)a[i]]++;
	for(int i=0;i<m;i++)
		alpha_count[(int)a[i]]--;
	for(int i=0;i<256;i++)
		if(alpha_count[i]!=0)
			return false;
	return true;
}

int main()
{
	int m,n;
	cout<<"Enter the length of string 1 : ";
	cin>>m;
	char a[m];
	cout<<"Enter string 1 : ";
	cin>>a;
	a[m] = '\0';
	cout<<"Enter the length of string 2 : ";
	cin>>n;
	char b[n];
	cout<<"Enter string 2 : ";
	cin>>b;
	b[n] = '\0';

	if(check(a,b,m,n))
		cout<<"Yes\n";
	else 
		cout<<"No\n";

	return 0;
}
