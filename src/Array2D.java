public class Array2D {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println("searchMatrix: "+searchMatrix(matrix,11));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[i].length;j++){
        //        if(matrix[i][j]==target)
        //             return true;
        //     }
        // }
//        for(int i=1;i<matrix.length;i++){
//            if(matrix[i][0]>target){
//                i=i-1;
//                for(int j=0;j<matrix[i].length;j++){
//                    if(matrix[i][j]==target)
//                        return true;
//                }
//            }
//        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
