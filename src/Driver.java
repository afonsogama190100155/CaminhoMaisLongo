public class Driver {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                { 'S', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', 'F' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' }
        };

        char[][] grid_2 = new char[][]{
                {'S','.','.'},
                {'.','.','.'},
                {'.','.','F'}
        };

        DjikstraPathFinder finder = new DjikstraPathFinder();
        char[][] solved_grid = finder.solve(grid);
        for(int i = 0; i < solved_grid.length;i++){
            for(int j = 0; j < solved_grid[i].length;j++){
                System.out.print(solved_grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
