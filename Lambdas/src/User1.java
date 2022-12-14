package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User1 {
    private String name;
    private String role;

    public User1(String name, String role) {
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
        List<User1> users = new ArrayList<>();
        users.add(new User1("Denis", "mentor"));
        users.add(new User1("Evgenii", "intern"));
        users.add(new User1("Ekaterina", "intern"));
        users.add(new User1("Valentina", "intern"));

                            users.stream()
                                    .filter(user -> user.getRole().equals("intern"))
                                    .forEach(role -> role.setRole("software engineer"));
                                    users.forEach(System.out::println);

        System.out.println( users.stream()
                                    .filter(user -> user.getName().toLowerCase().startsWith("e"))
                                    .map(user ->user.getName())
                                    .collect(Collectors.toList())
        );
        System.out.println( users.stream()
                                    .filter(user -> user.getName().length() >= 6)
                                    .map(user -> user.getName())
                                    .collect(Collectors.toList())
        );
        System.out.println( users.stream()
                .allMatch(user -> user.getName().length() >= 6)
        );
        System.out.println( users.stream()
                .noneMatch(user -> user.getRole().equals("software tester"))
        );
    }

}