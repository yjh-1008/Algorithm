import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeapSort {
    static public void bfs_array(int start,int[][] bfsArray, boolean[] isVisited){
        Queue<Integer> q=new LinkedList<>();
        int n=bfsArray.length-1;
        isVisited[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            start=q.poll();
            System.out.print(start+"  ");
            for(int i=1;i<=bfsArray.length-1;i++){
                if(bfsArray[start][i]==1 && !isVisited[i]){
                    q.add(i);
                    isVisited[i]=true;
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
        int[][] bfsArray=new int[nV+1][nV+1];
        for(int i=0;i<nE;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            //방향이 없는 경우

            bfsArray[v1][v2]=1;
            bfsArray[v2][v1]=1;
        }
        bfs_array(start,bfsArray,isVisited);
    }
}
