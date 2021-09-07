import java.util.Scanner;

public class HeapSort {
    static public class DfsGraph{
        private int nV;
        private int[][] dfsGraph;  //그래프
        private boolean[] visitArr;   //정점 방문 여부

        DfsGraph(int nV){
            this.nV=nV;
            this.dfsGraph=new int[nV+1][nV+1];
            this.visitArr=new boolean[nV+1];


        }

        public void put(int x, int y){//양방향

            dfsGraph[x][y]=dfsGraph[y][x]=1;
        }
        public void putSingle(int x, int y){//단방향

            dfsGraph[x][y]=1;
        }
        //그래프 탐색
        public void dfs(int index){
            this.visitArr[index]=true;
            System.out.print(index+" ");

            for(int i=1;i<=this.nV;i++){
                if(dfsGraph[index][i]==1 && !visitArr[i]){
                    dfs(i);
                }
            }

        }
    }


    static public void main(String[] args){

        int nV=0;//정점의 개수
        int nE=0;//간선의 개수

        Scanner sc=new Scanner(System.in);
        nV = sc.nextInt();    // 정점
        nE = sc.nextInt();
        DfsGraph dfsGraph= new DfsGraph(nV);

        dfsGraph.put(1, 2);
        dfsGraph.put(1, 3);
        dfsGraph.put(2, 4);
        dfsGraph.put(2, 5);
        dfsGraph.put(3, 6);
        dfsGraph.put(3, 7);
        dfsGraph.put(4, 8);
        dfsGraph.put(5, 8);
        dfsGraph.put(6, 8);
        dfsGraph.put(7, 8);

        dfsGraph.dfs(1);
    }
}
