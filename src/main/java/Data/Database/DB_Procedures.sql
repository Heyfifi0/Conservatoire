-- Mettre les procédures ici
DELIMITER $
DELIMITER ;

-- Récupère le login de l'élève de la table ELEVE.
CREATE OR REPLACE PROCEDURE getLoginEleve(IN login CHAR(50))
BEGIN
    SELECT *
    FROM ELEVE
    WHERE LOGIN = LOWER(login);
END $


-- Récupère les partitions de la table PARTITIONS.
CREATE OR REPLACE PROCEDURE getPartitions()
BEGIN
    SELECT NOM, AUTEUR
    FROM PARTITIONS;
END $

-- Insère une partition dans la table PARTITIONS.
CREATE OR REPLACE PROCEDURE insertPartition(IN nom CHAR(50), IN auteur CHAR(50))
BEGIN
    INSERT INTO PARTITIONS (NOM, AUTEUR)
    VALUES
    (nom, auteur);
END $