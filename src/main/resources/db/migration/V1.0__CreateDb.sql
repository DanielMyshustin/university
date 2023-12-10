CREATE TABLE "Group" (
                         groupId SERIAL PRIMARY KEY,
                         groupName VARCHAR(255)
);

CREATE TABLE "User" (
                      userId SERIAL PRIMARY KEY,
                      firstName VARCHAR(255),
                      lastName VARCHAR(255),
                      login VARCHAR(255),
                      password VARCHAR(255),
                      role VARCHAR(20)
);

CREATE TABLE Student (
                         userId INTEGER PRIMARY KEY REFERENCES "User"(userId),
                         "group" INTEGER REFERENCES "Group"(groupId),
                         CONSTRAINT fk_student_user FOREIGN KEY (userId) REFERENCES "User"(userId)
);

CREATE TABLE Teacher (
                         userId INTEGER PRIMARY KEY REFERENCES "User"(userId),
                         course INTEGER,
                         room INTEGER,
                         CONSTRAINT fk_teacher_user FOREIGN KEY (userId) REFERENCES "User"(userId)
);

CREATE TABLE Course (
                        courseId SERIAL PRIMARY KEY,
                        courseName VARCHAR(255),
                        teacher INTEGER,
                        CONSTRAINT fk_course_teacher FOREIGN KEY (teacher) REFERENCES Teacher(userId)
);

ALTER TABLE Teacher
    ADD FOREIGN KEY (course) REFERENCES Course(courseId);

CREATE TABLE TimeSchedule (
                              timeScheduleId SERIAL PRIMARY KEY,
                              timePeriod VARCHAR(255)
);

CREATE TABLE Schedule (
                          scheduleId SERIAL PRIMARY KEY,
                          groupId INTEGER REFERENCES "Group"(groupId),
                          scheduleDate DATE,
                          courseId INTEGER REFERENCES Course(courseId),
                          timeScheduleId INTEGER REFERENCES TimeSchedule(timeScheduleId)
);