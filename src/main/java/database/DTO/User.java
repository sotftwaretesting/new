package database.DTO;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by V on 07.11.2015.
 */

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    @Column(name = "createdDate")
//    @Temporal(value = TemporalType.TIMESTAMP)
    private Timestamp wasCreated;

    public User() {
    }

    public User(String name, int age, boolean isAdmin, Timestamp created){
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.wasCreated = created;
    }

    public int getId() {
        return id;
    }

    //todo change to private
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Timestamp getCreated() {
        return wasCreated;
    }

    public void setCreated(Timestamp created) {
        this.wasCreated = created;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isAdmin=" + isAdmin +
                ", created=" + wasCreated +
                '}';
    }
}
