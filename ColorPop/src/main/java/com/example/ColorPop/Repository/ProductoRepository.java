package com.example.ColorPop.Repository;

import com.example.ColorPop.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
