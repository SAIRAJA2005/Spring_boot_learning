package io.learn;

public class Dev {

//    private int age;
//
//    // here the setter and getters of the age are used for the setter injection.
//    public int getAge() {
//        return age;
//    }
//
//    // here the age value comes from the property tag which is there in the spring.xml[resources]
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//
    public Dev(){
        System.out.println("I am Dev constructor!!");
    }
//
//    // here the parameterized constructor is used for constructor injection.
//    // the value of the age comes from the constructor-arg tag which is there in the spring.xml[resources]
//    public Dev(int age) {
//        this.age = age;
//        System.out.println("Hey!! I am the parameterized constructor for the Dev class for the age.");
//    }

    // it only creates the reference , not the object
//    private Laptop laptop;
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

//    public Dev(Laptop laptop) {
//        this.laptop = laptop;
//        System.out.println("Hey i am the constructor injection , laptop -> Dev");
//    }

    private Computer com;


    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void build(){
        System.out.println("Working on Awesome project!!");
        com.compile();
    }
}
