INSERT INTO menu_options (id_rol, name, content)
SELECT * FROM (VALUES
    (1, 'dashboard',   'Dashboard'),
    (1, 'customers',   'Clientes'),
    (1, 'sales',       'Ventas'),
    (1, 'departments', 'Departamentos'),
    (1, 'reports',     'Reportes'),
    (1, 'users',       'Usuarios'),
    (1, 'log-out',     'Cerrar sesión'),
    (2, 'dashboard',   'Dashboard'),
    (2, 'customers',   'Clientes'),
    (2, 'sales',       'Ventas'),
    (2, 'log-out',     'Cerrar sesión'),
    (3, 'dashboard',   'Dashboard'),
    (3, 'departments', 'Departamentos'),
    (3, 'log-out',     'Cerrar sesión')
) AS datos(id_rol, name, content)
WHERE NOT EXISTS (SELECT 1 FROM menu_options);