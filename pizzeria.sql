
CREATE TABLE carte (
  id_plat INT PRIMARY KEY AUTO_INCREMENT,
  nom_plat VARCHAR(20) NOT NULL,
  description VARCHAR(255) NOT NULL,
  prix DOUBLE NOT NULL,
  disponibilite TINYINT(1) NOT NULL,
  image VARCHAR(255) NOT NULL
);


CREATE TABLE utilisateurs (
  id_user INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(20) NOT NULL,
  prenom VARCHAR(20) NOT NULL,
  telephone VARCHAR(30) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  profil VARCHAR(20) NOT NULL
);


CREATE TABLE carte_commande (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_user INT,
  id_plat INT,
  prix_total DOUBLE NOT NULL,
  statut VARCHAR(20),
  FOREIGN KEY (id_plat) REFERENCES carte(id_plat),
  FOREIGN KEY (id_user) REFERENCES utilisateurs(id_user)
);
