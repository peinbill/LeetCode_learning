package basic_algorithm.sort;

/**
 * @Classname Solution215
 * @Description TODO
 * @Date 2020/12/16 11:08
 * @Created by laohuang
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        nums = sort(nums);
        // 堆排序
        int n = nums.length;
        while (k > 1) {
            exch(nums, 1, n--);//相当于删除了最大元素
            sink(nums, 1, n);
        }
        return nums[0];
    }

    private int[] sort(int[] pq) {
        int n = pq.length;

        // 构建堆——从右往左
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }

        return pq;
    }


    private void sink(int[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }


    private boolean less(int[] pq, int i, int j) {
        return pq[i - 1] < (pq[j - 1]);
    }

    private void exch(int[] pq, int i, int j) {
        int swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }




    public static void main(String[] args){
        Solution215 solution215 = new Solution215();
        solution215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);
    }
}
