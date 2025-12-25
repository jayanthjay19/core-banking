package com.jayanth1.CoreBanking.Service;

import com.jayanth1.CoreBanking.Entity.Customer;
import com.jayanth1.CoreBanking.Repository.CustomerRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerService {

    private final CustomerRepo repo;

    public List<Customer> getAllCustomers(){
        return repo.findAll();
    };

    public Customer getCustomerById(Long id){
       return repo.findById(id).orElseThrow(() -> new RuntimeException( "Customer not found with id!"+ id));
    }

      public void createCustomer(Customer customer){
           repo.save(customer);
      }
      public Customer updateCustomerById(Long id, Customer UpdatedCustomer){
          Customer existingCustomer =
                  repo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found!"));

          existingCustomer.setName(UpdatedCustomer.getName());
          existingCustomer.setMobile(UpdatedCustomer.getMobile());
          existingCustomer.setKYC(UpdatedCustomer.getKYC());

          return repo.save(existingCustomer);
      }

    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }
}
