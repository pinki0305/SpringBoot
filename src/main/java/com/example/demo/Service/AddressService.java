package com.example.demo.Service;

import com.example.demo.dto.AddressRequest;
import com.example.demo.entitites.Address;

public interface AddressService
{
    Address saveAddress(AddressRequest addresRequest);
    String  updateAddress(int id,String street1,String street2,String city);
}
