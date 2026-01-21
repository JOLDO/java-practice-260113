package _1_test_260113;

public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String nameValue, int ageValue, String addressValue) {
        this.name = nameValue;
        this.age = ageValue;
        this.address = addressValue;
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    public String getAddress() { return address; }

    public void setName(String name) { this.name = name; }

    public void setAge(int age) { this.age = age; }

    public void setAddress(String address) { this.address = address; }
}
