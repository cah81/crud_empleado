package com.empleado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salario_historico")

public class SalarioHistorico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    //muchos empleados pueden tener un historico
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Employable employable;

    @Column(name = "salario_antiguo")
    private Double salarioAntiguo;


    @Column(name = "salario_nuevo")
    private Double salarioNuevo;



}
