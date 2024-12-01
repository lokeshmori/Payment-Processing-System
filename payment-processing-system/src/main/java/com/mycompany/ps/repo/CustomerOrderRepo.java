package com.mycompany.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.ps.entity.CustomerOrder;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, Integer> {

}
