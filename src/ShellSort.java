/**
 * 
 * @author Guilherme Wenger
 *
 */
public class ShellSort {
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

	public static int[] ordenar(int[] v) {
		int h = 1;
		int n = v.length;

		while (h < n) {
			h = h * 3 + 1;
		}

		h = h / 3;
		int c, j;

		while (h > 0) {
			for (int i = h; i < n; i++) {
				c = v[i];
				j = i;
				while (j >= h && v[j - h] > c) {
					v[j] = v[j - h];
					j = j - h;
				}
				v[j] = c;
			}
			h = h / 2;
		}

		return v;
	}
}
