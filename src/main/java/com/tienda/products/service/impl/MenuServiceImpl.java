package com.tienda.products.service.impl;

import com.tienda.products.dto.MenuOptionResponse;
import com.tienda.products.entity.MenuOption;
import com.tienda.products.exception.RolNotFoundException;
import com.tienda.products.repository.MenuOptionRepository;
import com.tienda.products.service.MenuService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    private final MenuOptionRepository repository;

    public MenuServiceImpl(MenuOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuOptionResponse> getByRol(Integer idRol) {
        List<MenuOption> options = repository.findByIdRol(idRol);

        if (options.isEmpty()) {
            throw new RolNotFoundException("No se encontraron opciones de menú para el rol " + idRol);
        }

        return options.stream()
                .map(this::toResponse)
                .toList();
    }

    private MenuOptionResponse toResponse(MenuOption m) {
        MenuOptionResponse r = new MenuOptionResponse();
        r.setName(m.getName());
        r.setContent(m.getContent());
        return r;
    }
}