/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      s.addStudent(new Student("Krzysztof","Adam", 20, "Kowaliowa"));
      s.addStudent(new Student("Janusz","Mari", 40,"Marszalke"));

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
        System.out.println("Podaj ulice, na ktorej mieszka studenta:");
        String street = scanner.nextLine();
         

        s.addStudent(new Student(name, surname,age , street));
      }

      System.out.println("Czy chcesz wyświetlić listę studentów? (tak/nie)");
      input = scanner.nextLine();

      if (input.equalsIgnoreCase("tak")) 
      {
        var students = s.getStudents();
        for(Student current : students) 
        {
          System.out.println(current.ToString());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

