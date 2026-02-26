package com.nikki.bank.payload;

import java.util.List;

public class CustomerResponse {

    private List<CustomerDTO> customerDTOList;

    private Integer pageSize;
    private Integer pageNumber;
    private Long totalElements;
    private boolean lastPage;

    public CustomerResponse(List<CustomerDTO> customerDTOList, Integer pageSize, Integer pageNumber, Long totalElements, boolean lastPage) {
        this.customerDTOList = customerDTOList;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalElements = totalElements;
        this.lastPage = lastPage;
    }

    public CustomerResponse() {
    }

    public List<CustomerDTO> getCustomerDTOList() {
        return customerDTOList;
    }

    public void setCustomerDTOList(List<CustomerDTO> customerDTOList) {
        this.customerDTOList = customerDTOList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }
}
