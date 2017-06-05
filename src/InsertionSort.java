/**
 * 
 * @author Guilherme Wenger
 *
 */
public class InsertionSort {
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
		for (int i = 0; i < v.length; i++) {//percorre o arranjo
			int a = v[i]; //salva o valor armazenado na posicao atual do arranjo
			//percorre o arranjo verificando se o valor aramazenado na posicao atual do arranjo
			// é maior que o valor armazenado em na posicao anterior, caso sim, faz a troca
			for (int j = i - 1; j >= 0 && v[j] > a; j--) {  
				v[j + 1] = v[j];							
				v[j] = a;      
			}
		}
		return v;
	}
}
