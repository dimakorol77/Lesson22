import java.io.*;

public class SerializationWithMethods {


        public static void main(String[] args) {
            // Создаем объект класса File и указываем путь к файлу
            File f = new File("file.txt");
            String content = "Hello, Димусик Король";

            // Сериализация в файл, используя FileOutputStream и ObjectOutputStream
            try {
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(content);
                oos.flush();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Десериализация из файла, используя FileInputStream и ObjectInputStream
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                String newContent = (String)ois.readObject();
                ois.close();
                System.out.println(newContent);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Чтение из файла с помощью BufferedReader и FileReader
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


