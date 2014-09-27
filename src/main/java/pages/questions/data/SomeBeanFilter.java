package pages.questions.data;

import pages.questions.data.SomeBean;

import java.io.Serializable;

public class SomeBeanFilter implements Serializable {
    String lastName;
    String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean match(SomeBean bean) {
        boolean ret = true;

        if (lastName != null) {
            if (!bean.getLastName().startsWith(lastName)) ret = false;
        }
        if (firstName != null) {
            if (!bean.getFirstName().startsWith(firstName)) ret = false;
        }

        return ret;
    }
}

