
package za.ac.tut.ui;




public class Kid{

    private String name;
    private String gender;

    public Kid(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Kid " + " name :" + name + ", gender:" + gender ;
    }
    
    
}
