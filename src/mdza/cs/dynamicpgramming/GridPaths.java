package mdza.cs.dynamicpgramming;

/**
 *
 * @author Alberto Mendoza>
 */
public class GridPaths {
    private boolean[][] matrix;
    
    GridPaths(int n) { matrix = new boolean[n][n]; }
    public boolean[][] getMatrix() { return matrix; }
    
    public void setInvalidLocation(int row, int col) { 
        matrix[row][col] = true; 
    }
    
    public int getPaths(int startRow, int startCol) {
        int endRow = matrix.length - 1;
        int endCol = matrix.length - 1;
        
        return getPaths(startRow, startCol, endRow, endCol);
    }
    
    private int getPaths(int startRow, int startCol, 
            int endRow, int endCol) {
 
        if(startRow == endRow && startCol == endCol)
            return 1;
        if(!isValid(startRow, startCol))
            return 0;
            
        int val = getPaths(startRow, startCol + 1) + getPaths(startRow + 1, startCol);
        System.out.println(val);
        return val;
    }
    
    private boolean isValid(int row, int col) {
        int length = matrix.length;
        return (row < length && col < length) && matrix[row][col];
    }
    
    public static GridPaths init() {
        GridPaths grid = new GridPaths(8);
        boolean[][] matrix = grid.getMatrix();
        
        for(int row=0; row<matrix.length; ++row)
            for(int col=0; col< matrix.length; ++col)
                matrix[row][col] = true;
        
        matrix[1][2] = false;
        matrix[1][6] = false;
        matrix[2][4] = false;
        matrix[3][0] = false;
        matrix[3][2] = false;
        matrix[3][5] = false;
        matrix[4][2] = false;
        matrix[5][3] = false;
        matrix[5][4] = false;
        matrix[5][6] = false;
        matrix[6][1] = false;
        matrix[6][5] = false;
        return grid;
    }
    
    public static void Tester() {
        GridPaths grid = init();
        //System.out.printf("Counter: %d\n", grid.getPaths(7, 6));
        //System.out.printf("Counter: %d\n", grid.getPaths(6, 7));
        System.out.printf("Counter: %d\n", grid.getPaths(0, 0));
    }
}
