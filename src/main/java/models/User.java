package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fio")
    private String fio;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public User() {
    }

    public User(String fio) {
        this.fio = fio;
        orders = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        order.setUser(this);
        orders.add(order);

    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return fio;
    }

    public void setName(String fio) {
        this.fio = fio;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                '}';
    }

}
