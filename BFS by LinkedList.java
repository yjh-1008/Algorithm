import java.util.*;

public class HeapSort {
    static public void bfs_array(int start,LinkedList<Integer>[] bfsList, boolean[] isVisited){
        Queue<Integer> q=new LinkedList<>();
        isVisited[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            start=q.poll();
            System.out.print(start+"  ");
            Iterator<Integer> iter=bfsList[start].listIterator();
            while(iter.hasNext()){
                int w=iter.next();
                if(!isVisited[w]){
                    isVisited[w]=true;
                    q.add(w);
                }
            }
        }
    }

    static public void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int nV=sc.nextInt();//정점의 개수
        int nE=sc.nextInt();//간선의 개수
        int start =sc.nextInt();//탐색을 시작할 정점의 번호
        boolean isVisited[]= new boolean[nV+1];
        LinkedList<Integer>[] bfsList=new LinkedList[nV+1];
        for(int i=0;i<=nV;i++){
            bfsList[i]=new LinkedList<Integer>();
        }
        for(int i=1;i<=nV;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            bfsList[v1].add(v2);
            bfsList[v2].add(v1);
        }
        for(int i=1;i<=nV;i++){
            Collections.sort(bfsList[i]);
        }

        bfs_array(start,bfsList,isVisited);
    }
}
