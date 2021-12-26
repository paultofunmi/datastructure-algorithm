package codesignal;

public class RotateImage {
    
    static int[][] rotateImage(int[][] a) {
    
        final int SIZE = a.length;

        for(int i = 0; i < SIZE; i++){
            
            for(int j = i; j < SIZE; j++) {

                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        for(int i = 0; i < SIZE; i++){
            
            for(int j = 0; j < (SIZE /2); j++) {

                int temp = a[i][j];
                a[i][j] = a[i][SIZE-1-j];
                a[i][SIZE - 1 - j] = temp;
            }
        }

        return a;
    }

    
    public static void main(String[] args) {
        
        final int[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}   
        };

        // final int[][] a = {
        //     {1, 4, 7}, // 0,0 -> <- 0, (3- 1 - 0 = 2) // a[0][3-1-0] = temp = a[0][0] 
        //     {2, 5, 8},
        //     {3, 6, 9}  // a[2][0] = a[2][3-1-0=2] // a[2][3-1-0] = 
        // };

        RotateImage.rotateImage(a);

        final int[][] a2 = {
            {1, 2, 3,4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},   
        };
        
        RotateImage.rotateImage(a2);
    }
}