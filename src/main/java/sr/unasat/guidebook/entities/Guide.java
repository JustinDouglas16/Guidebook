package sr.unasat.guidebook.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Guide {

    @Id
    private int id;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
