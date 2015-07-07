import java.util.*;

public class MatrixChainRecursive {
	
	static int d[] = {5, 4, 4, 11, 7, 8, 7, 12, 6, 9, 8, 7, 5, 12, 13, 15};
	static int M[][] = new int[d.length+1][d.length+1];
	static int recursiveCall = -1;		//Initialized -1, to not count the first call of the function
	
	public static void main(String args[])
	{	
		MatrixChainRecursive mcr = new MatrixChainRecursive();
		
		double t1 = System.nanoTime();
		M[1][d.length-1] = mcr.matrixChainRecursive(1, d.length-1);
		double t2 = System.nanoTime() - t1;
		
		System.out.println("Minimum no.of scalar multiplications: " + M[1][d.length-1]);
		System.out.println("Time taken: " + t2);
		System.out.println("No of recursive calls: " + recursiveCall);
	}
	
	int matrixChainRecursive(int i, int j)
	{
		recursiveCall += 1;		//Counting the no.of recursive calls
		
		if(i==j)				//Basis condition
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		for(int k=i; k<=j-1; k++)
		{
			//recursive call
			int m = matrixChainRecursive(i, k) + matrixChainRecursive(k+1, j) + (d[i-1]*d[k]*d[j]);
			if(min > m)
				min = m;
		}
		return min;
	}
}
