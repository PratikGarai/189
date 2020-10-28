//Determine if a string has all unique characters with and without external structure

#include<iostream>
using namespace std;

bool s_check(char *s, int l)
{
	return true;
}

bool ns_check(char *s, int l)
{
	return false;
}

int main()
{
	int l;
	cout<<"Enter the length of the string : ";
	cin>>l;
	char s[l];
	cout<<"Enter the string : ";
	cin>>s;
	s[l] = '\0';

	bool a1 = s_check(s, l);
	bool a2 = ns_check(s, l);

	if(a1)
		cout<<"With structure check : true"<<endl;
	else
		cout<<"With structure check : false"<<endl;
	if(a2)
		cout<<"Without structure check : true"<<endl;
	else
		cout<<"Without structure check : false"<<endl;

	return 0;
}
