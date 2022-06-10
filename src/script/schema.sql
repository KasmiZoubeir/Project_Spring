DROP TABLE IF EXISTS materiel;

DROP TABLE IF EXISTS Utilisateur;
CREATE TABLE materiel
(
     id_materiel INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(250) DEFAULT NULL, 
    user_username VARCHAR(250) DEFAULT NULL references utilisateur(username),
    name VARCHAR(250) NOT NULL,
    code VARCHAR(250) NOT NULL,
    disponible BOOLEAN DEFAULT true ,
    alloue BOOLEAN DEFAULT FALSE,
    duree varchar(250) NULL,
    CONSTRAINT user_id foreign key (user_id) references user (id_utilisateur)
);
CREATE TABLE Utilisateur
(
    id_utilisateur   INT AUTO_INCREMENT PRIMARY KEY,

    username VARCHAR(250) NOT NULL,
    role VARCHAR(250) NOT NULL,
    Password VARCHAR(250) NOT NULL,

    

);


