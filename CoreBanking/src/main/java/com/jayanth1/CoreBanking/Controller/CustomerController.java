    package com.jayanth1.CoreBanking.Controller;

    import com.jayanth1.CoreBanking.Entity.Customer;
    import com.jayanth1.CoreBanking.Service.CustomerService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/customers")
    @RequiredArgsConstructor
    public class CustomerController {

        private final CustomerService service;

            @GetMapping("/")
            public List<Customer> geatAllCustomers(){
                return service.getAllCustomers();
            }


            @GetMapping("/{id}")
            public Customer getCustomer(@PathVariable  Long id){
                return service.getCustomerById(id);
        }
            @PostMapping()
            public void createCustomer(@RequestBody Customer customer){
                service.createCustomer(customer);
            }

            @PutMapping("/{id}")
            public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
                service.updateCustomerById(id,customer);
            }
            @DeleteMapping("/{id}")
            public void deleteCustomer(@PathVariable Long id){
                service.deleteCustomer(id);
            }
    }
