class Solution {
    int maxarea = 0;
    public int maximalRectangle(char[][] mat) {

        int[][] matrix = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                matrix[i][j] = mat[i][j] - '0';
            }
        }

        for(int row = 0; row < matrix.length; row++){
            if(row != 0){
                for(int col = 0; col < matrix[0].length; col++){
                    if(matrix[row][col] != 0) matrix[row][col] += matrix[row - 1][col];
                }
            }
            maxarea = Math.max(maxarea , histogram(matrix, row));
        }
        return maxarea;
    }

    public int histogram(int[][] matrix, int row){
        int[] arr = new int[matrix[0].length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = matrix[row][i];
        }

        Stack<Integer> stack = new Stack<>();
        int areamax = 0;
        for(int i = 0; i <= arr.length; i++){
            int h = i == arr.length ? 0 : arr[i];

            while(!stack.isEmpty() && h < arr[stack.peek()]){
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;

                areamax = Math.max(areamax, area);
            }
            stack.push(i);
        }
        return areamax;
    }
}