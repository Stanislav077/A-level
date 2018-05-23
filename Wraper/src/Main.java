public class Main {

    public static void main(String[] args) {
        Lable testlable = new Pizza("Four Seasons Pizza");
        testlable = new RegularExtra("Pepperoni",testlable);
        testlable = new TooExtra("Tomato",testlable);
        System.out.println(testlable.getLabel());
    }
}
