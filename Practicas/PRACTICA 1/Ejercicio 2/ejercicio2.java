package tp1.ejercicio2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class ejercicio2 {
	
	public static List<Integer> returnArray(int n) {
		List<Integer> numeros = new ArrayList<>();
		for (int i = 1; i < n + 1; i++) {
			if (i < 1) {
				numeros.add(n);
			}
			else if (i >= 1) {
				numeros.add(n * i);
			}
		}
		return numeros;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese el numero a analizar: ");
		int n = s.nextInt();
		System.out.println(returnArray(n));
		s.close();
	}

}