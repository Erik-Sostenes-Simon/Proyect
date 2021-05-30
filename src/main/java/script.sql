CREATE DATABASE advisory_administrator;

CREATE TABLE Managers(
                         idManager VARCHAR(20) NOT NULL PRIMARY KEY,
                         nameManger VARCHAR(50) ,
                         groupM VARCHAR(1) ,
                         grade INT
);
--INSERT INTO Students(idStudent, nameStudent, reasonForDisapproval, totalAverage, canalization, groupS, grade, idManager) VALUES('19011125', 'Erik Sostenes Simon', 'No entrego los reportes', 55, TRUE, 'A', 4, 'ABCD');
--50.0, TRUE, 'A', 4, 'ABCD');
CREATE TABLE Students(
                         idStudent VARCHAR(30) NOT NULL PRIMARY KEY,
                         nameStudent VARCHAR(45) ,
                         reasonForDisapproval VARCHAR(150),
                         totalAverage DOUBLE,
                         canalization BOOL ,
                         groupS VARCHAR(1),
                         grade INT,
                         idManager VARCHAR(20),
                         FOREIGN KEY(idManager) REFERENCES  Managers(idManager)
);
-- -- INSERT INTO Courses(idCourse, nameCourse, nameManager, evaluationUnit, keyGroup, periodC, qualification, idStudent, idManager) VALUES('BD', 'Base de Datos', 'Hector', 4, 'CuartoA', 'Cuarto', 50, '19011125', 'ABCD');
CREATE TABLE Courses(
                        keyCourse INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        idCourse VARCHAR(20),
                        nameCourse VARCHAR(45),
                        nameManager VARCHAR(60),
                        evaluationUnit INT,
                        keyGroup VARCHAR(30),
                        periodC VARCHAR(10),
                        qualification DOUBLE,
                        idStudent VARCHAR(30),
                        idManager VARCHAR(20),
                        FOREIGN KEY(idStudent) REFERENCES Students(idStudent),
                        FOREIGN KEY(idManager) REFERENCES Managers(idManager)
);
CREATE TABLE ManagersHasCourses(
                                   idManagerHasCourse INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                   idManager VARCHAR(20),
                                   keyCourse INT NOT NULL,
                                   FOREIGN KEY(idManager) REFERENCES  Managers(idManager),
                                   FOREIGN KEY(keyCourse) REFERENCES Courses(keyCourse)
);

----INSERT INTO Assists(nameAssistance, idStudent) VALUES('Asistencia en Servicio Social', '19011125');
CREATE TABLE Assists(
                            idAssistance INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            assistanceInAcademicCounseling VARCHAR(50),
                            psychologyAssistance VARCHAR(50),
                            medicalServiceAssistance VARCHAR(50),
                            assistanceInSocialService VARCHAR(50),
                            idStudent VARCHAR(30),
                            FOREIGN KEY (idStudent) REFERENCES Students(idStudent)
);