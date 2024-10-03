package com.example.POS.Repository;
import com.example.POS.Model.VentasModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VentasRepository extends JpaRepository<VentasModel , Long >  {
}
