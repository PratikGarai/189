import java.util.Scanner;
import java.util.LinkedList;

class LOD
{
	int[][] table;
	int v,root;
	LOD(int n, int r)
	{
		v = n;
		table = new int[v][v];
		root = r;
	}

	void LOD_main()
	{
		LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
		boolean[] visited = new boolean[v];
		int depths = -1;

		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer> depth = new LinkedList<Integer>();
		
		queue.addLast(root);
		depth.addLast(0);
		// visited[root] = true;
		while(!queue.isEmpty())
		{
			int vertex = queue.pollFirst();
			int d = depth.pollFirst();

			if(visited[vertex])
				continue;

			visited[vertex] = true;

			if(d>depths)
			{
				depths+=1;
				list.addLast(new LinkedList<Integer>());
			}
			list.get(d).addLast(vertex);

			for(int i=0;i<v;i++)
			{
				if(table[vertex][i]==1 && !visited[i])
				{
					// System.out.println(i+" "+d+1);
					queue.addLast(i);
					depth.addLast(d+1);
				}
			}
		}

		for(int i=0;i<depths+1;i++)
		{
			System.out.print(i+" : ");
			for(int j: list.get(i))
				System.out.print(j+" ");
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of vertices : ");
		int v = in.nextInt();
		System.out.print("Enter the number of edges : ");
		int e = in.nextInt();
		System.out.print("Enter the root element : ");
		int r = in.nextInt();
		LOD ob = new LOD(v, r);
		int a,b;
		for(int i=0;i<e;i++)
		{
			System.out.print("Enter the edge : ");
			a = in.nextInt();
			b = in.nextInt();
			ob.table[a][b] = 1;
			ob.table[b][a] = 1;
		}

		ob.LOD_main();
	}
}
