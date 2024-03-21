package com.proyect.proyect.Controllers;
import com.proyect.proyect.service.UsuarioService;
import com.proyect.proyect.Models.UsuariosModels;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuariosModels> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuariosModels guardarUsuario(@RequestBody UsuariosModels usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    //obtener usuario por id 
    @GetMapping(path = "/{id}")
    public Optional<UsuariosModels> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuariosModels> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer Prioridad){
        return this.usuarioService.obtenerPorPrioridad(Prioridad);
    }

    //peticion http eliminar usuario

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id " + id;
        }else{
            return "No se pudo eliminar el usuario con id " + id;
        }
    }

}


