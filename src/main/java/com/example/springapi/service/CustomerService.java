package com.example.springapi.service;

import com.example.springapi.dto.CustomerRequestDto;
import com.example.springapi.dto.CustomerResponseDto;
import com.example.springapi.exception.CustomerNotFoundException;
import com.example.springapi.model.Customer;
import com.example.springapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerResponseDto get(Long id){
        Customer customer=this.customerRepository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);
        return modelMapper.map(customer,CustomerResponseDto.class);
    }

    public CustomerResponseDto create(CustomerRequestDto customerRequestDto){
        Customer customer=modelMapper.map(customerRequestDto,Customer.class);
        final Customer save=this.customerRepository.save(customer);
        return modelMapper.map(save,CustomerResponseDto.class);
    }

    public CustomerResponseDto update(Long id,CustomerRequestDto customerRequestDto){
      Customer customer=this.customerRepository.findById(id)
              .orElseThrow(()->new CustomerNotFoundException());
      modelMapper.map(customerRequestDto,customer);
      final Customer update=this.customerRepository.save(customer);
      return modelMapper.map(update,CustomerResponseDto.class);
    }

    public void delete(Long id){
        Customer customer=this.customerRepository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);
        this.customerRepository.delete(customer);
    }


}
