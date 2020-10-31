// rotate a square matrix by 90deg right without using another matrix

#include<iostream>
using namespace std;

void get_rotated(int *mat,int n)
{
	int h = n/2;
	if(n%2==1)
		h = h+1;
	for(int i=0;i<h;i++)
	{
		for(int j=0;j<h;j++)
		{
			int a,b,c,d;
			a = mat[i*n+j];
			b = mat[j*n+n-1-i];
			c = mat[(n-1-i)*n+n-1-j];
			d = mat[(n-1-j)*n+i];
			mat[i*n+j] = d;
			mat[j*n+n-1-i] = a;
			mat[(n-1-i)*n+n-1-j] = b;
			mat[(n-1-j)*n+i] = c;
		}
	}
}

int main()
{
	int n,x;
	cout<<"Enter the length of a side : ";
	cin>>n;

	int* mat = new int[n*n];
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			cout<<"Enter the value at "<<i+1<<"th row and "<<j+1<<"th column : ";
			cin>>x;
			mat[i*n+j] = x;
		}
	}

	cout<<endl<<"The original matrix is :"<<endl;
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			cout<<mat[i*n+j]<<" ";
		}
		cout<<endl;
	}

	cout<<endl<<"The new matrix is :"<<endl;
	get_rotated(mat,n);
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			cout<<mat[i*n+j]<<" ";
		}
		cout<<endl;
	}

	return 0;
}
