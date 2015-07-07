import java.util.*;

public class MatrixChainMemoized {
	
	static int d[] = {5, 4, 4, 11, 7, 8, 7, 12, 6};  		//Sequence of Dimensions
	static int M[][] = new int[d.length][d.length];  		//2-D matrix storing the length
	static int recursiveCall = -1;					//To measure no.of recursive calls
	
	public static void main(String args[])
	{
		//Initialising M[][] Matrix
		for(int i=0;i<d.length; i++)
			for(int j=0; j<d.length; j++)
				M[i][j] = Integer.MAX_VALUE;
		
		MatrixChainMemoized mcm = new MatrixChainMemoized();
		
		//Calling the Algorithm and calculating time
		double t1 = System.nanoTime();
		mcm.matrixChainMemoized(1, d.length-1);
		double t2 = System.nanoTime() - t1;
		
		System.out.println("Minimum No of scalar multiplications: " + M[1][d.length-1]);
		System.out.println("Time taken to run the program: " + t2);
		System.out.println("No of recursive calls: " + recursiveCall);
	}
	
	int matrixChainMemoized(int i, int j)
	{
		++recursiveCall;

		//Checking if value already calculated: memoized version
		if(M[i][j] < Integer.MAX_VALUE)
			return M[i][j];
		
		//Checks if  i=j
		if(i==j)
			return 0;
		int min = Integer.MAX_VALUE;
		
		for(int k=i; k<=j-1; k++)
		{
			//Recursive call
			int m = matrixChainMemoized(i, k) + matrixChainMemoized(k+1, j) + (d[i-1]*d[k]*d[j]);
			if(min > m)
				min = m;  					//Storing the minimum value
		}
		M[i][j] = min; 							//Storing the value to avaoid multiple same recursive calls
		return min;
	}
}
