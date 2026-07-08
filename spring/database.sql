CREATE DATABASE IF NOT EXISTS prova3;
USE prova3;

CREATE TABLE IF NOT EXISTS cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    nascimento DATE NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL
);

INSERT INTO cliente (nome, nascimento, cpf, endereco, telefone, email) VALUES
('Max Verstappen', '1997-09-30', '111.111.111-11', 'Red Bull Racing, Milton Keynes, UK', '+44 1234 567801', 'max.verstappen@f1.com'),
('Sergio Perez', '1990-01-26', '111.111.111-12', 'Red Bull Racing, Milton Keynes, UK', '+44 1234 567802', 'sergio.perez@f1.com'),
('Lewis Hamilton', '1985-01-07', '222.222.222-21', 'Mercedes AMG F1, Brackley, UK', '+44 1234 567803', 'lewis.hamilton@f1.com'),
('George Russell', '1998-02-15', '222.222.222-22', 'Mercedes AMG F1, Brackley, UK', '+44 1234 567804', 'george.russell@f1.com'),
('Charles Leclerc', '1997-10-16', '333.333.333-31', 'Scuderia Ferrari, Maranello, ITA', '+39 1234 567805', 'charles.leclerc@f1.com'),
('Carlos Sainz', '1994-09-01', '333.333.333-32', 'Scuderia Ferrari, Maranello, ITA', '+39 1234 567806', 'carlos.sainz@f1.com'),
('Lando Norris', '1999-11-13', '444.444.444-41', 'McLaren F1 Team, Woking, UK', '+44 1234 567807', 'lando.norris@f1.com'),
('Oscar Piastri', '2001-04-06', '444.444.444-42', 'McLaren F1 Team, Woking, UK', '+44 1234 567808', 'oscar.piastri@f1.com'),
('Fernando Alonso', '1981-07-29', '555.555.555-51', 'Aston Martin F1, Silverstone, UK', '+44 1234 567809', 'fernando.alonso@f1.com'),
('Lance Stroll', '1998-10-29', '555.555.555-52', 'Aston Martin F1, Silverstone, UK', '+44 1234 567810', 'lance.stroll@f1.com'),
('Pierre Gasly', '1996-02-07', '666.666.666-61', 'Alpine F1 Team, Enstone, UK', '+44 1234 567811', 'pierre.gasly@f1.com'),
('Esteban Ocon', '1996-09-17', '666.666.666-62', 'Alpine F1 Team, Enstone, UK', '+44 1234 567812', 'esteban.ocon@f1.com'),
('Alexander Albon', '1996-03-23', '777.777.777-71', 'Williams Racing, Grove, UK', '+44 1234 567813', 'alex.albon@f1.com'),
('Logan Sargeant', '2000-12-31', '777.777.777-72', 'Williams Racing, Grove, UK', '+44 1234 567814', 'logan.sargeant@f1.com'),
('Yuki Tsunoda', '2000-05-11', '888.888.888-81', 'Visa Cash App RB, Faenza, ITA', '+39 1234 567815', 'yuki.tsunoda@f1.com'),
('Daniel Ricciardo', '1989-07-01', '888.888.888-82', 'Visa Cash App RB, Faenza, ITA', '+39 1234 567816', 'daniel.ricciardo@f1.com'),
('Valtteri Bottas', '1989-08-28', '999.999.999-91', 'Kick Sauber, Hinwil, CHE', '+41 1234 567817', 'valtteri.bottas@f1.com'),
('Guanyu Zhou', '1999-05-30', '999.999.999-92', 'Kick Sauber, Hinwil, CHE', '+41 1234 567818', 'guanyu.zhou@f1.com'),
('Nico Hulkenberg', '1987-08-19', '101.010.101-01', 'Haas F1 Team, Kannapolis, USA', '+1 1234 567819', 'nico.hulkenberg@f1.com'),
('Kevin Magnussen', '1992-10-05', '101.010.101-02', 'Haas F1 Team, Kannapolis, USA', '+1 1234 567820', 'kevin.magnussen@f1.com');
