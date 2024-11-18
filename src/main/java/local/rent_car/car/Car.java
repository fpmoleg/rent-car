package local.rent_car.car;

import jakarta.persistence.*;
import local.rent_car.rent.Rent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "car")
@NoArgsConstructor
public class Car {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @Getter
    @Column(name = "model")
    private String model;

    @Setter
    @Getter
    @Column(name = "number")
    private String number;

    @OneToMany(mappedBy = "car")
    @PrimaryKeyJoinColumn
    private List<Rent> rents;

    public Car(String model, String number) {
        this.model = model;
        this.number = number;
    }
}
