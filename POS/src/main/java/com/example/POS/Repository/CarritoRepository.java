package com.example.POS.Repository;
import com.example.POS.Model.CarritoModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CarritoRepository extends JpaRepository<CarritoModel , Long >  {
}
