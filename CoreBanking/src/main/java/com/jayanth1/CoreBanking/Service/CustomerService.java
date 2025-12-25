package com.jayanth1.CoreBanking.Service;

import com.jayanth1.CoreBanking.Entity.Customer;
import com.jayanth1.CoreBanking.Exception.CustomerNotFoundException;
import com.jayanth1.CoreBanking.Repository.CustomerRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepo repo;

    public List<Customer> getAllCustomers(){
        return repo.findAll();
    };

    public Customer getCustomerById(Long id){
        log.info("Getting customer");
       return repo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

      public void createCustomer(Customer customer){
          repo.save(customer);
      }
      public Customer updateCustomerById(Long id, Customer updatedCustomer){
          Customer existingCustomer =
                  repo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));

          existingCustomer.setName(updatedCustomer.getName());
          existingCustomer.setMobile(updatedCustomer.getMobile());
          existingCustomer.setKYC(updatedCustomer.getKYC());

          return repo.save(existingCustomer);
      }

    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }
}
