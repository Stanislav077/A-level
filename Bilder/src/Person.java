/**
 * Created by Станислав on 23.05.2018.
 */
public class Person {

    private final String lastName;
    private final String firstName;
    private String middleName;
    private String salutation;
    private String suffix;
    private String streetAddress;
    private String city;
    private String state;
    private final boolean isFemale;
    private boolean isEmployed;
    private boolean isHomewOwner;



    Person(PersonBilder personBilder){
        this.lastName = personBilder.getLastName();
        this.firstName = personBilder.getFirstName();
        this.isFemale = personBilder.isFemale();
        this.middleName =personBilder.getMiddleName();
        this.salutation = personBilder.getSalutation();
        this.suffix = personBilder.getSuffix();
        this.streetAddress = personBilder.getStreetAddress();
        this.city = personBilder.getCity();
        this.state=personBilder.getState();
        this.isEmployed=personBilder.isEmployed();
        this.isHomewOwner=personBilder.isHomewOwner();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public boolean isHomewOwner() {
        return isHomewOwner;
    }
}
