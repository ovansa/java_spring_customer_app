package com.ovansacode.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list")
public class CustomerListDataAccessService implements CustomerDao {
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();

        Customer ovansa = new Customer(1, "Ovansa", "ovansa@gmail.com", 21);
        Customer onize = new Customer(2, "Onize", "onize@gmail.com", 22);

        customers.add(ovansa);
        customers.add(onize);
    }


    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream().filter(customer ->
                customer.getId().equals(id)).findFirst();
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean customerWithEmailExists(String email) {
        return customers.stream().anyMatch(customer -> customer.getEmail().equals(email));
    }
}
