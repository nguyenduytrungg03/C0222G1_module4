package com.codegym.furama.controller.customer;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.service.customer.ICustomerService;
import com.codegym.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/")
    public String showHome(){
        return "header";
    }

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList() {
        return this.iCustomerTypeService.findAll();
    }

    @GetMapping("/customer")
    public String getAllStudent(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Customer> list = iCustomerService.getAll(PageRequest.of(page,2));
        model.addAttribute("listCustomer", list);
        model.addAttribute("customer",new Customer());
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomer", iCustomerService.findAll());
        return "customer/create";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("customer/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        iCustomerService.remove(id);
        return "redirect:/customer";
    }

    @GetMapping("customer/edit/{id}")
    public String goFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        List<CustomerType> customerTypeList =iCustomerService.customerType();
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/edit";
    }

    @PostMapping("/customer /edit")
    public String edit(Customer customer) {
        iCustomerService.update(customer);
        return "redirect:/customer";
    }

}
