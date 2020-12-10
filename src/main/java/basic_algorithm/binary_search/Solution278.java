package basic_algorithm.binary_search;

/**
 * @Classname Solution278
 * @Description TODO
 * @Date 2020/12/9 10:24
 * @Created by laohuang
 */
public class Solution278 {
    public int firstBadVersion(int n) {
        int start = 1,end = n;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(isFirstBlack(mid)){
                return mid;
            }
            if(isBadVersion(mid)){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return n;
    }

    private boolean isFirstBlack(int n){
        return isBadVersion(n)&&!isBadVersion(n-1);
    }

    private  boolean isBadVersion(int n){
        return true;
    }

    public int firstBadVersion2(int n) {
        int start = 1,end = n;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(isBadVersion(mid)){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return start;
    }
}
