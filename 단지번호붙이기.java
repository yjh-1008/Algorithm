import java.util.*;

public class HeapSort {
   static int[] toX={-1,0,1,0};
   static int[] toY={0,1,0,-1};
   static int chkXY;
   static int count=0;
   static boolean[][] chk;
   static class XY{
       private int x;
       private int y;
       XY(int x, int y){
           this.x=x;
           this.y=y;
       }
   }
   static public int bfs(int[][] map,XY xy){
       chkXY=1;
       Queue<XY> q=new LinkedList<>();
       q.add(xy);
       XY temp;
       chk[xy.x][xy.y]=true;
       while(!q.isEmpty()){
           temp=q.poll();
           for(int i=0;i<toX.length;i++){
               if(temp.x+toX[i]>=0 && temp.y+toY[i]>=0 &&  temp.x+toX[i]<map.length && temp.y+toY[i]<map.length){
                   if(!chk[temp.x+toX[i]][temp.y+toY[i]] && map[temp.x+toX[i]][temp.y+toY[i]]==1){
                       int x=temp.x+toX[i];
                       int y=temp.y+toY[i];
                       q.add(new XY(x,y));
                       chk[x][y]=true;
                       chkXY++;
                   }
               }
           }
       }
       return chkXY;
   }

    static public void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int N=sc.nextInt();
        int[][] map=new int[N][N];
        chk= new boolean[N][N];
        LinkedList<Integer> arr= new LinkedList<>();
        for(int i=0; i<N; i++){
            String input = sc.next();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                if(map[i][j]==1 && !chk[i][j]){
                    arr.add(bfs(map,new XY(i,j)));
                    count++;
                }
            }
        }
        Collections.sort(arr);
        sb.append(count+"\n");
        for(int i=0;i<arr.size();i++){
            sb.append(arr.get(i)+"\n");
        }

        System.out.println(sb.toString());
    }
}
