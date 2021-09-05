package sample;


import java.util.HashMap;
import java.util.LinkedList;
public class Main{


    static public void main(String[] args){
        //선택 정렬:  가장 작은 값이나 큰 값을 맨 앞으로 보내면서 진행한다.
        int[] arr={1,10,5,8,7,6,4,3,2,9};
        int temp;

        //단점 시간 복잡도가 나쁜 경우 O(n^2)를 갖는다. (비효율적이다.)
        for(int i=0;i<arr.length;i++){
            int min= Integer.MAX_VALUE;
            int idx=Integer.MAX_VALUE;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    idx=j;
                }
            }
            temp=arr[i];
            arr[idx]=arr[i];
            arr[i]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
