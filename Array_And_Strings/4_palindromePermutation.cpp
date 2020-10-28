// Given a string(containg spaces), find if it is a permtation of palindrome while ignoring spaces and case

#include<iostream>
using namespace std;

bool isPalinPerm(char* s, int l)
{
	int char_counts[256], asc;
	for(int i=0;i<256;i++)
		char_counts[i] = 0;
	for(int i=0;i<l;i++)
		if(s[i]!=' ')
		{
			asc = (int)s[i];
			if(asc>=65&&asc<=90)
				asc += 32;
			char_counts[asc]++;
		}
	
	int n_odds = 0;
	for(int i=0;i<256;i++)
		if(char_counts[i]%2==1)
			n_odds++;

	if(n_odds>1)
		return false;
	return true;
}

int main()
{
	int l;
	cout<<"Enter the length of the string : ";
	cin>>l;
	char b[1];
	cin.getline(b, sizeof(b));
	char s[l+1];
	cout<<"Enter the string : ";
	cin.getline(s, sizeof(s));
	s[l]='\0';

	if(isPalinPerm(s, l))
		cout<<"Permutaion of a palindrome\n";
	else 
		cout<<"Not a permtation of palindrome\n";

	return 0;
}
