
public class TestaLacos {
	public static void main(String[] args) {
		int total = 0;
		
		for (int multiplicador = 1; multiplicador < 10; multiplicador++){
			for (int contador = 0; contador < 10; contador++){
				total = multiplicador * contador;
				System.out.print(total);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
