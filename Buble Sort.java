package sample;


import java.util.HashMap;
import java.util.LinkedList;
public class Main{
    static public void main(String[] args){
        // 버블정렬 : 구현은 용이하나 다른 정렬에 비해 가장 나쁜 시간복잡도 O(n^2)를 가진다.
        //등차수열
        //버블정렬은 바로 옆에 있는 값과 계속 반복비교를 하기 때문에 선택정렬과 같은 시간복잡도를 가지고 있지만 더 느리다.
        int[] arr={1,10,5,8,7,6,4,3,2,9};
        int temp;
        for(int i=1;i<=arr.length;i++){
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
