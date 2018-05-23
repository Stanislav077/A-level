public class Main {

    public static void main(String[] args) {
Person person = new PersonBilder("Ivanov","Ivan",true,"MidleName","solut","pr_","adress","khakov","state",true,true).bulid();
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());

    }
}
