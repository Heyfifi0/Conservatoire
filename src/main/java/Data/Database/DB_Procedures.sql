-- Mettre les procédures ici
DELIMITER $
DELIMITER ;

-- Récupère le login de l'élève.
CREATE OR REPLACE PROCEDURE getLoginEleve(IN login CHAR(50))
BEGIN
    SELECT *
    FROM ELEVE
    WHERE LOGIN = LOWER(login);
END $


-- Récupère les partitions.
CREATE OR REPLACE PROCEDURE getPartitions()
BEGIN
    SELECT NOM, AUTEUR
    FROM PARTITIONS;
END $


CREATE OR REPLACE PROCEDURE insertPartition(IN nom CHAR(50), IN auteur CHAR(50))
BEGIN
    INSERT INTO PARTITIONS (NOM, AUTEUR)
    VALUES
    (nom, auteur);
END $