import java.util.Arrays;
import java.util.Scanner;

class Kruskal{
    static int V, E;
    static int[][] graph;
    //각 노드의 부모
    static int[] parent;
    static int final_cost;
    private static void union(int a, int b){
        a=find(a);
        b=find(b);
        if(a>b){
            parent[a]=b;
        }else{
            parent[b]=a;
        }
    }
    private static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            return find(parent[x]);
        }
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        V=sc.nextInt();//정점
        E=sc.nextInt();//간선의 수
        graph=new int[E][3];
        final_cost=0;
        for(int i=0;i<E;i++){
            graph[i][0]=sc.nextInt();//연결될 간선1
            graph[i][1]=sc.nextInt();//연결될 간선 2
            graph[i][2]=sc.nextInt();//비용
        }
        parent= new int[V];
        Arrays.sort(graph,(o1,o2)->Integer.compare(o1[2],o2[2])); //낮은 비용 순으로 오름차순 정렬.
        for(int i=0;i<V;i++){
            parent[i]=i;//자신의 부모노드는 자신으로 설정
        }

        for(int i=0;i<E;i++){
            //시작정점과 끝 정점의 부모노드가 다르다면.
            if(find(graph[i][0]-1)!=find(graph[i][1]-1)){
                System.out.println(Arrays.toString(graph[i]));
                union(graph[i][0]-1,graph[i][1]-1);
                final_cost+=graph[i][2];
                System.out.println(Arrays.toString(parent));
                continue;
            }
        }
        System.out.print(final_cost);


    }
}