package com.example.springapi.controller;

import com.example.springapi.dto.CustomerRequestDto;
import com.example.springapi.dto.CustomerResponseDto;
import com.example.springapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.get(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDto> createCustomer(
            @RequestBody CustomerRequestDto customerRequestDto){
        return ResponseEntity.ok(this.customerService.create(customerRequestDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponseDto> updateCusomer(@PathVariable("id") Long id
            ,@RequestBody CustomerRequestDto customerRequestDto){
        return ResponseEntity.ok(this.customerService.update(id,customerRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        this.customerService.delete(id);
    }

}
