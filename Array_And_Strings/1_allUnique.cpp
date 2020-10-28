//Determine if a string has all unique characters with and without external structure

#include<iostream>
using namespace std;

// with structure
bool s_check(char *s, int l)
{
	int n[256];
	for(int i=0;i<256;i++)
		n[i] = 0;
	for(int i=0;i<l;i++)
		if(n[(int)s[i]]==0)
			n[(int)s[i]] = 1;
		else
			return false;
	return true;
}


//without structure
bool ns_check(char *s, int l)
{
	if(l>256)
		return false;
	for(int i=0;i<l-1;i++)
		for(int j=1;j<l;j++)
			if(i!=j && s[i]==s[j])
				return false;
	return true;
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
		cout<<"With structure check : yes"<<endl;
	else
		cout<<"With structure check : no"<<endl;
	if(a2)
		cout<<"Without structure check : yes"<<endl;
	else
		cout<<"Without structure check : no"<<endl;

	return 0;
}
