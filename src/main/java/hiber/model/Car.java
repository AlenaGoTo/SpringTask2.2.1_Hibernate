package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer series;

    @Column(name = "model")
    private String model;

    // если нужно создать внешний ключ для двусторонней связи
    //@OneToOne(mappedBy="car") // с mappedBy поле для ключа создастся только у владельца, т.е. юзера
    //private User user;

    //@ManyToOne//(cascade = CascadeType.ALL)
   //private User user;

    public Car() {}

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    @Override
    public String toString() {
        return "series = " + series +
                ", model = " + model;
    }
}
