package com.example.POS.Repository;

import com.example.POS.Model.CarritoProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoProductoRepository extends JpaRepository<CarritoProductoModel , Long >  {
}
