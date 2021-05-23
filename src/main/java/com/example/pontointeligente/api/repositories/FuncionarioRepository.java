package com.example.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<FuncionarioRepository, Long> {

    FuncionarioRepository findByCpf(String cpf);
    FuncionarioRepository findByEmail(String email);
    FuncionarioRepository findByCpfOrEmail(String cpf, String email);

}
