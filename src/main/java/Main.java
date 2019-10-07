import models.Order;
import models.User;
import services.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = new User("Petrov");
        userService.saveUser(user);
        Order byuTV = new Order("TV");
        byuTV.setUser(user);
        user.addOrder(byuTV);
        Order byuTicket = new Order("Ticket");
        byuTicket.setUser(user);
        user.addOrder(byuTicket);
        userService.updateUser(user);
    }
}