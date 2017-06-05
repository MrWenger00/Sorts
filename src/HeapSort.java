/**
 * 
 * @author Guilherme Wenger
 *
 */

public class HeapSort {
	public static void main(String[] args) {
		int[] v = new int[10];
		boolean adicionado = false;

		for (int i = 0; i < v.length; i++) {
			adicionado = false;
			int n = (int) (Math.random() * 100);
			for (int j = 0; j < i; j++) {
				if (n == v[j]) {
					adicionado = true;
					i--;
				}
			}

			if (!adicionado) {
				v[i] = n;

			}
		}

		System.out.println("Arranjo original");
		System.out.print(escreverArranjo(v));
		int[] a = ordenar(v);
		System.out.println();
		System.out.println("Arranjo ordenado");
		System.out.print(escreverArranjo(a));
	}

	public static String escreverArranjo(int[] v) {
		String a = "";
		for (int i = 0; i < v.length; i++) {
			a += v[i] + ",";
		}
		a = a.substring(0, a.length() - 1);

		return a;
	}

	public static int[] ordenar(int a[]) {
		int n = a.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(a, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;

			// call max heapify on the reduced heap
			heapify(a, i, 0);
		}

		return a;
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	public static void heapify(int a[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && a[l] > a[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && a[r] > a[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = a[i];
			a[i] = a[largest];
			a[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(a, n, largest);
		}
	}
}
