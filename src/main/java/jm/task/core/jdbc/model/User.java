package jm.task.core.jdbc.model;

import jakarta.persistence.*;
//import javax.persistence.*;
import java.io.Serializable;

import static jakarta.persistence.GenerationType.AUTO;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
public class User implements Serializable {
    // У аннотации @Column есть следующие свойства:
    //
    //name — определяет имя столбца в базе данных. Если не указано, то по умолчанию имя столбца получается из имени поля.
    //
    //nullable — определяет, может ли столбец содержать нулевые значения. По умолчанию столбцы являются nullable.
    //
    //unique — указывает, должен ли столбец содержать уникальные значения.
    //
    //length — устанавливает максимальную длину столбца для строковых полей.
    //
    //precision и scale — используются для полей с десятичными значениями, чтобы указать точность и масштаб столбца.
    //
    //insertable и updatable — контролируют, должен ли столбец включаться во время операций INSERT и UPDATE.
    @Id
    @GeneratedValue(strategy = IDENTITY)//(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false, unique = false)
    //name — определяет имя столбца в базе данных. Если не указано, то по умолчанию имя столбца получается из имени поля.
    //
    //nullable — определяет, может ли столбец содержать нулевые значения. По умолчанию столбцы являются nullable.
    //
    //unique — указывает, должен ли столбец содержать уникальные значения.
    //
    //length — устанавливает максимальную длину столбца для строковых полей.
    //
    //precision и scale — используются для полей с десятичными значениями, чтобы указать точность и масштаб столбца.
    //
    //insertable и updatable — контролируют, должен ли столбец включаться во время операций INSERT и UPDATE.
    private String name;

    @Column(length = 128, nullable = false, unique = false)
    private String lastName;

    @Column(unique = false)
    private Byte age;

    public User() {
    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
