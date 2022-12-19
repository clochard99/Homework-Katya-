
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Product notebookHP = new Product(1, "HP", "Notebook", 199.99);
        Product phoneSamsung = new Product(2, "Samsung", "Phone", 129.99);
        Product apple = new Product(3, "IPhone", "Phone", 199.99);
        Product apple1 = new Product(4,"MacBook", "Notebook", 499.99);
        Product apple2 = new Product(5, "AirPods", "Headphones", 99.99);
        Product apple3 = new Product(6, "IPhone Case", "Accessories", 29.99);
        Product notebookAcer = new Product(7, "Acer", "Notebook", 299.99);


        List<Product> products = new ArrayList<>();
        products.add(notebookHP);
        products.add(phoneSamsung);
        products.add(apple);
        products.add(apple1);

        List<Product> products1 = new ArrayList<>();
        products1.add(apple2);
        products1.add(apple3);
        products1.add(notebookAcer);

        Customer theShop = new Customer(1, "TheShop", 3);
        Customer sergeyId = new Customer(2, "SergeyId", 5);
        Customer computerGeek =  new Customer(3, "ComputerGeek", 4);
        Customer beliElektronik = new Customer(4,"Beli-elektronik", 2);
        Customer technoLub = new Customer (5, "TechnoLub", 1);
        Customer veshalka69= new Customer(6, "Elena", 3);


        Order order1 = new Order(1, LocalDate.of(2022, 2, 20), LocalDate.of(2022, 12, 20), "ready", computerGeek, products);
        Order order2 = new Order(2, LocalDate.of(2022, 6, 12), LocalDate.of(2022, 6, 12), "ready", computerGeek, products1);
        Order order3 = new Order(3, LocalDate.of(2022, 6, 12), LocalDate.of(2022, 6, 13), "ready", veshalka69, products);
        Order order4 = new Order(4, LocalDate.of(2022, 7, 1), LocalDate.of(2022, 7, 2), "ready", beliElektronik, products);
        Order order5 = new Order(5, LocalDate.of(2022,9 , 12), LocalDate.of(2022, 9, 14), "ready", technoLub, products);
        Order order6 = new Order(6, LocalDate.of(2022, 12, 14), LocalDate.of(2022, 12, 15), "ready", theShop, products);
        Order order7 = new Order(7, LocalDate.of(2022, 12, 15), LocalDate.of(2022, 12, 16), "ready", sergeyId, products);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);

        // Получить список товаров из категории «n» с ценой > 130
        System.out.println(
                products.stream()
                        .filter(p -> p.getPrice() > 130)
                        .filter(c-> c.getCategory().contains("Phone"))
                        .collect(Collectors.toList())
        );

        // Получить список заказов с товарами, относящимися к категории «n»
        System.out.println(orders.stream()
                .flatMap(p -> p.getProducts().stream())
                .filter(c->c.getCategory().contains("Phone"))
                .collect(Collectors.toList()));

        // Получите список товаров с категорией «n», а затем примените скидку 25%
        System.out.println(products.stream()
                .filter(c->c.getCategory().contains("Notebook"))
                .map(p->p.getPrice() * 0.75)
                .collect(Collectors.toList()));

        // Получите список товаров, заказанных клиентом уровня 3 в период с 01 марта 2022 г. по 30 июня 2022 г.
        System.out.println(orders.stream()
                .filter(d->d.getOrderDate().isAfter(LocalDate.of(2022,3,1)))
                .filter(d1->d1.getDeliveryDate().isBefore(LocalDate.of(2022,6,30)))
                .filter(c->c.getCustomer().getTier() == 3)
                .flatMap(p -> p.getProducts().stream())
                .collect(Collectors.toList())
        );

        // Получите самые дешевые товары категории «n»

                products.stream()
                        .filter(c -> c.getCategory().contains("Notebook"))
                        .reduce((c1,c2) -> c1.getPrice() <= c2.getPrice() ? c1 : c2)
                        .ifPresent(c ->System.out.println("Lowest priced product :" + c));

        // Получите 5 последних заказа
        orders.stream()
                .sorted((o1,o2) -> o2.getOrderDate().compareTo(o1.getOrderDate()))
                .limit(5)
                //.distinct()
                //.skip(2)
                .map(id -> id.getId())
                .forEach(System.out::println);

        // Получите список заказов, которые были заказаны 12 июня 2022 года. Выведите все записи заказов в консоль. Верните список продуктов.
        System.out.println(orders.stream()
                .filter(d -> d.getOrderDate().isEqual(LocalDate.of(2022, 6,12)))
                .flatMap(p -> p.getProducts().stream())
                .collect(Collectors.toList())

        );

        // Рассчитайте общую сумму всех заказов, сделанных в июне
        System.out.println( orders.stream()
                .filter(d -> d.getOrderDate().getMonth() == Month.JUNE)
                .flatMap(p -> p.getProducts().stream())
                .mapToDouble(Product ::getPrice).sum()
        );

        // Рассчитать среднюю сумму заказов за 20 февраля
        Double average = orders.stream()
                .filter(d -> d.getOrderDate().isEqual(LocalDate.of(2022, 2,20)))
                .flatMap(p -> p.getProducts().stream())
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println(average);

        // Получите Map'у с идентификатором заказа и количеством продуктов в заказе. (Для этого надо переписать Order класс и использовать коллекцию для товаров)
        System.out.println(orders.stream()
                .collect(Collectors.toMap(Order:: getId, o -> o.getProducts().size())));
        // Получите Map'у с заказом и общей суммой товаров
        System.out.println( orders.stream()
                .collect(Collectors.toMap(Order::getId, o -> o.getProducts().stream().mapToDouble(Product::getPrice).sum())
        ));

        // Получите самый дорогой продукт по категории
        products.stream()
                .filter(c -> c.getCategory().contains("Notebook"))
                .reduce((c1,c2) -> c1.getPrice() >= c2.getPrice() ? c1 : c2)
                .ifPresent(c ->System.out.println("Highest priced product :" + c));
    }

}
