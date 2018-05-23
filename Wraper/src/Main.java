public class Main {

    public static void main(String[] args) {
        Lable testlable = new Pizza("Four Seasons Pizza");
        testlable = new RegularExtra("Pepperoni",testlable);
        System.out.println(testlable.getLabel());
    }
}
