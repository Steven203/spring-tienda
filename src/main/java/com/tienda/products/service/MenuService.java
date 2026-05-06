package com.tienda.products.service;

import com.tienda.products.dto.MenuOptionResponse;

import java.util.List;

public interface MenuService {

    List<MenuOptionResponse> getByRol(Integer idRol);
}