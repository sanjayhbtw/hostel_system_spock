INSERT INTO students (name) values ('joe');

INSERT INTO rooms (
    occupancy_charges,
    room_charges,
    power_backup_charges,
    mess_charges
) values (
    2000,
    1500,
    1500,
    3000
);

INSERT INTO hostels (
    room_id,
    student_id,
    monthly_charges
) values (
    1,
    1,
    2000
);