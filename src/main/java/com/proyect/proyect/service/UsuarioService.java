package com.proyect.proyect.service;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.proyect.Models.UsuariosModels;
import com.proyect.proyect.repositories.UsuarioRepository;

@Service

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ArrayList<UsuariosModels> obtenerUsuarios(){
        return (ArrayList<UsuariosModels>) usuarioRepository.findAll();
    }

    @SuppressWarnings("null")
    public UsuariosModels guardarUsuario(UsuariosModels usuario){
        return usuarioRepository.save(usuario);
    }

    //Metodo obtener por Id
    @SuppressWarnings("null")
    public Optional<UsuariosModels> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    //obtener por prioridad
    public ArrayList<UsuariosModels> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    // eliminar el usuario pasando el id
    @SuppressWarnings("null")
    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
