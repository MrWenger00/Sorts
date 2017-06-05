/**
 * 
 * @author Guilherme Wenger
 *
 */
public class CockTailSort {
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
		int aux;
		//percorre o arranjo original do inicio ao fim, posicionando o maior valor encontrado na ultima casa disponível mais à direita
		for (int i = v.length-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (v[j] > v[j + 1]) {
					aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
				}
			}
			//percorre o arranjo original do inicio ao fim, posicionando o menor valor encontrado na ultima casa disponível mais à esquerda
			for (int k = i; k > 0; k--) {
				if (v[k] < v[k - 1]) {
					aux = v[k];
					v[k] = v[k - 1];
					v[k - 1] = aux;
				}
			}
		}

		return v;

	}
}
