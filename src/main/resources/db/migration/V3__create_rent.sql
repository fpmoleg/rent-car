CREATE TABLE IF NOT EXISTS rent (
    id           int auto_increment primary key,
    car_id       int           not null,
    user_id      int           not null,
    start_date   datetime      not null,
    rent_period  int           not null,
    price        float         null,
    has_rejected int default 0 not null,
    comments     text          null,
    constraint rent_car_id_fk foreign key (car_id) references car (id),
    constraint rent_user_id_fk foreign key (user_id) references users (id)
);