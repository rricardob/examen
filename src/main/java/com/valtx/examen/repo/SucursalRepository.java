package com.valtx.examen.repo;

import com.valtx.examen.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, String> {

}