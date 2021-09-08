import java.util.*;

public class Main {
    static int[][] graph;
    static int[] parent;
    static int distance;
    static public void union(int x, int y){
        x=find(x);
        y=find(y);
        if(x>y){
            parent[x]=y;
        }else{
            parent[y]=x;
        }

    }

    static public int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            return find(parent[x]);
        }
    }
    static public void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        distance=0;
        int nV= sc.nextInt(); // 정점의 수
        int nE=sc.nextInt(); // 간선의 수
        graph=new int[nE][3];
        parent = new int[nV+1];
        for(int i=1;i< parent.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<nE;i++){
            graph[i][0]=sc.nextInt();
            graph[i][1]= sc.nextInt();
            graph[i][2]= sc.nextInt();
        }
        Arrays.sort(graph,((o1, o2) -> Integer.compare(o1[2],o2[2]))); //비용 순으로 오름차순 정렬
        for(int i=0;i<nE;i++){
            if(find(graph[i][0])!=find(graph[i][1])){
                union(graph[i][0],graph[i][1]);
                distance+=graph[i][2];
            }
        }
        System.out.println(distance);
    }
}
