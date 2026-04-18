// Lab 01
// Assignment 6.6

public class AddTwoMatrices {
    public static void main(String[] args) {
        int n = 4;
        int m = 5;

        int[][] mat1 = {{ 3, -2,  9, 10,  4},
                        {-5,  3, -5,  8, -4},
                        {-6, -1, 12,  3, -1},
                        { 5, 11,  3, -7, 10}
        };
        int[][] mat2 = {{-1,  9, -3,  1,  2},
                        { 7,  9, -9,  5,  5},
                        {10, -9, -8, -2,  6},
                        { 1, -1,  1, -1,  1}
        };

        int[][] mat3 = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                mat3[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(mat3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
