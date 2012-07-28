
public class QuickSort {

    public static void sort(int[] array, int left,int right){
        int i,j,key;
        i = left ;
        j = right;

        if(i >=  j) return;
        key = array[i];
        while (i < j){
            // 从右找到第一个比key小的数
            while ( i < j && array[j]>= key)j--; array[i] = array[j];
            // 从左找到一个比key大的数
            while(i < j && array[i] <= key)i++;  array[j] = array[i];
        }
        array[i] = key;

        sort(array,left,i-1);
        sort(array,i+1,right);
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,3,6,9,1,0,10,4};
        sort(a,0,7);
        for (int i : a) {
            System.out.print(i);
            System.out.print("  ");
        }



    }
}
