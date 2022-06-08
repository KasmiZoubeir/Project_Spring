DROP TABLE IF EXISTS materiel;

CREATE TABLE materiel
(
    id   INT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(250) NOT NULL,

    code VARCHAR(250) NOT NULL,

);
CREATE TABLE Utilisateur
(
    id_utilisateur   INT AUTO_INCREMENT PRIMARY KEY,

    username VARCHAR(250) NOT NULL,
    role VARCHAR(250) NOT NULL,
    Password VARCHAR(250) NOT NULL,

    

);


