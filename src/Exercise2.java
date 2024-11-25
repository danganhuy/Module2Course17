import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    // [Thực hành] Đọc và ghi danh sách sinh viên ra file nhị phân
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "AAA", "Hà Nội"));
        students.add(new Student(2, "QDF", "Quảng Ninh"));
        students.add(new Student(3, "YGN", "Hạ Long"));
        students.add(new Student(4, "PLD", "Đà Nẵng"));
        students.add(new Student(5, "EIL", "Hải Phòng"));
        students.add(new Student(6, "VRB", "Tây Ninh"));

        writeDataToFile("file\\student.txt", students);

        List<Student> studentDataFromFile = readDataFromFile("file\\student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }

    public static void writeDataToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
