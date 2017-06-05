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

		for (int i = n / 2 - 1; i >= 0; i--){
			heapify(a, n, i);
		}
		for (int i = n - 1; i >= 0; i--) {
			
			int aux = a[0];
			a[0] = a[i];
			a[i] = aux;

			
			heapify(a, i, 0);
		}

		return a;
	}

	
	public static void heapify(int a[], int n, int i) {
		int largura = i; 
		int l = 2 * i + 1; 
		int r = 2 * i + 2; 

		if (l < n && a[l] > a[largura]){
			largura = l;
		}
		if (r < n && a[r] > a[largura]){
			largura = r;
		}
		
		if (largura != i) {
			int aux = a[i];
			a[i] = a[largura];
			a[largura] = aux;

			
			heapify(a, n, largura);
		}
	}
}
