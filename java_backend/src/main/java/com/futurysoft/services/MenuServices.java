package com.futurysoft.services;

import com.futurysoft.dataTypeDefinition.MenuServicesInterface;
import com.futurysoft.entities.Menu;
import com.futurysoft.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServices implements MenuServicesInterface {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu createNewMenu(Menu newMenuObject) {
        return this.menuRepository.save(newMenuObject);
    }

    @Override
    public List<Menu> findAllMenus() {
        return this.menuRepository.findAll();
    }


    @Override
    public Optional<Menu> findMenuById(Long idOfMenuToFind) {
        return this.menuRepository.findById(idOfMenuToFind);
    }

    @Override
    public Menu updateMenuById(Long idOfMenuToUpdate, Menu updatedMenuObject) {
        // return this.menuRepository.save(updatedMenuObject);
        return updatedMenuObject;
    }

    @Override
    public void deleteMenuById(Long idOfMenuToDelete) {
        this.menuRepository.deleteById(idOfMenuToDelete);
    }
}
