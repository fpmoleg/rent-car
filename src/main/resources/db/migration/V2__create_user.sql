CREATE TABLE IF NOT EXISTS users (
    id             int auto_increment primary key,
    full_name      varchar(50) not null,
    driver_licence varchar(15) not null,
    constraint users_driver_licence_unq unique (driver_licence)
)