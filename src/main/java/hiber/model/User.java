package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "lastname")
   private String lastName;

   @Column(name = "email")
   private String email;

   // внешний ключ
   @OneToOne(cascade = CascadeType.ALL) // cascade сохраняет дочерний car в БД при сохранении его родителя user-а.
   //@JoinColumn(name = "car_series") // если хотим переименовать поле в БД
   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public User setCar(Car car) {
      this.car = car;
      // чтобы при двусторонней oneToOne в таблице cars заполнялись ключи на юзера (а то будет null)
      //if (car.getUser() != this) this.car.setUser(this);
      return this;
   }
}
