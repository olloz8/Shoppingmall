package eCommerce.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.DAO.SupplierDAO;
import eCommerce.model.Supplier;

public class SupplierJunitTest {

    static SupplierDAO supplierDAO;

    @BeforeAll
    public static void executeFirst() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("eCommerce");
        context.refresh();

        supplierDAO = context.getBean(SupplierDAO.class);
    }

    @Test
    public void addSupplierTest() {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(5);
        supplier.setSupplierAddr("Seoul");
        supplier.setSupplierName("root");

        assertTrue("Problem in adding Supplier", supplierDAO.addSupplier(supplier));
    }
}