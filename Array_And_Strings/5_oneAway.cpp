// there are 3 operations : insert a character, delete a character, replace a character. 
// Given 2 strings, find whether one needs 1 or 0 operations to convert to the other.

#include<iostream>
using namespace std;

bool isOneAway(char* a, char* b, int m, int n)
{
	if(m-n>=2)
		return false;
	int p1=0, p2=0;
	while(p1<m && p2<n)
	{
		if(a[p1]==b[p2])
		{
			p1++;
			p2++;
		}
		else if(p2!=p1)
			return false;
		else if(m>n)
			p1++;
		else 
			p2++;
	}

	return true;
}

int main()
{
	int m,n;
	cout<<"Enter the length of the first string : ";
	cin>>m;
	char a[m];
	cout<<"Enter the string : ";
	cin>>a;
	a[m] = '\0';
	cout<<"Enter the length of the second string : ";
	cin>>n;
	char b[n];
	cout<<"Enter the string : ";
	cin>>b;
	b[n] = '\0';

	if(isOneAway(a,b,m,n))
		cout<<"One away\n";
	else
		cout<<"More than one away\n";

	return 0;
}
