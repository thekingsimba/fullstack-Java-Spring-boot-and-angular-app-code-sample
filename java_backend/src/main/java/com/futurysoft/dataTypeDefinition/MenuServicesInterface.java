package com.futurysoft.dataTypeDefinition;

import com.futurysoft.entities.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuServicesInterface {

    Menu createNewMenu(Menu newMenuObject);

    List<Menu> findAllMenus();

    Optional<Menu> findMenuById(Long idOfMenuToFind);

    Menu updateMenuById(Long idOfMenu, Menu updatedMenuObject);

    void deleteMenuById(Long idOfMenuToDelete);
}
