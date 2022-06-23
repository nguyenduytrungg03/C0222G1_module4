package com.declaration.declaration.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "firt_name")
    @NotBlank(message = "Tên không đươc để trống")
    private String firtName;
    @Column(name = "last_name")
    @NotBlank(message = "Tên không được để trống!")
    private String lastName;
    @Column(name = "phone_number")
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$")
    private String phoneNumber;
    @Min(value = 18, message = "tuổi phải trên 18")
    @Max(value = 100, message = "tuổi phải dưới 100")
    private Integer age;
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$", message = "email sai định dạng ")
    private String email;


    public User() {
    }

    public User(Integer idUser,
                @NotBlank(message = "Tên không đươc để trống") String firtName,
                @NotBlank(message = "Tên không được để trống!") String lastName,
                @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$") String phoneNumber,
                @Min(value = 18, message = "tuổi phải trên 18") @Max(value = 100, message = "tuổi phải dưới 100") Integer age,
                @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$", message = "email sai định dạng ") String email) {
        this.idUser = idUser;
        this.firtName = firtName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
