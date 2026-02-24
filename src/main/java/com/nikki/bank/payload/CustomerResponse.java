package com.nikki.bank.payload;

import java.util.List;

public class CustomerResponse {

    private List<CustomerDTO> customerDTOList;

    public List<CustomerDTO> getCustomerDTOList() {
        return customerDTOList;
    }

    public void setCustomerDTOList(List<CustomerDTO> customerDTOList) {
        this.customerDTOList = customerDTOList;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customerDTOList=" + customerDTOList +
                '}';
    }
}
