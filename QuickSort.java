public class QuickSort {
    static int[] arr= {1,3,4,7,8,2,10,9,5,6};
    static void quickSort(int[] data, int start, int end){
        if(start>=end){
            return;
        }
        int pivot = start;
        int left=start+1;
        int right=end;
        int temp;
        while(left<=right){//겹치는 그 순간 종료
            while(left<=end &&data[pivot]>=data[left]){
                left++;
            }
            while(right>start && data[pivot]<=data[right]) {
                right--;
            }
            if(left>right){ //만약 엇갈렸다면 =left의 모든 값이 피벗보다 작다.
                temp=data[pivot];
                data[pivot]=data[right];
                data[right]=temp;
            }else {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }
        quickSort(data, start,right-1); //오른쪽이 새로운 기준 값이 된다.
        quickSort(data,right+1,end);

    }

    static public void main(String[] args){
        quickSort(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
