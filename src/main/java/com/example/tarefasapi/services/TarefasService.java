package com.example.tarefasapi.services;

import com.example.tarefasapi.models.TarefasModel;
import com.example.tarefasapi.repositories.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository tarefasRepository;

    public List<TarefasModel> getAllTarefas() {
        return tarefasRepository.findAll();
    }

    public TarefasModel getTarefaById(Long id) {
        return tarefasRepository.findById(id).orElse(null);
    }

    public TarefasModel salvarTarefa(TarefasModel tarefa) {
        return tarefasRepository.save(tarefa);
    }

    public void deletarTarefa(Long id) {
         tarefasRepository.deleteById(id);
    }
}
