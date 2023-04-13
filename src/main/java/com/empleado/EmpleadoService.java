package com.empleado;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;


    private final SalarioHistoricoRepository salarioHistoricoRepository;

    public Employable crear(Employable empleado) {
        return empleadoRepository.save(empleado);
    }

    public Employable FindByID(Integer id) {
        return empleadoRepository.findById(id).orElseThrow(()->new RuntimeException("does not exist"));
    }

    public Employable  actualizar(Integer id, Employable empleadoNuevo) {
        Employable  empleadoAntiguo = empleadoRepository.findById(id).orElse(null);
        if (empleadoAntiguo != null) {
            SalarioHistorico registroHistorico = new SalarioHistorico();
            registroHistorico.setEmployable(empleadoAntiguo);
            registroHistorico.setSalarioAntiguo(empleadoAntiguo.getSalario());
            registroHistorico.setSalarioNuevo(empleadoNuevo.getSalario());
            salarioHistoricoRepository.save(registroHistorico);

            BeanUtils.copyProperties(empleadoNuevo, empleadoAntiguo, "id");
            return empleadoRepository.save(empleadoAntiguo);
        }
        return null;
    }

    public void eliminar(Integer id) {
        empleadoRepository.deleteById(id);
    }

    public List<SalarioHistorico> salarioHistoricoList (){
        List<SalarioHistorico> list = new ArrayList<>();
        list = salarioHistoricoRepository.findAll();
        return list;

    }






}
