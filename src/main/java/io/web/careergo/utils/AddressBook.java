/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.web.careergo.utils;

/**
 *
 * @author M Zubair Ul Hassan
 */
public class AddressBook {
    private String street;
    private String city;
    private String country;

    public AddressBook(String address) {
        String[] splitAddress = address.split(",");
        this.street = splitAddress[0];
        this.city = splitAddress[1];
        this.country = splitAddress[2];
    }

    @Override
    public String toString() {
        return "" + "street=" + street + ", city=" + city + ", country=" + country;
    }
    
    
}