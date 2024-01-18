package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data");
        System.out.print("Name: ");
        String nameClient = sc.nextLine();
        System.out.print("Email: ");
        String emailClient = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDateClient = sdf.parse(sc.next());

        Client client = new Client(nameClient, emailClient, birthDateClient);

        System.out.println("Enter order data");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        System.out.print("How many items to this order?: ");
        int n = sc.nextInt();

        Order order = new Order(new Date(), status, client);

        for(int i = 1; i <= n; i++){
            System.out.println();
            System.out.println("Enter #" + i + " item data");
            System.out.print("Name product: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem item = new OrderItem(productQuantity, productPrice, product);

            order.addItem(item);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY");
        System.out.println(order);

        sc.close();

    }
}
