package com.proyect.proyect.Models;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class UsuariosModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false) 
    private Long id;
    
    @Column(unique = true, nullable = false, length = 120)
    private String nombre;

    @Column(unique = true, nullable = false, length = 120)
    private String email;

    @Column(nullable = false)
    private Integer prioridad;

    
}

