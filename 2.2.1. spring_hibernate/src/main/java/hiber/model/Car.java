package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Car")
public class Car implements Serializable {

    @Id
    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {
    }

    public Car(User user, String model, int series) {
        this.user = user;
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public User getUser() {
        return user;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "user=" + user.getFirstName() +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
