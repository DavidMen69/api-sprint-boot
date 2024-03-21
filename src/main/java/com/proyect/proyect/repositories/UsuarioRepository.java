package com.proyect.proyect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyect.proyect.Models.UsuariosModels;
import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuariosModels, Long> {
    public abstract ArrayList<UsuariosModels> findByPrioridad(Integer prioridad);
}
