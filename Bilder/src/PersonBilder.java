/**
 * Created by Станислав on 23.05.2018.
 */
public class PersonBilder {
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


    public PersonBilder(String lastName, String firstName, boolean isFemale,  String middleName, String salutation, String suffix, String streetAddress, String city, String state,boolean isEmployed, boolean isHomewOwner) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.isFemale = isFemale;
        this.middleName = middleName;
        this.salutation = salutation;
        this.suffix = suffix;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.isEmployed = isEmployed;
        this.isHomewOwner = isHomewOwner;
    }
    public  Person bulid(){
        return new Person(this);
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
