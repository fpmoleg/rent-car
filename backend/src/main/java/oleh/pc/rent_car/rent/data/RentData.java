package oleh.pc.rent_car.rent.data;

import lombok.Getter;
import lombok.Setter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class RentData {
    private String carNumber;
    private String driverFullName;
    private String driverLicence;
    private Date rentDate;
    private Integer rentPeriod;
    private Float rentPrice;

    public void setRentDate(String rentDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = sdf.parse(rentDate);
    }
}
