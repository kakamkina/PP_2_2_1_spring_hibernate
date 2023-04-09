package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        CarService carService = context.getBean(CarService.class);

        User user01 = new User("Vasya", "Pupkin", "kk@me.com");
        userService.add(user01);
        Car car01 = new Car(user01, "priora", 666);
        carService.add(car01);
        user01.setCar(car01);
        car01.setUser(user01);

        User user02 = new User("Rybku", "S'est", "iKodNapisat'@me.com");
        userService.add(user02);
        Car car02 = new Car(user02, "bicycle", 1001);
        carService.add(car02);
        user02.setCar(car02);
        car02.setUser(user02);

        User user03 = new User("Nikola", "Tesla", "tesla1856@me.com");
        userService.add(user03);
        Car car03 = new Car(user03, "s", 2021);
        carService.add(car03);
        user03.setCar(car03);
        car03.setUser(user03);

        List<Car> cars = carService.listCars();
        for (Car car : cars) {
            System.out.println("Model = " + car.getModel());
            System.out.println("Series = " + car.getSeries());
            System.out.println();
        }

        List<User> getUserByCar = userService.getUserByCar("priora", 666);
        for (User user : getUserByCar) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
