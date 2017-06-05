/**
 * 
 * @author Guilherme Wenger
 *
 */
public class MergeSort {
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
			
			if(!adicionado){
				v[i] = n;
				
			}
		}

		System.out.println("Arranjo original");
		System.out.print(escreverArranjo(v));
		int[] aux = new int[v.length];
		int[] a = ordenar(v, aux, 0, v.length - 1);
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

	private static int[] ordenar(int[] a, int[] aux, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			ordenar(a, aux, inicio, meio);
			ordenar(a, aux, meio + 1, fim);
			merge(a, aux, inicio, meio + 1, fim);
		}

		return a;
	}

	private static void merge(int[] a, int[] aux, int esq, int dir, int ultimoDireita) {
		int ultimoEsquerda = dir - 1;
		int j = esq;
		int num = ultimoDireita - esq + 1;

		while (esq <= ultimoEsquerda && dir <= ultimoDireita) {
			if (a[esq] < (a[dir])) {
				aux[j++] = a[esq++];
			} else {
				aux[j++] = a[dir++];
			}
		}
		while (esq <= ultimoEsquerda) { 
			aux[j++] = a[esq++];
		}
		while (dir <= ultimoDireita) { 
			aux[j++] = a[dir++];
		}
		
		for (int i = 0; i < num; i++, ultimoDireita--) {
			a[ultimoDireita] = aux[ultimoDireita];
		}
	}

}
