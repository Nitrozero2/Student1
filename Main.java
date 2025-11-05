import java.util.*;

class KLTN<T extends Student, V> implements Comparable<KLTN<T, ?>> {
    private T student;
    private V supervisor;
    private String getTitle;

    public KLTN(T student, V supervisor, String getTitle) {
        this.student = student;
        this.supervisor = supervisor;
        this.getTitle = getTitle;
    }
    public String getThesisTitle() {
        return getTitle;
    }
    @Override
    public int compareTo(KLTN<T, ?> o) {
        return this.getTitle.compareToIgnoreCase(o.getTitle);
    }
}
class ListSortable<E extends Comparable<? super E>> {
    private List<E> list = new ArrayList<>();

    public void add(E e) { list.add(e); }
    public void sort() { Collections.sort(list); }
    public void print() { for (E e : list) System.out.println(e); }
}
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("1", "Nguyen Van A", "a@uet.edu.vn");
        Student s2 = new Student("2", "Nguyen Van A", "b@uet.edu.vn");
        Student s3 = new Student("3", "Nguyen Van A", "c@uet.edu.vn");

        Teacher t1 = new Teacher("1", "Mr.Cuong", "cuong@uet.edu.vn", "PGS.TS");
        Advisor a1 = new Advisor("Mr.Hieu", "hieu@uet.edu.vn");

        KLTN<Student, Teacher> k1 = new KLTN<>(s1, t1, "kltn1");
        KLTN<Student, Advisor> k2 = new KLTN<>(s2, a1, "kltn2");
        KLTN<Student, Teacher> k3 = new KLTN<>(s3, t1, "kltn3");
        ListSortable<KLTN<Student, ?>> list = new ListSortable<>();
        list.add(k1);
        list.add(k2);
        list.add(k3);
        System.out.println("Danh sách KLTN ban đầu");
        list.print();
        list.sort();
        System.out.println("\nDanh sách sau khi sắp xếp");
        list.print();
    }
}
