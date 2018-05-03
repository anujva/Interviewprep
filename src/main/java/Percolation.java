import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int length;
    private boolean[][] sites;
    private WeightedQuickUnionUF grid;
    private WeightedQuickUnionUF grid2;
    private int numberOfOpenSites;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The value for n has to be positive");
        }
        length = n;
        grid = new WeightedQuickUnionUF(n * n + 2);
        grid2 = new WeightedQuickUnionUF(n * n + 1);
        sites = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sites[i][j] = false;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            //connect all the top row sites to the source.
            grid.union(0, i); //all the top sites are now connected to the source.
            grid2.union(0, i);
        }
        numberOfOpenSites = 0;
    }// create n-by-n grid, with all sites blocked

    public static void main(String[] args) {
        boolean success = false;
        success = test1();
        success = success && test2();
        System.out.println(success);
    }

    private static boolean test1() {
        Percolation percolation = new Percolation(3);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (percolation.isOpen(i, j) == true) {
                    System.out.println("This statement should not be printed");
                }
            }
        }

        percolation.open(1, 1);
        if (percolation.isOpen(1, 1)) {
            System.out.println("This site should be open");
        }

        percolation.open(2, 1);
        //percolation.open(3, 1);
        System.out.println(percolation.percolates());
        return true;
    }

    private static boolean test2() {
        Percolation percolation = new Percolation(1);
        System.out.println(percolation.percolates());
        percolation.open(1, 1);
        System.out.println(percolation.percolates());
        return true;
    }

    public void open(int row, int col) {
        if (row <= 0 || col <= 0 || row > length || col > length) {
            throw new IndexOutOfBoundsException("Row or column index is out of bounds");
        }
        row = row - 1;
        col = col - 1;
        if (sites[row][col]) {
            return;
        }
        sites[row][col] = true;
        numberOfOpenSites++;
        if (row - 1 >= 0 && sites[row - 1][col]) {
            grid.union(length * (row - 1) + col + 1, length * row + col + 1);
            grid2.union(length * (row - 1) + col + 1, length * row + col + 1);
        }
        if (row + 1 < length && sites[row + 1][col]) {
            grid.union(length * (row + 1) + col + 1, length * row + col + 1);
            grid2.union(length * (row + 1) + col + 1, length * row + col + 1);
        }
        if (col - 1 >= 0 && sites[row][col - 1]) {
            grid.union(length * (row) + col, length * row + col + 1);
            grid2.union(length * (row) + col, length * row + col + 1);
        }
        if (col + 1 < length && sites[row][col + 1]) {
            grid.union(length * row + col + 2, length * row + col + 1);
            grid2.union(length * row + col + 2, length * row + col + 1);
        }

        //One last thing to do is to check if the row is the last one.
        if (row == length - 1) {
            //we just opened a site on the last row. Connect it to the last grid.
            grid.union(length * row + col + 1, length * length + 1);
        }
    }// open site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        if (row <= 0 || col <= 0 || row > length || col > length) {
            throw new IndexOutOfBoundsException("Row or column index is out of bounds");
        }
        return sites[row - 1][col - 1];
    } // is site (row, col) open?

    public boolean isFull(int row, int col) {
        if (row <= 0 || col <= 0 || row > length || col > length) {
            throw new IndexOutOfBoundsException("Row or column index is out of bounds");
        }
        return sites[row - 1][col - 1] && grid2.connected(0, length * (row - 1) + col);
    } // is site (row, col) full?

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    } // number of open sites

    public boolean percolates() {
        return grid.connected(0, length * length + 1);
    } // does the system percolate?
}
