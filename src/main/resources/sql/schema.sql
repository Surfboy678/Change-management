

CREATE TABLE document(
id SERIAL NOT NULL ,
type varchar(100) NULL,
PRIMARY KEY (id)
);

CREATE TABLE question(
id  SERIAL NOT NULL ,
content varchar(500) NULL,
answer_id INT NULL,
PRIMARY KEY (id)
);

CREATE TABLE document_questions(
id_document INT NOT NULL ,
id_question INT NOT NULL ,
PRIMARY KEY (id_document, id_question),
FOREIGN KEY (id_document) REFERENCES document(id),
FOREIGN KEY (id_question) REFERENCES question(id)
);

CREATE TABLE answer(
id  SERIAL NOT NULL,
id_document INT NOT NULL ,
id_question INT NOT NULL ,
content VARCHAR(500) NULL,
FOREIGN KEY (id_document) REFERENCES document(id),
FOREIGN KEY (id_question) REFERENCES question(id)
);

INSERT INTO document(id, type)
VALUES
(1, 'NORMAL'),
(2, 'EMERGENCY'),
(3, 'DAILY_ROUTINES');

INSERT INTO question(id, content, answer_id)
VALUES
(2, 'Czy praca planowa została przetestowana'),
(3, 'Czy znany jest rollback w przypadku niepowodzenia pracy');

INSERT INTO question(id, content, answer_id)
VALUES
(1, 'Czy aplikacja jest komercyjna?', 1);

INSERT INTO document_questions(id_document, id_question)
VALUES
(1,1),
(1,2),
(1,3);

INSERT INTO answer(id, id_document, id_question, content)
VALUES
(1,1,1, 'TAK');