package Amazon.Graphs;
import java.util.*;
public class CourseSchedule{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        int[] indegree=new int[n];
        for(int i=0;i<m;i++){
            int course=sc.nextInt();
            int prerequisite=sc.nextInt();
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.offer(i);
        }
        int[] order=new int[n];
        int index=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            order[index++]=curr;
            for(int next:adj.get(curr)){
                indegree[next]--;
                if(indegree[next]==0)q.offer(next);
            }
        }
        if(index!=n){
            System.out.println(-1);
        }else{
            for(int i=0;i<n;i++){
                if(i>0)System.out.print(" ");
                System.out.print(order[i]);
            }
            System.out.println();
        }
        sc.close();
    }
}
