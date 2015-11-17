package database.DTO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by V on 07.11.2015.
 */

@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

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
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date wasCreated;

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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreated() {
        return wasCreated;
    }

    public void setCreated(Date created) {
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
