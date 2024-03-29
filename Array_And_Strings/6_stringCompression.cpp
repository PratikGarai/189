// convert strings like aaabbbccab to a3b3c2a1b1 ... if the new string is longer than the original, return that

#include<iostream>
#include<cmath>
using namespace std;

char b[1000000000];

char* process(char* a, int l)
{
	if(l==0||l==1)
	{
		return a;
	}

	int new_length = 0, curr_ind = 0, curr_count=0;
	char curr_char = a[0];

	for(int i=0;i<l;i++)
	{
		if(a[i]==curr_char)
			curr_count++;
		else
		{
			b[curr_ind++] = curr_char;
			int digs = (int)log(curr_count);
			for(int j=0;j<digs;j++)
			{
				int r = curr_count%10;
				b[curr_ind+digs-j-1] = '0'+r;
				curr_count = curr_count/10;
			}
			curr_char = a[i];
			curr_count = 1;
			new_length += digs;
			curr_ind += digs;
		}
	}

	b[curr_ind++] = curr_char;
	int digs = (int)log(curr_count);
	for(int j=0;j<digs;j++)
	{
		int r = curr_count%10;
		b[curr_ind+digs-j-1] = '0'+r;
		curr_count = curr_count/10;
	}
	new_length += digs;
	curr_ind += digs;
	b[curr_ind]  = '\0';

	if(new_length<l)
		return b;
	else
		return a;
}
	

int main()
{
	int l;
	cout<<"Enter the length of the string : ";
	cin>>l;
	char a[l];
	cout<<"Enter the string : ";
	cin>>a;
	a[l] = '\0';
	
	char* c = process(a, l);
	cout<<"The result is : "<<c<<endl;

	return 0;
}
