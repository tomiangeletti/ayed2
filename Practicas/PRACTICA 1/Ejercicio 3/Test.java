package tp1.ejercicio3;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Estudiante> estudiantes = new ArrayList<>();
		List<Profesor> profesores = new ArrayList<>();
		
		Estudiante estudiante1 = new Estudiante("Tomas", "Angeletti", "hola", "hola2", "hola3");
		Estudiante estudiante2 = new Estudiante("Elias", "Sosa", "hola", "hola2", "hola3");
		Profesor profesor1 = new Profesor("Valen", "Navarro", "", "", "");
		Profesor profesor2 = new Profesor("Manu", "Senofonte", "", "", "");
		Profesor profesor3 = new Profesor("Donato", "Navarro", "", "", "");
		
		estudiantes.add(estudiante1);
		estudiantes.add(estudiante2);
		profesores.add(profesor1);
		profesores.add(profesor2);
		profesores.add(profesor3);
		
		System.out.println("ALUMNOS");
		System.out.println("======================================");
		for (int i = 0; i < estudiantes.size(); i++){
			estudiantes.get(i).tusDatos();
		}
		System.out.println("PROFESORES");
		System.out.println("======================================");
		for (int i = 0; i < profesores.size(); i++){
			profesores.get(i).tusDatos();
		}
		
	}

}