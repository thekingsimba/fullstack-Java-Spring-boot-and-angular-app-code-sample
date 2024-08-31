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
    public Menu updateMenuById(Menu previewMenuObject, Menu updatedMenuObject) {
        previewMenuObject.setMenuName(updatedMenuObject.getMenuName());
        previewMenuObject.setIngredients(updatedMenuObject.getIngredients());
        previewMenuObject.setChiefId(updatedMenuObject.getChiefId());
        previewMenuObject.setPrice(updatedMenuObject.getPrice());
        previewMenuObject.setImageUrl(updatedMenuObject.getImageUrl());
        return menuRepository.save(previewMenuObject);
    }

    @Override
    public boolean deleteMenuById(Long idOfMenuToDelete) {
        if (menuRepository.existsById(idOfMenuToDelete)) {
            menuRepository.deleteById(idOfMenuToDelete);
            return true;
        } else {
            return false;
        }
    }
}
