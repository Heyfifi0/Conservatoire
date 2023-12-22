-- Mettre les procédures ici
DELIMITER $

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
    SELECT *
    FROM PARTITIONS;
END $


-- Insère une partition dans la table PARTITIONS.
CREATE OR REPLACE PROCEDURE insertPartition(IN nom CHAR(50), IN auteur CHAR(50))
BEGIN
    INSERT INTO PARTITIONS (NOM, AUTEUR)
    VALUES
    (nom, auteur);
END $


-- Insère une partition et un élève dans la table PARTITION_ELEVE, soit le 'classeur'.
CREATE OR REPLACE PROCEDURE insertPartitionEleve(IN idEleve INT(50), IN idPartition INT(50), IN numeroPage INT(50))
BEGIN
    INSERT INTO PARTITION_ELEVE
    VALUES
    (idEleve, idPartition, numeroPage);
END $


-- Récupère les partitions d'un élève donné.
CREATE OR REPLACE PROCEDURE getPartitionEleve(IN idEleve INT(50))
BEGIN
    SELECT P.ID, P.NOM, P.AUTEUR, PE.NUM_PAGE_CLASSEUR
    FROM PARTITIONS P
    JOIN PARTITION_ELEVE PE ON PE.PAR_ID = P.ID
    WHERE PE.ELE_ID = idEleve;
END $










DELIMITER ;