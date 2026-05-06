package com.tienda.products.controller;

import com.tienda.products.dto.MenuOptionResponse;
import com.tienda.products.service.MenuService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService service;

    public MenuController(MenuService service) {
        this.service = service;
    }

    // ✅ Obtener opciones de menú por rol
    @GetMapping("/{id_rol}")
    public List<MenuOptionResponse> getByRol(@PathVariable("id_rol") Integer idRol) {
        return service.getByRol(idRol);
    }
}