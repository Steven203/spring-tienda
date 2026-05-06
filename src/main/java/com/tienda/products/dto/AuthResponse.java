package com.tienda.products.dto;

public class AuthResponse {

    private String token;
    private String username;
    private Integer idRol;

    public AuthResponse(String token, String username, Integer idRol) {
        this.token = token;
        this.username = username;
        this.idRol = idRol;
    }

    public String getToken() { return token; }
    public String getUsername() { return username; }
    public Integer getIdRol() { return idRol; }
}