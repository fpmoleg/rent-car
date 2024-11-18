package local.rent_car.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findOneByDriverLicence(String driverLicence);
    List<User> findOneByFullName(String fullName);
}
