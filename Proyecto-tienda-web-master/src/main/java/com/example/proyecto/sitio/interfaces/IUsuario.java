package com.example.proyecto.sitio.interfaces;

import com.example.proyecto.sitio.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase define la interface IUsuario
 * de la cual es obtiene el crud para insertar en la base de datos
 * @version 23/11/2021
 */

@Repository
public interface IUsuario extends CrudRepository<Usuario, String> {

    Usuario findByCorreo(String correo);

}
