package basic_algorithm.sort;

/**
 * @Classname SolutionQ
 * @Description 快排
 * @Date 2020/12/10 10:39
 * @Created by laohuang
 */
public class SolutionQ {
    public int[] quickSort(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if(start<end){
            int partition = partition(nums,start,end);
            quickSort(nums,start,partition-1);
            quickSort(nums,partition+1,end);
        }
    }


    // 这里是用算法第四版里面的核心算法
    private  int partition(int[] a,int lo,int hi){
        int i = lo,j=hi+1;
        int v = a[lo];
        while (true){
            // 左往右扫描
            while (less(a[++i],v)){
                if(i==hi){
                    break;
                }
            }

            // 右往左扫描
            while (less(v,a[--j])){
                if(j==lo){
                    break;
                }
            }

            if(i>=j){
                break;
            }

            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public  boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

}
