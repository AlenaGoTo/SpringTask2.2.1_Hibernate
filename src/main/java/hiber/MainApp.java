package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user123 = new User("User", "CarContainer", "user1@mail.ru");
      Car car1 = new Car("модель-1");
      Car car2 = new Car("модель-2");
      Car car3 = new Car("модель-3");
      Car car4 = new Car("модель-4");

      user123.setCar(car1);
      user123.setCar(car2);
      user123.setCar(car3);
      userService.add(user123);



/*
      Car car1 = new Car("модель-1");
      Car car2 = new Car("модель-2");
      Car car3 = new Car("модель-3");
      Car car4 = new Car("модель-4");

      userService.add(new User("User1", "Lastname1", "user1@mail.ru").setCar(car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru").setCar(car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru").setCar(car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru").setCar(car4));
*/

      //User user1 = userService.userByCar("модель-3", 1); // юзеры катающиеся на определенной модели машины
      //System.out.println(user1 != null ? user1 : "нету");

      /*List<User> users = userService.listUsers(); // список всех юзеров
      for (User user : users) {
         System.out.println(user.toString());
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().toString());
         System.out.println();
      }*/



      context.close();
   }
}
