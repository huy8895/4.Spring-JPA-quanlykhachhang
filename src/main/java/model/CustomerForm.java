package model;

import org.springframework.web.multipart.MultipartFile;

public class CustomerForm {
    private String firstName;

    private String lastName;

    private MultipartFile avatar;

    private Province province;

    public CustomerForm(String firstName, String lastName, MultipartFile avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public CustomerForm(String firstName, String lastName, MultipartFile avatar, Province province) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
        this.province = province;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public CustomerForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
