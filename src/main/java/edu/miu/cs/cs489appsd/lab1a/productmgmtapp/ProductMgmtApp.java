package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class ProductMgmtApp {

    public static void main( String[] args ) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(3128874119L, "Banana", LocalDate.of(2023, 12, 9), 124, 0.55));
        productList.add(new Product(2927458265L, "Apple", LocalDate.of(2023, 1, 24), 18, 1.09));
        productList.add(new Product(9189927460L, "Carrot", LocalDate.of(2023, 3, 31), 89, 2.99));

        System.out.println("Printed in JSON Format");
        printProducts(productList);

        System.out.println("------------------------------");
        System.out.println("Printed in XML Format");
        xmlFormat(productList);
        System.out.println();

        System.out.println("------------------------------");
        System.out.println("Printed in Comma-Separated Value (CSV) Format");
        csvFormat(productList);
    }

    private static void printProducts(List<Product> listOfProducts) {
        jsonFormat(listOfProducts);
    }

    private static void jsonFormat(List<Product> list) {
        StringBuilder jsonSb = new StringBuilder("[");
        jsonSb.append("\n");
        for(Product product: list) {
            jsonSb.append("   " );
            jsonSb.append("\"productId\":"); jsonSb.append(product.getProductId()); jsonSb.append(", ");
            jsonSb.append("\"name\":"); jsonSb.append(product.getName()); jsonSb.append(", ");
            jsonSb.append("\"dateSupplied\":"); jsonSb.append(product.getDateSupplied()); jsonSb.append(", ");
            jsonSb.append("\"quantityInStock\":"); jsonSb.append(product.getQuantityInStock()); jsonSb.append(", ");
            jsonSb.append("\"unitPrice\":"); jsonSb.append(product.getUnitPrice()); jsonSb.append(", ");
            jsonSb.append("\n");
        }
        jsonSb.append("]");

        System.out.println(jsonSb);
    }

    private static void xmlFormat(List<Product> list) {
        StringBuilder xmlsb = new StringBuilder("<?xml version\"=\"?>"); xmlsb.append("\n");
        xmlsb.append("<products>"); xmlsb.append("\n");
        for(Product product: list) {
            xmlsb.append("   <product "); xmlsb.append("productId=\""); xmlsb.append(product.getProductId()); xmlsb.append("\"");
            xmlsb.append(" "); xmlsb.append("name=\""); xmlsb.append(product.getName()); xmlsb.append("\"");
            xmlsb.append(" "); xmlsb.append("dateSupplied=\""); xmlsb.append(product.getDateSupplied()); xmlsb.append("\"");
            xmlsb.append(" "); xmlsb.append("quantityInStock=\""); xmlsb.append(product.getQuantityInStock()); xmlsb.append("\"");
            xmlsb.append(" "); xmlsb.append("unitPrice=\""); xmlsb.append(product.getUnitPrice()); xmlsb.append("\"");
            xmlsb.append("/>");
            xmlsb.append("\n");
        }
        xmlsb.append("</products>");

        System.out.println(xmlsb);

    }

    private static void csvFormat(List<Product> list) {
        StringBuilder csvsb = new StringBuilder();
        for (Product product: list) {
            csvsb.append(product.getProductId()); csvsb.append(", ");
            csvsb.append(product.getName()); csvsb.append(", ");
            csvsb.append(product.getDateSupplied()); csvsb.append(", ");
            csvsb.append(product.getQuantityInStock()); csvsb.append(", ");
            csvsb.append(product.getUnitPrice()); csvsb.append(", ");
            csvsb.append("\n");
        }

        System.out.println(csvsb);
    }
}
