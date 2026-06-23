import java.util.*;
public class WarehouseStore {
	public static int findMax(int[] stock) {
		if (stock == null || stock.length == 0) throw new IllegalArgumentException("stock is empty");
		int max = stock[0];
		for (int v : stock) if (v > max) max = v;
		return max;
	}
	public static int findMin(int[] stock) {
		if (stock == null || stock.length == 0) throw new IllegalArgumentException("stock is empty");
		int min = stock[0];
		for (int v : stock) if (v < min) min = v;
		return min;
	}
	public static long totalStock(int[] stock) {
		if (stock == null) return 0;
		long sum = 0;
		for (int v : stock) sum += v;
		return sum;
	}
	public static List<Integer> findDuplicates(int[] stock) {
		List<Integer> dups = new ArrayList<>();
		if (stock == null) return dups;
		Map<Integer,Integer> counts = new HashMap<>();
		for (int v : stock) counts.put(v, counts.getOrDefault(v,0)+1);
		for (Map.Entry<Integer,Integer> e : counts.entrySet()) if (e.getValue() > 1) dups.add(e.getKey());
		return dups;
	}
	public static int[] rotateRight(int[] stock, int k) {
		if (stock == null) return null;
		int n = stock.length;
		if (n == 0) return new int[0];
		k = ((k % n) + n) % n;
		if (k == 0) return Arrays.copyOf(stock, n);
		int[] res = new int[n];
		System.arraycopy(stock, n - k, res, 0, k);
		System.arraycopy(stock, 0, res, k, n - k);
		return res;
	}
	public static int[][] transpose(int[][] grid) {
		if (grid == null || grid.length == 0) return new int[0][];
		int rows = grid.length;
		int cols = grid[0].length;
		for (int[] row : grid) if (row.length != cols) throw new IllegalArgumentException("ragged matrix");
		int[][] t = new int[cols][rows];
		for (int r = 0; r < rows; r++) for (int c = 0; c < cols; c++) t[c][r] = grid[r][c];
		return t;
	}

	private static void printArray(int[] a) {
		System.out.println(Arrays.toString(a));
	}

	private static void printMatrixSample(int[][] m, int rowsToShow, int colsToShow) {
		for (int i = 0; i < Math.min(rowsToShow, m.length); i++) {
			System.out.println(Arrays.toString(Arrays.copyOf(m[i], Math.min(colsToShow, m[i].length))));
		}
	}

	public static void main(String[] args) {
		int[] stock = {12, 5, 7, 12, 0, 34, 5, 18, 34, 2};

		System.out.println("Stock: " + Arrays.toString(stock));
		System.out.println("Max: " + findMax(stock));
		System.out.println("Min: " + findMin(stock));
		System.out.println("Total stock: " + totalStock(stock));
		System.out.println("Duplicates: " + findDuplicates(stock));

		int k = 3;
		int[] rotated = rotateRight(stock, k);
		System.out.println("Rotated right by " + k + ": ");
		printArray(rotated);

		int size = 20;
		int[][] grid = new int[size][size];
		for (int r = 0; r < size; r++) for (int c = 0; c < size; c++) grid[r][c] = r * size + c + 1;

		System.out.println("Original 20x20 grid (first 5 rows):");
		printMatrixSample(grid, 5, 8);
        
		int[][] t = transpose(grid);
		System.out.println("Transposed grid (first 5 rows):");
		printMatrixSample(t, 5, 8);
	}
}
