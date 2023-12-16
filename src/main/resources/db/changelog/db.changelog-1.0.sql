create table if not exists weather_data (
    id bigserial not null,
    location varchar(60) not null,
    temperature int not null,
    wind_meters_ph float not null,
    pressure_mb float not null,
    humidity float not null,
    weather_condition varchar(25) not null,
    created_at timestamp,
    constraint weather_data_pkey primary key(id)
    );
