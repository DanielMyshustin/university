CREATE TABLE "group"
(
    group_id   SERIAL PRIMARY KEY,
    group_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE "user"
(
    user_id    SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    login     VARCHAR(50) NOT NULL UNIQUE,
    password  VARCHAR(100) NOT NULL,
    role      VARCHAR(20) NOT NULL
);

CREATE TABLE student
(
    user_id INTEGER PRIMARY KEY REFERENCES "user" (user_id),
    group_id INTEGER REFERENCES "group" (group_id)
);

CREATE TABLE teacher
(
    user_id INTEGER PRIMARY KEY REFERENCES "user" (user_id),
    room    VARCHAR(10) NOT NULL
);

CREATE TABLE course
(
    course_id   SERIAL PRIMARY KEY,
    course_name VARCHAR(50) UNIQUE,
    teacher     INTEGER NOT NULL REFERENCES teacher (user_id)
);

CREATE TABLE time_schedule
(
    time_schedule_id SERIAL PRIMARY KEY,
    time_period     VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE schedule
(
    schedule_id     SERIAL PRIMARY KEY,
    group_id        INTEGER NOT NULL REFERENCES "group" (group_id),
    schedule_date   DATE,
    course_id       INTEGER NOT NULL REFERENCES course (course_id),
    time_schedule_id INTEGER NOT NULL REFERENCES time_schedule (time_schedule_id)
);