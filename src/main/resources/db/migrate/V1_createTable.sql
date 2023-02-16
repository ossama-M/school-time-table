

CREATE TABLE school (
  id INTEGER NOT NULL AUTO_INCREMENT,
  school_name varchar(128) unique NOT NULL ,
  Location varchar(128) DEFAULT NULL ,
  PRIMARY KEY (id)
) ;
 
CREATE TABLE subject (
  id INTEGER NOT NULL AUTO_INCREMENT,
  subject_name varchar(128) unique NOT NULL ,
  duration varchar(5) DEFAULT NULL,
  
  PRIMARY KEY (id)
) ;

CREATE TABLE gradeWClasses (
  id INTEGER NOT NULL AUTO_INCREMENT,
  grade char (1)  NOT NULL ,
  class char (1) NOT NULL ,
  school_id INTEGER  NOT NUll,
  PRIMARY KEY (id),
    foreign key (school_id) references school (id) ON DELETE cascade ON UPDATE cascade,
  CONSTRAINT CHK_class CHECK (class in ('A','B','C','D','E')),
  CONSTRAINT CHK_grade CHECK (grade in ('1','2','3','4','5')),
  CONSTRAINT unique_s_g_c UNIQUE (grade, class, school_id)
) ;

CREATE TABLE subject_class (
  id INTEGER NOT NULL AUTO_INCREMENT,
  gradeWClasses_id INTEGER NOT NULL,
  subject_id INTEGER NOT NULL,
  time time NOT NULL,
  day_of_week varchar(11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT CHK_day CHECK (day_of_week in ('Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday')),
  CONSTRAINT unique_Lecture UNIQUE (gradeWClasses_id, subject_id,`time`,`day_of_week`),
  
  FOREIGN KEY (gradeWClasses_id) REFERENCES gradeWClasses (id) ON DELETE cascade ON UPDATE cascade,
  
  FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE cascade ON UPDATE cascade
  
);







