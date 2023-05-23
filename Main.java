import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      s.addStudent(new Student("Krzysztof", "Adam", 20, "Kowaliowa", "1990-05-15"));
      s.addStudent(new Student("Janusz", "Mari", 40, "Marszalke", "1980-10-20"));

      var scanner = new Scanner(System.in);
      System.out.println("Czy chcesz dodać nowego studenta do bazy? (tak/nie)");
      String input = scanner.nextLine();

      if (input.equalsIgnoreCase("tak")) {
        System.out.println("Podaj imię nowego studenta:");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko nowego studenta:");
        String surname = scanner.nextLine();
        System.out.println("Podaj wiek nowego studenta:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj ulicę, na której mieszka student:");
        String street = scanner.nextLine();
        System.out.println("Podaj datę urodzenia studenta (RRRR-MM-DD):");
        String birthDate = scanner.nextLine();

        s.addStudent(new Student(name, surname, age, street, birthDate));
      }

      System.out.println("Czy chcesz wyświetlić listę studentów? (tak/nie)");
      input = scanner.nextLine();

      if (input.equalsIgnoreCase("tak")) {
        var students = s.getStudents();
        for (Student current : students) {
          System.out.println(current.toString());
        }
      }
      findStudentByName(s, scanner);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void findStudentByName(Service service, Scanner scanner) throws IOException {
    System.out.println("Podaj imię studenta, którego chcesz wyszukać:");
    String searchName = scanner.nextLine();

    List<Student> matchingStudents = service.findStudentByName(searchName);
    if (matchingStudents.isEmpty()) {
      System.out.println("Nie znaleziono studentów o podanym imieniu.");
    } else {
      for (Student student : matchingStudents) {
        System.out.println(student.toString());
      }
    }
  }
}
