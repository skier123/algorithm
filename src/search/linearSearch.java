package search;

import java.util.Arrays;

public class linearSearch {

    //二分查找，低、高游标逼近
    public static int binary_search( int[] array, int target){

        if (array.length == 0){
            return -1;
        }

        int low = 0;
        int high = array.length - 1;

        while ( low <= high ) {//在没遍历完全时

            int middle = (high - low) / 2 + low;//找到中间

            if (array[middle] == target) {

                return middle;

            }else if ( array[middle] > target){//大了

                high = middle - 1;

            }else {

                low = middle + 1;
            }
        }

        return -1;
    }
//插值查找
    public static int inserctValueSearch(int[] arr,int left,int right,int findValue) {
        if(left>right||findValue>arr[arr.length-1]||findValue<arr[0]) {
            return -1;
        }
        int mid = left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
        if(findValue>arr[mid]) {
            return inserctValueSearch(arr, mid+1, right, findValue);
        }
        if(findValue<arr[mid]) {
            return inserctValueSearch(arr, left, mid-1, findValue);
        }
        else {
            return mid;
        }
    }


    //斐波那契查找，先构建斐波纳切数组
    public static int[] fib(int MaxSize){
        int[] f = new int[MaxSize];
        f[0] = 1; f[1] = 1;
        for(int i = 2;i<MaxSize;i++) {
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }
    public static int fibSearch(int[] a,int key) {
        int low = 0;
        int high = a.length-1;
        int k = 0;
        int mid = 0;
        //初始化斐波那契数组
        int f[] = fib(20);
        //找到恰当的查找数组长度（和斐波那契对齐）
        while(high>f[k]-1) {
            k++;
        }
        //因为f[k]大于数组的长度，因此需要使用一个array类构造一个新的数组并指向a
        //不足的部分会使用零填充
        int[] temp= Arrays.copyOf(a, f[k]);
        //对新的数组temp中的零用a[high]填充
        for(int i = high+1;i<temp.length;i++) {
            temp[i] = a[high];
        }
        while(low<=high) {
            mid = low + f[k-1]-1;
            if(key<temp[mid]) {//向数组的左边查找
                high = mid - 1;
                //再次循环时mid = f[k-1-1]-1
                k--;
            }
            else if(key>temp[mid]) {
                low = mid +1;
                //再次循环时mid = f[k-2-1]-1
                k=k-2;
            }
            else {
                if(mid<high)
                    return mid;
                else
                    return high;
            }
        }
        return -1;
    }



}
