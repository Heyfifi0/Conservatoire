-- Mettre les procédures ici
DELIMITER $
DELIMITER ;

CREATE OR REPLACE PROCEDURE getLoginEleve(IN login CHAR(50))
BEGIN
    SELECT *
    FROM ELEVE
    WHERE LOGIN = LOWER(login);
END $