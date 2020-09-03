import java.util.Arrays;
import java.util.Random;
/*
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
*/
public class Percolation {
	private static int[][] grid;
	private static int dimension;
    /**
     * 
     * creates n-by-n grid, with all sites initially blocked
     * 
     * @param n
     */
    public Percolation(int n) {
    	dimension = n;
    	grid = new int[n][n];
    	Arrays.fill(grid, 0);
    }

    /**
     * 
     * opens the site (row, col) if it is not open already
     * 
     * @param row
     * @param col
     * @throws Exception 
     */
    public static void open(int row, int col) throws Exception {
    	isValid(row, col);
    	grid[row][col] = 1;
    }

    /**
     * 
     * is the site (row, col) open?
     * 
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
    	if(grid[row][col] == 1)
    			return true;
    	return false;
    }

    /**
     * 
     * is the site (row, col) full?
     * 
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col) {
    	if(grid[row][col] == 0)
			return true;
    	return false;
    }

    /**
     * 
     * returns the number of open sites
     * 
     * @return
     */
    public int numberOfOpenSites() {
    	return 0;

    }

    /**
     * 
     * does the system percolate?
     * 
     * @return
     */
    public static boolean percolates() {
    	return false;

    }
    
    public static void isValid(int i, int j) throws Exception {
    	if (i < 0 || i >= dimension || j < 0 || j >= dimension)
    		throw new IllegalArgumentException("index out of ragne!");
    }

	/**
	 * 
	 * test client (optional)
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
    	Random rand = new Random();
    	int Upperbound = dimension;
    	do {
    		int row = rand.nextInt(Upperbound);
    		int col = rand.nextInt(Upperbound);
    		try {
				open(row, col);
			} catch (Exception e) {
				e.printStackTrace();
			}  		
    	} while(!percolates());
    	
    }
}