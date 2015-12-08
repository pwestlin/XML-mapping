package nu.westlin.xmlmapping;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlType(propOrder={"name", "phoneNumbers", "address"})
public class Customer {

    private String name;
    private Address address;
    private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

    public Customer() {
    }

    @XmlPath("personal-info/name/text()")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlPath("contact-info/address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

/*
    @XmlPath("contact-info/phone-number")
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
*/

    @XmlPath("contact-info/phone-number")
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    private void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

}