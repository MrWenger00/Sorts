/**
 * 
 * @author Guilherme Wenger
 *
 */
public class CountingSort {
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
		int maior = buscarMaior(v) + 1;
		int[] a = ordenar(v, maior);
		System.out.println();
		System.out.println("Arranjo ordenado");
		System.out.print(escreverArranjo(a));

	}

	public static int[] ordenar(int[] v, int m) {

		int n = v.length; // recupera o tamanho do arranjo

		int arranjoAuxiliar[] = new int[m]; // cria um arranjo auxiliar com
											// tamanho do maior valor do arranjo
											// +1
		// percorre o arranjo auxiliar preenchendo todas as posições com 0
		for (int i = 0; i < m; i++) {
			arranjoAuxiliar[i] = 0;
		}
		// conta as ocorrencias. A Cada nova ocorrencia de um valor e v[i], seu
		// indice correspondente em arranjoAuxiliar é incrementado
		for (int i = 0; i < n; i++) {
			arranjoAuxiliar[v[i]]++;
		}
		// ordena os indices do arranjo auxiliar
		int sum = 0;
		for (int i = 1; i < m; i++) {
			int dum = arranjoAuxiliar[i];
			arranjoAuxiliar[i] = sum;
			sum += dum;
		}

		int arranjoOrdenado[] = new int[n];
		for (int i = 0; i < n; i++) {
			arranjoOrdenado[arranjoAuxiliar[v[i]]] = v[i];
			arranjoAuxiliar[v[i]]++;
		}
		// retorna os valores ordenados para o arranjo original
		for (int i = 0; i < n; i++) {
			v[i] = arranjoOrdenado[i];
		}

		return v;
	}

	public static String escreverArranjo(int[] v) {
		String a = "";
		for (int i = 0; i < v.length; i++) {
			a += v[i] + ",";
		}
		a = a.substring(0, a.length() - 1);

		return a;
	}

	public static int buscarMaior(int[] v) {
		int maior = v[0];

		for (int i = 0; i < v.length; i++) {
			if (maior < v[i]) {
				maior = v[i];
			}
		}

		return maior;
	}
}
