package oleh.pc.rent_car.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oleh.pc.rent_car.rent.Rent;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @Column(name = "full_name", length = 50)
    private String fullName;

    @Getter
    @Setter
    @Column(name = "driver_licence", length = 15)
    private String driverLicence;

    @OneToMany(mappedBy = "user")
    @PrimaryKeyJoinColumn
    private List<Rent> rents;

    public User(String fullName, String driverLicence) {
        this.fullName = fullName;
        this.driverLicence = driverLicence;
    }
}
