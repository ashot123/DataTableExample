package pages.questions.data;

import java.io.Serializable;

/**
 * Created by Ashot Karakhanyan on 13-09-2014
 */
public class SomeBean implements Serializable {

    String firstName;
    String lastName;
    int age;

    public SomeBean(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}

