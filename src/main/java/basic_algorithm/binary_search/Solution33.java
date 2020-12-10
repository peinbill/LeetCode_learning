package basic_algorithm.binary_search;

/**
 * @Classname Solution33
 * @Description TODO
 * @Date 2020/12/9 16:31
 * @Created by laohuang
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        // 对部分有序的进行二分查找（判断条件麻烦一点）
        // 对无序的不进行处理
        int start=0,end = nums.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(nums[mid]==target){
                return mid;
            }
            if(nums[start]==target){
                return start;
            }
            if(nums[end]==target){
                return end;
            }

            // 只分析有序的那一段
            if(nums[start]<nums[mid]){
                // 左边有序
                if(nums[start]<target&&target<nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }

            }else{
                // 右边有序
                if(nums[mid]<target&&target<nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }

            }


        }

        return -1;
    }


    public static void main(String[] args){
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.search(new int[]{3,1},1));
    }
}
