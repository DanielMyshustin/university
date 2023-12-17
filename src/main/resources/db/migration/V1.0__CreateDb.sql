CREATE TABLE "group"
(
    group_id   SERIAL PRIMARY KEY,
    group_name VARCHAR(50) UNIQUE
);

CREATE TABLE "user"
(
    user_id    SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    login     VARCHAR(255) UNIQUE,
    password  VARCHAR(255),
    role      VARCHAR(20)
);

CREATE TABLE student
(
    user_id    INTEGER PRIMARY KEY REFERENCES "user" (user_id),
    group_id INTEGER REFERENCES "group" (group_id),
    CONSTRAINT fk_student_user FOREIGN KEY (user_id) REFERENCES "user" (user_id)
);
CREATE TABLE teacher
(
    user_id INTEGER PRIMARY KEY REFERENCES "user" (user_id),
    course INTEGER,
    room   INTEGER
);

CREATE TABLE course
(
    course_id   SERIAL PRIMARY KEY,
    course_name VARCHAR(255) UNIQUE,
    teacher    INTEGER
);

ALTER TABLE teacher
    ADD FOREIGN KEY (user_id) REFERENCES "user" (user_id);

ALTER TABLE course
    ADD FOREIGN KEY (teacher) REFERENCES teacher (user_id);

CREATE TABLE time_schedule
(
    time_schedule_id SERIAL PRIMARY KEY,
    time_period     VARCHAR(255) UNIQUE
);

CREATE TABLE schedule
(
    schedule_id     SERIAL PRIMARY KEY,
    group_id        INTEGER REFERENCES "group" (group_id),
    schedule_date   DATE,
    course_id       INTEGER REFERENCES course (course_id),
    time_schedule_id INTEGER REFERENCES time_schedule (time_schedule_id)
);