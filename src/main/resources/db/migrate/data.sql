INSERT INTO school
(id,school_name,Location)VALUES('1', 'Ramses School', 'Cairo');
INSERT INTO school
(id,school_name,Location)VALUES('2', 'Royal School', 'Cairo');
INSERT INTO school
(id,school_name,Location)VALUES('3', 'Egyptian School', 'Alexandria');
INSERT INTO school
(id,school_name,Location)VALUES('4', 'Masr School', 'Fayyoum');



INSERT INTO subject
(id,subject_name,duration)VALUES ('1','Math','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('2','Arabic','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('3','English','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('4','Physics','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('5','Chemistry','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('6','Art','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('7','Games','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('8','Religion','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('9','geography','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('10','History','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('11','Math2','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('12','Math3','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('13','Math4','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('14','Math5','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('15','Arabic2','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('16','Arabic3','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('17','Arabic4','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('18','Arabic5','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('19','English2','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('20','English3','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('21','English4','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('22','English5','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('23','Physics2','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('24','Physics3','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('25','Physics4','02:00');
INSERT INTO subject
(id,subject_name,duration)VALUES ('26','Physics5','02:00');

INSERT INTO gradewclasses 
(grade,class,school_id) VALUES 
(1,'A',1),(1,'B',1),(1,'C',1),(1,'D',1),(1,'E',1),
(2,'A',1),(2,'B',1),(2,'C',1),(2,'D',1),(2,'E',1),
(3,'A',1),(3,'B',1),(3,'C',1),(3,'D',1),(3,'E',1),
(4,'A',1),(4,'B',1),(4,'C',1),(4,'D',1),(4,'E',1),
(5,'A',1),(5,'B',1),(5,'C',1),(5,'D',1),(5,'E',1),

(1,'A',2),(1,'B',2),(1,'C',2),(1,'D',2),(1,'E',2),
(2,'A',2),(2,'B',2),(2,'C',2),(2,'D',2),(2,'E',2),
(3,'A',2),(3,'B',2),(3,'C',2),(3,'D',2),(3,'E',2),
(4,'A',2),(4,'B',2),(4,'C',2),(4,'D',2),(4,'E',2),
(5,'A',2),(5,'B',2),(5,'C',2),(5,'D',2),(5,'E',2)
;

INSERT INTO subject_class
(gradeWClasses_id,subject_id,time,day_of_week) VALUES
(1,1,'08:00','Sunday'),
(1,2,'10:00','Sunday'),
(1,3,'12:00','Sunday'),
(1,4,'14:00','Sunday'),
(2,1,'08:00','Sunday'),
(2,2,'10:00','Sunday'),
(2,3,'12:00','Sunday'),
(2,4,'14:00','Sunday'),
(3,1,'08:00','Sunday'),
(3,2,'10:00','Sunday'),
(3,3,'12:00','Sunday'),
(3,4,'14:00','Sunday'),
(1,1,'08:00','Monday'),
(1,2,'10:00','Monday'),
(1,3,'12:00','Monday'),
(1,4,'14:00','Monday'),
(2,1,'08:00','Monday'),
(2,2,'10:00','Monday'),
(2,3,'12:00','Monday'),
(2,4,'14:00','Monday'),
(3,1,'08:00','Monday'),
(3,2,'10:00','Monday'),
(3,3,'12:00','Monday'),
(3,4,'14:00','Monday'),
(1,1,'08:00','Tuesday'),
(1,2,'10:00','Tuesday'),
(1,3,'12:00','Tuesday'),
(1,4,'14:00','Tuesday'),
(2,1,'08:00','Tuesday'),
(2,2,'10:00','Tuesday'),
(2,3,'12:00','Tuesday'),
(2,4,'14:00','Tuesday'),
(3,1,'08:00','Tuesday'),
(3,2,'10:00','Tuesday'),
(3,3,'12:00','Tuesday'),
(3,4,'14:00','Tuesday'),
(1,1,'08:00','Wednesday'),
(1,2,'10:00','Wednesday'),
(1,3,'12:00','Wednesday'),
(1,4,'14:00','Wednesday'),
(2,1,'08:00','Wednesday'),
(2,2,'10:00','Wednesday'),
(2,3,'12:00','Wednesday'),
(2,4,'14:00','Wednesday'),
(3,1,'08:00','Wednesday'),
(3,2,'10:00','Wednesday'),
(3,3,'12:00','Wednesday'),
(3,4,'14:00','Wednesday'),
(1,1,'08:00','Thursday'),
(1,2,'10:00','Thursday'),
(1,3,'12:00','Thursday'),
(1,4,'14:00','Thursday'),
(2,1,'08:00','Thursday'),
(2,2,'10:00','Thursday'),
(2,3,'12:00','Thursday'),
(2,4,'14:00','Thursday'),
(3,1,'08:00','Thursday'),
(3,2,'10:00','Thursday'),
(3,3,'12:00','Thursday'),
(3,4,'14:00','Thursday');

INSERT INTO subject_class
(gradeWClasses_id,subject_id,time,day_of_week) VALUES
(6,1,'08:00','Sunday'),
(6,2,'10:00','Sunday'),
(6,3,'12:00','Sunday'),
(6,4,'14:00','Sunday'),
(7,1,'08:00','Sunday'),
(7,2,'10:00','Sunday'),
(7,3,'12:00','Sunday'),
(7,4,'14:00','Sunday'),
(8,1,'08:00','Sunday'),
(8,2,'10:00','Sunday'),
(8,3,'12:00','Sunday'),
(8,4,'14:00','Sunday'),
(6,1,'08:00','Monday'),
(6,2,'10:00','Monday'),
(6,3,'12:00','Monday'),
(6,4,'14:00','Monday'),
(7,1,'08:00','Monday'),
(7,2,'10:00','Monday'),
(7,3,'12:00','Monday'),
(7,4,'14:00','Monday'),
(8,1,'08:00','Monday'),
(8,2,'10:00','Monday'),
(8,3,'12:00','Monday'),
(8,4,'14:00','Monday'),
(6,1,'08:00','Tuesday'),
(6,2,'10:00','Tuesday'),
(6,3,'12:00','Tuesday'),
(6,4,'14:00','Tuesday'),
(7,1,'08:00','Tuesday'),
(7,2,'10:00','Tuesday'),
(7,3,'12:00','Tuesday'),
(7,4,'14:00','Tuesday'),
(8,1,'08:00','Tuesday'),
(8,2,'10:00','Tuesday'),
(8,3,'12:00','Tuesday'),
(8,4,'14:00','Tuesday'),
(6,1,'08:00','Wednesday'),
(6,2,'10:00','Wednesday'),
(6,3,'12:00','Wednesday'),
(6,4,'14:00','Wednesday'),
(7,1,'08:00','Wednesday'),
(7,2,'10:00','Wednesday'),
(7,3,'12:00','Wednesday'),
(7,4,'14:00','Wednesday'),
(8,1,'08:00','Wednesday'),
(8,2,'10:00','Wednesday'),
(8,3,'12:00','Wednesday'),
(8,4,'14:00','Wednesday'),
(6,1,'08:00','Thursday'),
(6,2,'10:00','Thursday'),
(6,3,'12:00','Thursday'),
(6,4,'14:00','Thursday'),
(7,1,'08:00','Thursday'),
(7,2,'10:00','Thursday'),
(7,3,'12:00','Thursday'),
(7,4,'14:00','Thursday'),
(8,1,'08:00','Thursday'),
(8,2,'10:00','Thursday'),
(8,3,'12:00','Thursday'),
(8,4,'14:00','Thursday');




