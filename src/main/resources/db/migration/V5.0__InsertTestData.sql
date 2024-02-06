ALTER TABLE student_group
ADD COLUMN student_id INT;

ALTER TABLE student_group
ADD CONSTRAINT fk_student_group_student
FOREIGN KEY (student_id) REFERENCES student(student_id);