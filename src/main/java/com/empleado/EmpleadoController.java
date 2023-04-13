package com.empleado;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")

public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public Employable crear(@RequestBody Employable empleado) {
        return empleadoService.crear(empleado);
    }
    @GetMapping("/{id}")
    public Employable crear(@PathVariable Integer id) {
        return empleadoService.FindByID(id);
    }

    @PutMapping("/{id}")
    public Employable actualizar(@PathVariable Integer id, @RequestBody Employable empleadoNuevo) {
        return empleadoService.actualizar(id, empleadoNuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        empleadoService.eliminar(id);
    }

    @GetMapping
    public List<SalarioHistorico> salarioHistoricoList(){
        return empleadoService.salarioHistoricoList();

    }

}
