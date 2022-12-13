package jdbc.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

class User {
    private String name;
    private String role;

    User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", role='" + role + '\'' + '}';
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Denis", "mentor"));
        users.add(new User("Evgenii", "intern"));
        users.add(new User("Ekaterina", "intern"));
        users.add(new User("Valentina", "intern"));

        //Task 1: using Predicate to get interns list.
        Predicate<User> predicate = role -> role.getRole().contains("intern");
        for (User role : users) {
            System.out.println(predicate.test(role));
        }
        //Task 2: using Function to add to the list new user and return a number of users with the same role.
        BiFunction<String, String, User> bifunction = (name, role) -> new User(name,role);
        users.add(bifunction.apply("Sergey","mentor"));
        users.add(bifunction.apply("Dmitrii","intern"));
        System.out.println(users);
        int count = 0;
        for (User role : users) {       // a reference to the previous task
            if (predicate.test(role)) {
                count++;
            }
        }
        System.out.println(count);
        //Task 3: using Consumer to do pretty output the given user.
        Consumer<User> consumer = user -> System.out.println("Thank you, " +user.getName() + ", that you teach us how to become as cool " + user.getRole() + " as you in future");
        consumer.accept(users.get(0));
        users.forEach(user -> System.out.println("We appreciate " +user.getName() + " who is a good " + user.getRole()));
        //Task 4: Add new field, like \"luck\". using Supplier to randomly set luck (0 - 100).
        int a = 0;
        int b =2000;
        Supplier<Integer> supplier = () -> a+(int)(Math.random() *b) ;
        users.forEach(user -> System.out.println(user.getName() + " earned " + supplier.get() + " euros "));
    }
}