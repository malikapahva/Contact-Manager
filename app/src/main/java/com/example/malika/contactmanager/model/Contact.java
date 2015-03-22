package com.example.malika.contactmanager.model;

/**
 * Created by Malika Pahva (mxp134930) on 3/18/2015.
 * Course: CS6301.001
 *
 * This is a domain class for contact.
 */
public class Contact {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    /**
     * This is a constructor to sets the id of contact.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param id
     */
    public Contact(long id) {
        this.id = id;
    }

    /**
     * This is a constructor to set the firstName, lastName,
     * phoneNumber and email of contact.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param firstName
     *
     * @param lastName
     *
     * @param phoneNumber
     *
     * @param email
     */
    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * This is a getter method which returns the contact id.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @return  long id
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * This is a getter method which returns the firstName.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @return  String firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This is a setter method which sets the value of firstName.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This is a getter method which returns the lastName.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @return  String lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This is a setter method which sets the value of lastName.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This is a getter method which returns the phone number.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @return  String phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This is a setter method which sets the value of phone number.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This is a getter method which returns the email.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @return  String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This is a setter method which sets the value of email.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
