package com.futurysoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futurysoft.models.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
