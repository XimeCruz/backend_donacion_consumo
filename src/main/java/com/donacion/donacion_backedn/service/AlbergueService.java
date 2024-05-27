package com.donacion.donacion_backedn.service;


import com.donacion.donacion_backedn.model.Albergue;
import com.donacion.donacion_backedn.repository.AlbergueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbergueService {


    @Autowired
    private AlbergueRepository albergueRepository;

    public Albergue getById(Long id) {
        return albergueRepository
                .findById(id)
                .orElse(null);
    }

    public List<Albergue> getAlbergues() {
        return albergueRepository.findAll();
    }

    public void guardarAlbergue(Albergue albergue) {
        albergueRepository.save(albergue);
    }

    public void eliminarAlbergue(Long id) {
        albergueRepository.deleteById(id);
    }


    public void actualizarProducto(Albergue albergue) {

        Albergue albergueActualizar = albergueRepository
                .findById(albergue.getId())
                .get();

        albergueActualizar.setNombre(albergue.getNombre());
        albergueActualizar.setDireccion(albergue.getDireccion());

        albergueRepository.save(albergueActualizar);
    }


    public Page<Albergue> getAlbergues(Pageable pageable) {

        return albergueRepository.findAll(pageable);
    }

    public void updateAlbergue(Albergue albergue) {
        albergueRepository.save(albergue);
    }
    
    
}
