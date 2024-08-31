package com.futurysoft.controllers;

import java.util.List;
import java.util.Optional;

import com.futurysoft.services.MenuServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.futurysoft.entities.Menu;

import static com.futurysoft.constant.Constant.API_V1;

@RestController
@RequestMapping(path = API_V1 + "menu")
public class MenuController {

    @Autowired
    private MenuServices menuServices;

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenu() {
        List<Menu> allMenu = this.menuServices.findAllMenus();
        return new ResponseEntity(allMenu, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Menu>> getOneMenu(@PathVariable("id") long id) {
        Optional<Menu> menuFound = menuServices.findMenuById(id);
        if (menuFound == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(menuFound, HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Menu> createNewMenu(@RequestBody Menu menuObject) {
        Menu newMenuCreated = this.menuServices.createNewMenu(menuObject);
        return new ResponseEntity<>(newMenuCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable("id") long id) {
        boolean deleted =  this.menuServices.deleteMenuById(id);
        if (deleted){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
