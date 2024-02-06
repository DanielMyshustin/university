CREATE TABLE student_group
(
    group_id   SERIAL PRIMARY KEY,
    group_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE student
(
    student_id    SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    login     VARCHAR(50) NOT NULL UNIQUE,
    password  VARCHAR(100) NOT NULL,
    group_id INTEGER REFERENCES student_group (group_id)
);

CREATE TABLE teacher
(
    teacher_id    SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    login     VARCHAR(50) NOT NULL UNIQUE,
    password  VARCHAR(100) NOT NULL,
    room    VARCHAR(10) NOT NULL
);

CREATE TABLE course
(
    course_id   SERIAL PRIMARY KEY,
    course_name VARCHAR(50) UNIQUE,
    teacher     INTEGER REFERENCES teacher (teacher_id)
);

CREATE TABLE time_schedule
(
    time_schedule_id SERIAL PRIMARY KEY,
    time_period     VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE schedule
(
    schedule_id     SERIAL PRIMARY KEY,
    group_id        INTEGER NOT NULL REFERENCES student_group (group_id),
    schedule_date   DATE,
    course_id       INTEGER NOT NULL REFERENCES course (course_id),
    time_schedule_id INTEGER NOT NULL REFERENCES time_schedule (time_schedule_id)
);