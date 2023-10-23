package com.futurysoft.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.futurysoft.models.Menu;
import com.futurysoft.repositories.MenuRepository;

import static com.futurysoft.constant.Constant.API_V1;

@RestController
@RequestMapping(path = API_V1 + "menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Menu> getOneMenu(@PathVariable("id") long id) {
        Optional<Menu> menuFound = menuRepository.findById(id);
        return menuFound;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createNewMenu(@RequestBody Menu menu) {
        menuRepository.save(menu);
    }

}
