/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
static: belongs to the class, you can only put static var and static method in a static method. You should only call a static method through the class
Xxxxx.method()
Examples:
	String.format()
	Math methods
	Character methods

non static: belongs to the object, you can put anything (static var, static method, non-static var, non-static method) in a non-static method. You
can only call a non-static method through the object xxxx.method()

99% of method in a class should be non-static
*/
package student;

/**
 * Class of Student, basic OOP exercise
 * @author 1830041
 */
public class Student {
    private String name;
    private int age;
    private String gender;
    private String id;
    private String email; // name@vaniercollege.qc.ca
    private Address address;
    private static int nextId = 1; // one copy of it
    private final static String SCHOOL_NAME = "Vanier College";

    public Student() {
            this.name = null;
            this.age = 0;
            this.gender = null;
            this.id = null;
            this.email = null;
            this.address = null;
    }

    public Student(String name, String gender) { // non-static method
            this.name = name;
            this.age = 0;
            this.gender = gender;
            this.id = String.format("%06d", nextId++);
            generateEmail();
            this.address = null;
    }

    public Student(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.id = String.format("%06d", nextId++); // satatic var
            generateEmail();
            this.address = null;
    }

    public Student(String name, int age, String gender, Address address) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.id = String.format("%06d", nextId++); // satatic var
            generateEmail();
            this.address = address;
    }

    public Student(Student student) {
            this.name = student.name;
            this.age = student.age;
            this.gender = student.gender;
            this.id = student.id;
            this.email = student.email;
            // this.address = student.address; // shallow copy
            this.address = new Address(student.address); // deep copy
    }

    public void generateEmail() {
            email = String.format("%s@vaniercollege.qc.ca", name.toLowerCase());
    }

    public boolean isNameValid(String name) { // static method
            for (int i = 0; i < name.length(); i++) { // age: non-static
                    char c = name.charAt(i);
                    if (!Character.isLetter(c) && c != ' ' && c != '-' && c != '\'')
                            return false;
            }
            return true;
    }

    /**
     * To check if the student lives far away from the school or not, the rule is:
     * 1. if the student lives in Montreal, then print "not far"
     * 2. if the student lives outside of Montreal but inside of QC, then print "not far, not close"
     * 3. if the student lives outside of QC, then print "very far"
     */
    public void checkDistance() {
        if (address.getCity().equalsIgnoreCase("montreal"))
            System.out.println("not far");
        else if (address.getProvince().equalsIgnoreCase("qc"))
            System.out.println("not far, not close");
        else
            System.out.println("very far");
    }

    public boolean equals(Student student) {
            return this.name.equals(student.name) && this.age == student.age &&
                    this.gender.equals(student.gender) && this.id.equals(student.id) && this.email.equals(student.email)
                    && this.address.equals(student.address);
    }

    @Override
    public String toString() { // non-static method
            String str = "";

            str += String.format("Student from %s\n", SCHOOL_NAME); // static var
            str += String.format("%-10s: %s\n", "ID", id);
            str += String.format("%-10s: %s\n", "Name", name);
            str += String.format("%-10s: %d\n", "Age", age);
            str += String.format("%-10s: %s\n", "Gender", gender);
            str += String.format("%-10s: %s\n", "Email", email);
            str += String.format("%-10s: %s\n", "Address", address);

            return str;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            if(isNameValid(name)) {
                    this.name = name;
                    email = String.format("%s@vaniercollege.qc.ca", name);
            }
            else
                    System.out.println("Sorry, the new name is invalid....Request denied");
    }

    public int getAge() {
            return age;
    }

    public void setAge(int age) {
            this.age = age;
    }

    public String getGender() {
            return gender;
    }

    public void setGender(String gender) {
            this.gender = gender;
    }

    public String getID() {
            return id;
    }

    public void setID(String id) {
            this.id = id;
    }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
            int atIdx = email.indexOf('@');
            name = email.substring(0, atIdx);
    }

    public Address getAddress() {
            return address;
    }

    public void setAddress(Address address) {
            this.address = address;
    }
	
//	private String name;
//	private String id;
//	private int age;
//	private String tel; // in a class, whatever method can read and write
//	
//	// Constructor is a special method that is used to initialize an object of that class.
//	// Usually we can have more than one constructors in one class, and we write constructors at the very beginning of the class,
//	// just under the data memebrs.
//	// Constructor is always public, with no return type, the method name is always the same as the class name (first character uppercase
//	
//	public Student() { // empty parameter, default constructor
//		this.name = null;
//		this.id = null;
//		this.age = 0;
//		this.tel = null;
//	}
//	public Student(String name, String id) {
//		this.name = name;
//		this.id = id;
//		this.age = -1;
//		this.tel = null;
//	}
//	public Student(String name, String id, int age) {
//		this.name = name;
//		this.id = id;
//		this.age = age;
//		this.tel = null;
//		// int -> 0, double -> 0, char -> 0, boolean -> false, String -> null 
//	}
//	public Student(String name, String id, int age, String tel) {
//		this.name = name; // . -> 's this -> this object
//		this.id = id;
//		this.age = age;
//		this.tel = tel;
//	}
//	
//	public Student(Student student) { // copy constructor
//		this.name = student.name;
//		this.id = student.id;
//		this.age = student.age;
//		this.tel = student.tel;
//	}
//	/*
//	toString() method is used to convert an object to a string, usually it is
//	used to create a string to represent the object, so it contains some data members
//	*/
//	@Override
//	public String toString() {
//		String str = "";
//		
//		str += String.format("%-10s: %s\n", "Name", name);
//		str += String.format("%-10s: %s\n", "ID", id);
//		str += String.format("%-10s: %d\n", "Age", age);
//		str += String.format("%-10s: %s\n", "Tel.", tel);
//		
//		return str;
//	}
//	
//	// overload version
//	public boolean equals(Student student) { // temporal solution for programming 1
//		return this.name.equals(student.name) && this.id.equals(student.id) &&
//			this.age == student.age && this.tel.equals(student.tel);
//	}
//	
//	// getter and setter
//	public String getName() {
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String getID() {
//		return id;
//	}
//	
//	public void setID(String id) {
//		this.id = id;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	public String getTel() {
//		return tel;
//	}
//	
//	public void setTel(String tel) {
//		this.tel = tel;
//	}

}
