import java.io.*;

public class SerilizationClassPersonWithInterface {


        public static void main(String[] args) throws IOException, ClassNotFoundException {
            // Создание объекта
            Person person = new Person("John", 30);

            // Сериализация объекта в файл
            FileOutputStream fos = new FileOutputStream("person.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();

            // Десериализация объекта из файла
            FileInputStream fis = new FileInputStream("person.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person deserializedPerson = (Person) ois.readObject();
            ois.close();

            // Проверка результата
            System.out.println("Имя: " + deserializedPerson.getName() + ", Возраст: " + deserializedPerson.getAge());
        }
    }

    class Person implements Serializable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }



