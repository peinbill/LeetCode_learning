package basic_algorithm.sort;

/**
 * @Classname SolutionH
 * @Description 堆排序
 * @Date 2020/12/10 11:23
 * @Created by laohuang
 */
public class SolutionH {
//    最大堆得到的是升序
//    1. 构造堆：方法一：从左往右进行swim（相当于连续插入元素） 方法二：从右往左进行sink（省一半）
//    2. 每次使用下沉操作
    public int[]  sort(int[] pq) {
        int n = pq.length;

        // 构建堆——从右往左
        for (int k = n/2; k >= 1; k--){
            sink(pq, k, n);
        }

        // 堆排序
        int k = n;
        while (k > 1) {
            exch(pq, 1, k--);//相当于删除了最大元素
            sink(pq, 1, k);
        }

        return pq;
    }


    private  void sink(int[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)){
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }



    private  boolean less(int[] pq, int i, int j) {
        return pq[i-1]<(pq[j-1]);
    }

    private void exch(int[] pq, int i, int j) {
        int swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

}
