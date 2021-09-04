import java.util.ArrayList;
import java.util.Scanner;

public class HeapSort {
    static public class DfsGraph{
        private int nV;
        private ArrayList<ArrayList<Integer>> dfsGraph;  //그래프
        private boolean[] visitArr;   //정점 방문 여부

        DfsGraph(int nV){
            this.nV=nV;
            this.dfsGraph = new ArrayList<ArrayList<Integer>>();

            for(int i=0;i<this.nV+1;i++){
                this.dfsGraph.add(new ArrayList<Integer>());
            }
            this.visitArr=new boolean[nV+1];


        }

        public void put(int x, int y){//양방향
            dfsGraph.get(x).add(y);
            dfsGraph.get(y).add(x);
        }
        public void putSingle(int x, int y){//단방향
            dfsGraph.get(x).add(y);
        }
        //그래프 탐색
        public void dfs(int index){
            this.visitArr[index]=true;
            //System.out.print(index+" ");
            //해당 인덱스의 리스트를 가져온다.
            for(int i: this.dfsGraph.get(index)){

                if(this.visitArr[i]==false){
                    System.out.print(i+" ");
                    dfs(i);
                }
            }

        }
    }


    static public void main(String[] args){
        int nV = 0;    // 정점의 개수
        int nE = 0;    // 간선의 개수

        Scanner sc = new Scanner(System.in);
        nV = sc.nextInt();    // 정점
        nE = sc.nextInt();    // 간선

        // 입력받은 정점의 개수로 그래프 초기화
        DfsGraph dfsGraph = new DfsGraph(nV);

        // 그래프에 정점과 간선 입력
        // 입력받은 간선의 개수만큼 반복
        // ex) 정점 8, 간선 10
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
