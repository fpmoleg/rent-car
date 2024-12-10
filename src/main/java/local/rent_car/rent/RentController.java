package local.rent_car.rent;

import local.rent_car.car.Car;
import local.rent_car.car.CarRepository;
import local.rent_car.rent.data.RentData;
import local.rent_car.user.User;
import local.rent_car.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RentController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/rent", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Rent> rent(@RequestBody RentData rentData) {
        List<Car> cars = carRepository.findOneByNumber(rentData.getCarNumber());
        List<User> users = userRepository.findOneByDriverLicence(rentData.getDriverLicence());

        if (cars.isEmpty() || users.isEmpty()) {
            throw new IllegalArgumentException("Car or User cannot be empty");
        }

        Rent rent = new Rent();

        rent.setCar(cars.getFirst());
        rent.setUser(users.getFirst());
        rent.setRentPeriod(rentData.getRentPeriod());
        rent.setPrice(rentData.getRentPrice());
        rent.setStartDate(rentData.getRentDate());
        rentRepository.save(rent);

        return ResponseEntity.ok(rent);
    }

    @PostMapping(value = "/rent/{id}/reject/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rent> reject(@PathVariable Long id, @RequestBody String rejectReason) {
        Optional<Rent> entity = rentRepository.findById(id);

        return entity.map(value -> {
            value.setHasRejected(true);
            value.setComments(rejectReason);
            rentRepository.save(value);

            return ResponseEntity.ok(value);
        }).orElseThrow(() -> new IllegalArgumentException("Rent not found for ID " + id));
    }
}
