import java.util.*;

public class MatrixChainDynamic {
	
	static int d[] = {5, 4, 4, 11, 7, 8, 7, 12, 6, 9, 8, 7, 5, 12, 13, 15};   //Sequence of dimensions
	static int M[][] = new int[d.length+1][d.length+1];			  //Matrix to store the length
	static int recursiveCall = 0;
	
	public static void main(String args[])
	{	
		for( int i=0; i<d.length ; i++)
			M[i][i] = 0;
		
		MatrixChainDynamic mcd = new MatrixChainDynamic();
		
		//Calling the function and calculating the tume
		double t1 = System.nanoTime();
		mcd.matrixChainDynamic(d.length);
		double t2 = System.nanoTime() - t1;		//Time in nanoseconds calculated
		
		System.out.println("Time taken: " + t2);
		System.out.println("No of recursive calls: " + recursiveCall);
	}

	void matrixChainDynamic(int n)
	{
		//Loops running according to order in which matrix will be filled
		for(int i=n-1; i>=1; i--)		//From bottom to top
		{
			for(int j=i+1; j<n; j++)	//From left to right
			{
				int min = Integer.MAX_VALUE;
				for(int k=i; k<=j-1; k++)
				{
					//Recursive relation made use of
					int m = M[i][k] + M[k+1][j] + (d[i-1]*d[k]*d[j]) ;
					if(min > m)
						min = m;
				}
				M[i][j] = min;  	//Storing the result
			}
		}
		System.out.println("Minimum no.of scalar multiplications: " + M[1][n-1]);
	}
}
