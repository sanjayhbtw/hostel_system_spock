INSERT INTO students (name) values ('joe');

DELETE FROM students WHERE id != 1;


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

DELETE FROM rooms WHERE id != 1;


INSERT INTO hostels (
    room_id,
    student_id,
    monthly_charges
) values (
    1,
    1,
    2000
);

DELETE FROM hostels WHERE id != 1;