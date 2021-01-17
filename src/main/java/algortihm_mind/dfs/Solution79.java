package algortihm_mind.dfs;

/**
 * @Classname Solution79
 * @Description TODO
 * @Date 2021/1/17 10:59
 * @Created by laohuang
 */
public class Solution79 {
    int m;
    int n;
    boolean[][] marked;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        marked=new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(dfs(board,word,i,j)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board,String word ,int i,int j){
        if(i>=m||j>=n||j<0||i<0||!marked[i][j]){
            return false;
        }

        if(word.length()==0){
            return true;
        }

        if(board[i][j]==word.charAt(0)){
            marked[i][j]=true;
            if(word.length()>1){
                word = word.substring(1);
            }else {
                return true;
            }
            boolean result= dfs(board,word,i+1,j)||dfs(board,word,i-1,j)||dfs(board,word,i,j+1)||dfs(board,word,i,j-1);
            marked[i][j]=false;
            return result;
        }

        return false;
    }
}
