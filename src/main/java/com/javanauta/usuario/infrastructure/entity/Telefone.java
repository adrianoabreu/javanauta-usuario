package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero",length = 10)
    private String numero;
    @Column(name = "ddd",length = 3)
    private String ddd;
    @Column(name = "usuario_id")
    private Long usuarioId;

}
