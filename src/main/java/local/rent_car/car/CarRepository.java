package local.rent_car.car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findOneByNumber(String number);
    List<Car> findByModel(String number);
}
