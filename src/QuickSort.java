/**
 * 
 * @author Guilherme Wenger
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		boolean adicionado = false;
		int[] v = new int[10];

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
		ordenar(v, 0, (v.length-1));
		System.out.println();
		System.out.println("Arranjo ordenado");
		System.out.print(escreverArranjo(v));

	}

	public static String escreverArranjo(int[] v) {
		String a = "";
		for (int i = 0; i < v.length; i++) {
			a += v[i] + ",";
		}
		a = a.substring(0, a.length() - 1);

		return a;
	}

	public static void ordenar(int[] a, int ini, int fim) {
		//verifica se o arranjo é nulo ou se está vazio
		if (a == null || a.length == 0) {
			return;

		}
		
		if (ini >= fim){
			return;
		}

		//encontra a posicao central do arranjo e recupera seu valor
		int meio = ini + (fim - ini) / 2;
		int pivo = a[meio];

		//declara variáveis que vão percorrer o arranjo
		int i = ini;
		int j = fim;
		
		//percorre
		while (i <= j) {
			// posiciao i na posicao 
			while (a[i] < pivo) {
				i++;
			}

			while (a[j] > pivo) {
				j--;
			}

			if (i <= j) {
				int aux = a[i];
				a[i] = a[j];
				a[j] = aux;
				i++;
				j--;
			}
		}

		//faz as chamadas recursivas
		if (ini < j) {
			ordenar(a, ini, j);
		}

		if (fim > i) {
			ordenar(a, i, fim);
		}
	}
}
