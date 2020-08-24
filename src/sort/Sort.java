package sort;

public class Sort {

    //冒泡排序
    public static void BubbleSort(int[] arr) {

        int n = arr.length;

        for( int i = 0; i < n-1; i++ ){

            for( int j = 0; j < n - i - 1; j++ ){

                if( arr[j+1] < arr[j] ){

                    int tmp;

                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }


    public static void SelectionSort(int[] arr) {

        int n = arr.length;

        for ( int i = 0; i < n; i++){

            int min = i;

            for ( int j = i + 1; j < n; j++){

                if (arr[min] > arr[j]){
                    min = j;
                }
            }

            if (min != i){

                int tmp;
                tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
    }

    //直接插入排序
    public static void InsertionSort(int[] arr) {

        int n = arr.length;

        for ( int i = 1; i < n; i ++){//遍历

            for (int j = i; j > 0; j --){//往前找

                if (arr[j] < arr[j - 1]){//若游标值比前一个值小，需要移动
                    //交换操作
                    int tmp;
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }else{
                    break;
                }
            }
        }
    }






    public static void QuickSort(int[] array,int low ,int high){

        if(low>=high){

            return ;
        }

        int index=partition(array,low,high);

        QuickSort(array,low,index-1);
        QuickSort(array,index+1,high);
    }

    public static int partition(int []array,int low,int high){

        int mid = low + (high - low)/2;

        if( array[mid] > array[high] ){

            swap(array[mid],array[high]);
        }

        if( array[low] > array[high] ){
            swap(array[low],array[high]);
        }

        if( array[mid] > array[low] ){
            swap(array[mid],array[low]);
        }

        int key = array[low];

        while(low < high){

            while( array[high] >= key && high > low ){
                high--;
            }

            array[low] = array[high];

            while( array[low] <= key && high > low ){
                low++;
            }

            array[high] = array[low];
        }

        array[high] = key;

        return high;
    }

    public static void swap(int a,int b){

        int temp=a;
        a = b;
        b = temp;
    }


}
