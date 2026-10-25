
import java.util.*;
public class RottingOranges{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] grid=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(orangesRotting(grid));
        sc.close();
    }
    static int orangesRotting(int[][] grid){
        int m=grid.length,n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0,minutes=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)q.offer(new int[]{i,j});
                else if(grid[i][j]==1)fresh++;
            }
        }
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!q.isEmpty()&&fresh>0){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] curr=q.poll();
                for(int d=0;d<4;d++){
                    int r=curr[0]+dr[d];
                    int c=curr[1]+dc[d];
                    if(r>=0&&r<m&&c>=0&&c<n&&grid[r][c]==1){
                        grid[r][c]=2;
                        fresh--;
                        q.offer(new int[]{r,c});
                    }
                }
            }
            minutes++;
        }
        return fresh==0?minutes:-1;
    }
}
