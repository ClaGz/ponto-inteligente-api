package com.example.pontointeligente.api.repositories;

import com.example.pontointeligente.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

    //Não precisa travar o banco de dados ;)
    @Transactional(readOnly = true)
    Empresa findByCnpj(String cnpj);
}
