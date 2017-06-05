/**
 * 
 * @author Guilherme Wenger
 *
 */

public class SelectionSort {
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

	public static int[] ordenar(int v[]) {
		int i, j, min, aux;
		for (i = 0; i < (v.length - 1); i++) {
			min = i;
			for (j = (i + 1); j < v.length; j++) {
				if (v[j] < v[min])
					min = j;
			}
			if (i != min) {
				aux = v[i];
				v[i] = v[min];
				v[min] = aux;
			}
		}
		return v;
	}
}
