INSERT INTO "User" (firstname, lastname, login, password, role)
VALUES ('John', 'Doe', 'john.doe', 'password123', 'ROLE_USER'),
       ('Jane', 'Doe', 'jane.doe', 'securepass', 'ROLE_USER'),
       ('Admin', 'User', 'admin', 'adminpass', 'ROLE_ADMIN');

INSERT INTO timeschedule (timeperiod)
VALUES ('8:00-10:00'),
       ('10:10-12:10'),
       ('13:00-15:00'),
       ('15:10-17:10'),
       ('18:00-20:00');

