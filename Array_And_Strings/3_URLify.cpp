// Replace all occurences of space(" ") in a string with "%20" .

#include<iostream>
using namespace std;

char* str;

char* urlify(char* s, int n)
{
	int space_count = 0;
	for(int i=0;i<n;i++)
	{
		if(s[i]==' ')
			space_count++;
	}

	int strlen = n+space_count*2;
	str = new char[strlen];
	int ind = strlen-1;
	for(int i=n-1;i>=0;i--)
	{
		if(s[i]==' ')
		{
			str[ind] = '0';
			str[ind-1] = '2';
			str[ind-2] = '%';
			ind -= 3;
		}
		else
		{
			str[ind] = s[i];
			ind--;
		}
	}
	
	str[strlen] = '\0';
}

int main()
{
	int n;
	cout<<"Enter the length of the string : ";
	cin>>n;
	char buff[1];
	cin.getline(buff, sizeof(buff));
	char s[n+1];
	cout<<"Enter the string : ";
	cin.getline(s, sizeof(s));
	s[n+1] = '\0';
	
	urlify(s,n);
	cout<<"Result : "<<str<<endl;

	return 0;
}
