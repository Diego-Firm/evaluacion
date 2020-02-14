package com.itdata.evaluacion.controller;

import com.itdata.evaluacion.entity.AccountEntity;
import com.itdata.evaluacion.entity.CustomerEntity;
import com.itdata.evaluacion.repository.AccountRepository;
import com.itdata.evaluacion.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.sql.Date;

@Controller
public class MainController {

    @Resource
    CustomerRepository customerRepository;
    @Resource
    AccountRepository accountRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("customers",customerRepository.findAll());
        return "index";
    }

    @GetMapping("form")
    public String form(Model model)
    {
        model.addAttribute("customer", new CustomerEntity());
        return "form";
    }

    @PostMapping("form")
    public String form(CustomerEntity customerEntity)
    {
        customerEntity.setFecha(new Date(System.currentTimeMillis()));
        customerRepository.save(customerEntity);
//        model.addAttribute("customer", customerEntity);
        return "redirect:/";
    }
    @PostMapping("form/{id}")
    public String deleteform(@PathVariable int id)
    {


        customerRepository.deleteById(id);
//        customerEntity.setFecha(new Date(System.currentTimeMillis()));
//        customerRepository.save(customerEntity);
//        model.addAttribute("customer", customerEntity);
        return "redirect:/";
    }
    @GetMapping("accounts/{id}")
    public String accounts(@PathVariable int id, Model model)
    {
        model.addAttribute("accounts", customerRepository
                .findById(id).orElse(new CustomerEntity()).getAccountsByIdCustomer());
        model.addAttribute("id",id);
        return "accounts";
    }

    @GetMapping("account-form/{id}")
    public String accountForm(Model model, @PathVariable int id)
    {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCustomerIdCustomer(id);
        model.addAttribute("account", accountEntity);
        return "account-form";
    }
    @PostMapping("account-form")
    public String accountFormPost(AccountEntity accountEntity)
    {
        accountEntity.setFechaCreacion(new Date(System.currentTimeMillis()));
        accountEntity.setFechaModificacion(new Date(System.currentTimeMillis()));

        accountRepository.save(accountEntity);
//        model.addAttribute("account", accountEntity);
        return "redirect:accounts/"+accountEntity.getCustomerIdCustomer();
    }
    @PostMapping("account-form/{id}")
    public String deleteAccount(@PathVariable int id)
    {
        int idAccount = accountRepository.findById(id).orElse(new AccountEntity()).getCustomerIdCustomer();

        accountRepository.deleteById(id);
        return "redirect:/accounts/"+idAccount;
    }
}
