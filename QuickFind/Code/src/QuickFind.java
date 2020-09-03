/*
 *  Quick-Find Algorithm with the complexity of 1 for Connect and N for Union 
 *  Worst-case time: M * N (M union-find operations on a set of N objects)
 */
public class QuickFind {
	
	public static void main (String[] args) {
		
	}
	
}

class QuickFindUF {
	private int[] id;
	
 	public QuickFindUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
 	
 	public boolean connected(int p, int q) {
 		return id[p] == id[q];
 	}
 	
 	public void union(int p, int q) {
 		int pid = id[p];
 		int qid = id[q];
 		for (int i = 0; i < id.length; i++)
 			if (id[i] == pid)
 				id[i] = qid;
 	}
}

/*
 *  Quick-Union Algorithm with the complexity of N for Connect and N for Union
 *  Worst-case time: M * N (M union-find operations on a set of N objects)
 */
class QuickUnionUF {
	private int[] id;
	
	public QuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	public boolean connected(int p, int q) {
			return root(p) == root(q);
	}
	
	private int root (int i) {
		while (i != id[i]) 
			i = root(id[i]);
		return i;		
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		id[i] = j;
	}

}

/*
 *  Weighted Quick-Union Algorithm with the complexity of log N for Connect and log N for Union 
 *  Worst-case time: N + M * log N (M union-find operations on a set of N objects)
 */
class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	
	public WeightedQuickUnionUF(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public boolean connected(int p, int q) {
			return root(p) == root(q);
	}
	
	private int root (int i) {
		while (i != id[i]) 
			i = id[i]; //or i = root(id[i])
		return i;
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		if (i == j) return;
		
		if(sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}
		else {
			id[j] = i;
			sz[i] += sz[j];			
		}
	}

}
/*
 *  Path Compression Algorithm with the complexity of log N for Connect and log N for Union
 *  Worst-case time: N + M log* N (M union-find operations on a set of N objects) 
 */
class PathCompressionWeightedUF {
	private int[] id;
	private int[] sz;
	
	public PathCompressionWeightedUF(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	/**
	 * Return true if elements {@code p} and {@code q} have the same roots
	 * 
	 * @param p an element
	 * @param q an element
	 * @return true if elements {@code p} and {@code q} have the same roots
	 */
	public boolean connected(int p, int q) {
			return root(p) == root(q);
	}
	
	/**
	 * Returns the canonical element of the set containing element {@code i}.
	 * 
	 * @param i an element
	 * @return the canonical element of the set containing {@code i}
	 */
	private int root (int i) {
		while (i != id[i]) {
			//id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	/**
	 * Merges the set containing element {@code p} with the 
	 * the set containing element {@code q}.
	 * 
	 * @param  p one element
	 * @param  q the other element
	 */
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		if (i == j) return;
		
		if(sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}
		else {
			id[j] = i;
			sz[i] += sz[j];			
		}
	}
	
	/**
	 * Returns the canonical element of a set containing {@code i}
	 * 
	 * @param i an element
	 * @return the canonical element of a set containing {@code i}
	 */
	public int find(int i) {
		int can_el = i;
		while (i != id[i]) {
			if (id[i] > can_el)
				can_el = id[i];
		}
		return can_el;
	}
}