package com.example.tarefasapi.controllers;

import com.example.tarefasapi.models.TarefasModel;
import com.example.tarefasapi.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

    @Autowired
    private TarefasService tarefasService;


    @GetMapping()
    public List<TarefasModel> getAllTarefas() {
     return tarefasService.getAllTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefasModel> getTarefaById(@PathVariable Long id) {
        TarefasModel tarefaEncontrada = tarefasService.getTarefaById(id);

        if (tarefaEncontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tarefaEncontrada, HttpStatus.OK);
    }

    @PostMapping
    public TarefasModel salvarTarefa(@RequestBody TarefasModel tarefa) {
        TarefasModel novaTarefa = tarefasService.salvarTarefa(tarefa);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED).getBody();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefasModel> atualizarTarefa(@PathVariable Long id, @RequestBody TarefasModel tarefaAtualizada) {
       TarefasModel tarefaExistente = tarefasService.getTarefaById(id);
       tarefaExistente.setNome(tarefaAtualizada.getNome());
       TarefasModel tarefasModel = tarefasService.salvarTarefa(tarefaExistente);

        return new ResponseEntity<>(tarefasModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTarefa(@PathVariable Long id) {
        tarefasService.deletarTarefa(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
