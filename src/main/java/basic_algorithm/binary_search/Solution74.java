package basic_algorithm.binary_search;

/**
 * @Classname Solution74
 * @Description TODO
 * @Date 2020/12/8 16:20
 * @Created by laohuang
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        if (matrix == null || matrix.length == 0||matrix[0].length==0){
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int startX=0,endX=m-1;
        int startY=0,endY = n-1;

        if(target<matrix[0][0]){
            return result;
        }

        if(target>matrix[endX][endY]){
            return result;
        }

        while(startX+1<endX){
            int midX = startX+(endX-startX)/2;
            if(target==matrix[midX][0]){
                return true;
            }
            if(target>matrix[midX][0]){
                startX = midX;
            }else{
                endX = midX;
            }
        }

        if(target==matrix[startX][0]||target==matrix[endX][0]){
            return true;
        }

        int resultX=0;
        if(target>=matrix[endX][0]){
            resultX = endX;
        }else{
            resultX = startX;
        }

        while(startY<=endY){
            int midY = startY+(endY-startY)/2;
            if(target==matrix[resultX][midY]){
                return true;
            }
            if(target>=matrix[resultX][midY]){
                startY = midY+1;
            }else{
                endY = midY-1;
            }

        }

        return result;

    }

}
