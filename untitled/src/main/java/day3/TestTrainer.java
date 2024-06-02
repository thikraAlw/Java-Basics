package day3;

public class TestTrainer {

    public static void main(String[] args) {

        Trainer t1 = new Trainer(101, "Alaa", 1000);
//        Course c = new Course();

//        t1.addCourse(c);

        System.out.println(t1.AnalSalary());

        SalesPerson sp = new SalesPerson(102, "sa", 3999, 4.5);

        System.out.println(sp.getTotalSalary());
    }
}
