package com.futurysoft.smallrestorestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futurysoft.smallrestorestapi.models.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
