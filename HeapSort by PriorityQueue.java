import java.util.*;
class LinkedList{
    static public void main(String[] args){
        int[] arr={3,7,5,4,2,8};
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
        //배열을 힙으로 변경
        for(int i=0;i<arr.length;i++){
            heap.add(arr[i]);
        }
        //힙에서 우선순위가 가장 높은 원소를 하나씩 뽑는다
        for(int i=0;i<arr.length;i++){
            arr[i]=heap.poll();
        }
        for(int val:arr){
            System.out.print(val+" ");
        }
    }
}