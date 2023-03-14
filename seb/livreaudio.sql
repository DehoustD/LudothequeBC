DROP DATABASE IF EXISTS livreaudio;
CREATE DATABASE livreaudio;

USE livreaudio;

/* Création de la table theme */
DROP TABLE IF EXISTS Theme;
CREATE TABLE Theme (
Id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
Libelle VARCHAR(50) NOT NULL);

/* Création de la table auteur */
DROP TABLE IF EXISTS Auteur;
CREATE TABLE Auteur(
Id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
Nom VARCHAR(50) NOT NULL,
Prenom VARCHAR(50) NOT NULL,
DateNaissance DATE DEFAULT);

/* Création de la table Livre */
DROP TABLE IF EXISTS Livre (
CREATE TABLE Livre;
Id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
Titre VARCHAR(1000) NOT NULL,
Langue VARCHAR(50) NOT NULL,
AnneePublication INT(4) NOT NULL,
IdTheme INT(11) UNSIGNED NOT NULL,
FOREIGN KEY (IdTheme) REFERENCES Theme(Id)); 

/* Création de la table AuteurLivre (si un livre est écrit par plusieurs auteurs.) */

DROP TABLE IF EXISTS AuteurLivre;
CREATE TABLE AuteurLivre (
 IdAuteur INT(11) UNSIGNED NOT NULL,
 IdLivre INT(11) UNSIGNED NOT NULL,
 PRIMARY KEY (IdAuteur, IdLivre),
 FOREIGN KEY (IdAuteur) REFERENCES Auteur(Id),
 FOREIGN KEY (IdLivre) REFERENCES Livre(Id));