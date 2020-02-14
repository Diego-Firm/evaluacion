package com.itdata.evaluacion.services;

import com.itdata.evaluacion.entity.CustomerEntity;
import com.itdata.evaluacion.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomerRestController {

    @Resource CustomerRepository customerRepository;

    @GetMapping("customer")
    public List<CustomerEntity> customers()
    {
        return customerRepository.findAll();
    }
}
