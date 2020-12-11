package basic_algorithm.sort;

/**
 * @Classname SolutionM
 * @Description 归并排序
 * @Date 2020/12/10 11:05
 * @Created by laohuang
 */
public class SolutionM {

    int[] aux;

    public int[] mergeSortRoot(int[] nums) {
        aux = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int hi, int lo) {
        if(hi<=lo){
            return;
        }
        int mid = lo+(hi-lo)/2;
        mergeSort(nums,lo,mid);
        mergeSort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }

    // 核心代码
    private void merge(int[] nums, int l, int mid, int r) {
        int i=l,j=mid+1;
        // 构建一模一样的数组
        for(int k= l;k<=mid;k++){
            aux[k]=nums[k];
        }

        for(int k=l;k<=r;k++){
            if(i>mid){
                // 此时左边的已经全部排完了
                nums[k] = aux[j++];
            }else if(j>r){
                // 此时右边的已经全部排完了
                nums[k] = aux[i++];
            }else if(less(aux[j],aux[i])){
                nums[k] = aux[j++];
            }else {
                nums[k] = aux[i++];
            }
        }
    }

    private   boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
}
