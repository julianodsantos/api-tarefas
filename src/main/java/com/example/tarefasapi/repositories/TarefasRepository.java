package com.example.tarefasapi.repositories;

import com.example.tarefasapi.models.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {
}
