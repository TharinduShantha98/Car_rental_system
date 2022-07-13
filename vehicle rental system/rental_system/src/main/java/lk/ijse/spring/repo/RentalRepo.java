package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.ws.Service;
import java.sql.Date;
import java.util.List;

public interface RentalRepo extends JpaRepository<Rental, String> {


    List<Rental> findRentalByRentalDate(Date date);
    List<Rental> findRentalByReturnDate(Date date);
    Rental findTopByOrderByRentalIdDesc();





}
