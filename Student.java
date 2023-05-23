public class Student {

  private String Name;
  private int Age;
  private String Surname;
  private String Street;
  private String BirthDate;

  public Student(String name, String surname, int age, String street, String birthDate) {
    Name = name;
    Age = age;
    Surname = surname;
    Street = street;
    BirthDate = birthDate;
  }

  public String getName() {
    return Name;
  }

  public int getAge() {
    return Age;
  }

  public String getSurname() {
    return Surname;
  }

  public String getStreet() {
    return Street;
  }

  public String getBirthDate() {
    return BirthDate;
  }

  @Override
  public String toString() {
    return Name + " " + Surname + " " + Integer.toString(Age) + " " + Street + " " + BirthDate;
  }

  public static Student parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 5) {
      return new Student("Parse Error", "Parse Error", -1, "Parse Error", "Parse Error");
    }
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
  }
}
