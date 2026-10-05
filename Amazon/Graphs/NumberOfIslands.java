package Amazon.Graphs;
import java.util.*;
public class NumberOfIslands 
{
    public static void main (String args[])
    {
    Scanner sc=new Scanner(System.in);
    int m=sc.nextInt();
    int n=sc.nextInt();
    int grid[][]=new int[m][n];
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            grid[i][j]=sc.nextInt();
        }
    }
    System.out.println(numIslands(grid));
    }
    static int numIslands(int[][] grid) 
    {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    static void dfs(int[][] grid, int i, int j)
    {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0)return;
        grid[i][j]=0;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}

