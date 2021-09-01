public class QuickSort {
    static int number=8;
    static int[] arr= new int[number];
    static void merge(int[] a, int m, int middle, int n){ //시작점, 중간점 , 끝
        int i=m;
        int j=middle+1;
        int k=m;
        while(i<=middle && j<=n){
            if(a[i]<=a[j]){
                arr[k]=a[i];
                i++;
            }else{
                arr[k]=a[j];
                j++;
            }
            k++;
        }
        if(i> middle){
            for(int t=j;t<=n;t++){
                arr[k]=a[t];
                k++;
            }
        }else{
            for(int t=i;t<=middle;t++){
                arr[k]=a[t];
                k++;
            }
        }
        for(int t=m;t<=n;t++){
            a[t] = arr[t];
        }
    }
    static void mergeSort(int []a, int m, int n){
        if(m<n){ // 최대로 작은 단위까지 나눈다
            int middle=(m+n)/2;
            mergeSort(a, m, middle);
            mergeSort(a, middle+1, n);
            merge(a,m,middle,n);
        }
    }
    static public void main(String[] args){
        int a[]={7,6,2,8,3,5,9,1};
        mergeSort(a,0,a.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(a[i]);
        }
    }
}
