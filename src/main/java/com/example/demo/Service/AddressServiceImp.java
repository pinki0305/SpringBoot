package com.example.demo.Service;

import com.example.demo.dto.AddressRequest;
import com.example.demo.entitites.Address;
import com.example.demo.entitites.IDNotFoundException;
import com.example.demo.entitites.User;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements AddressService
{
    @Autowired
    AddressRepository addressRepository;
    @Override
    public Address saveAddress(AddressRequest addresRequest) {
        Address a=new Address();
        a.setStreet1(addresRequest.getStreet1());
        a.setStreet2(addresRequest.getStreet1());
        a.setCity(addresRequest.getCity());
        Address address=addressRepository.save(a);
        return address;
    }
    @Override
    public String updateAddress(int id,String street1,String street2,String city) {

        Address response=addressRepository.findById(id);
        if(response !=null)
        {
            response.setId(id);

            response.setStreet1(street1);
            response.setStreet2(street2);
            response.setCity(city);
            addressRepository.save(response);
            return "Update Record";
        }
        else
        {
            throw new IDNotFoundException(id);

        }

    }
}
