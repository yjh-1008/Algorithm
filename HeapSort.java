import java.util.*;
class LinkedList{
    private static int getParent(int child){
        return (child-1)/2;
    }

    private static void swap(int[] a, int i, int j ){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static void heapSort(int[] arr){
        int size=arr.length;
        //길이가 2보다 작은 경우는 정렬을 할 필요가 없다.
        if(size<2){
            return;
        }
        //가장 마지막 노드의 부모 인덱스
        int parentIdx=getParent(size-1);
        //max heap만들기

        for(int i=parentIdx;i>=0;i--){
            heapify(arr,i,size-1);
        }

        //정렬 과정
        for(int i=size-1;i>0;i--){
            swap(arr,0,i);
            heapify(arr,0,i-1);
        }
    }

    private static void heapify(int[] a, int parentIdx, int lastIdx){
        int leftChildIdx= (2*parentIdx)+1;
        int rightChildIdx=(2*parentIdx)+2;
        int largesIdx=parentIdx;

        //leftChild와 latgeIdx비교(완전이진트리이기 때문에 왼쪽부터 비교한다.)
        if(leftChildIdx <= lastIdx && a[leftChildIdx]>a[largesIdx]){
            largesIdx=leftChildIdx;
        }
        //rightChild와 largeIdx비교
        if(rightChildIdx <= lastIdx && a[rightChildIdx]>a[largesIdx]){
            largesIdx=rightChildIdx;
        }
        //부모idx와 가장 큰idx가 다르다면 변경한다
        if(parentIdx!=largesIdx){
            swap(a,largesIdx,parentIdx);
            heapify(a, largesIdx, lastIdx);
        }
    }

    static public void main(String[] args){
        int[] arr={9,7,5,4,2,8};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}