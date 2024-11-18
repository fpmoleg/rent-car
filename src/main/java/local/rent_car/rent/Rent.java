package local.rent_car.rent;

import jakarta.persistence.*;
import local.rent_car.car.Car;
import local.rent_car.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Entity
@Table(name = "rent")
@NoArgsConstructor
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne()
    @MapsId
    @Setter
    @JoinColumn(name = "car_id", nullable=false)
    private Car car;

    @ManyToOne
    @MapsId
    @Setter
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @Column(name = "start_date")
    private Date startDate;

    @Setter
    @Column(name = "rent_period")
    private Integer rentPeriod;

    @Setter
    @Column(name = "price")
    private Float price;

    @Setter
    @Column(name = "has_rejected")
    private Boolean hasRejected;

    @Setter
    @Column(name = "comments")
    private String comments;
}
