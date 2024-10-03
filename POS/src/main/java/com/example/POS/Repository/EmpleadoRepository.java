package com.example.POS.Repository;

import com.example.POS.Model.EmpleadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmpleadoRepository extends JpaRepository<EmpleadoModel ,Long >  {
}