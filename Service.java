import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
  private static final String DATABASE_FILE = "db.txt";

  public void addStudent(Student student) throws IOException {
    String studentData = student.getName() + " " + student.getSurname() + " " + student.getAge() + " " +
        student.getStreet() + " " + student.getBirthDate();
    try (PrintWriter writer = new PrintWriter(new FileWriter(DATABASE_FILE, true))) {
      writer.println(studentData);
    }
  }

  public List<Student> getStudents() throws IOException {
    List<Student> students = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
      String line;
      while ((line = reader.readLine()) != null) {
        Student student = Student.parse(line);
        students.add(student);
      }
    }
    return students;
  }

  public List<Student> findStudentByName(String name) throws IOException {
  List<Student> matchingStudents = new ArrayList<>();
  try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
    String line;
    while ((line = reader.readLine()) != null) {
      Student student = Student.parse(line);
      if (student.getName().equalsIgnoreCase(name)) {
        matchingStudents.add(student);
      }
    }
  }
  return matchingStudents;
}

}
