CREATE TABLE IF NOT EXISTS car (
    id     int auto_increment primary key,
    model  varchar(50) not null,
    number varchar(10) not null,
    constraint car_number_unq unique (number)
)