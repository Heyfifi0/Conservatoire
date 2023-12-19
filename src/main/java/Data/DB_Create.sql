DROP DATABASE IF EXISTS Conservatoire;

CREATE DATABASE IF NOT EXISTS Conservatoire;
USE Conservatoire;
# -----------------------------------------------------------------------------
#       TABLE : ELEVE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ELEVE
 (
   ID INTEGER(50) NOT NULL AUTO_INCREMENT,
   DIS_ID INTEGER(50) NOT NULL  ,
   NOM CHAR(50) NULL  ,
   PRENOM CHAR(50) NULL  ,
   CYCLE INTEGER(1) NULL  ,
   ANNEE_CYCLE INTEGER(1) NULL  ,
   LOGIN CHAR(50) NULL  ,
   MDP CHAR(50) NULL,
   PRIMARY KEY (ID),
   FOREIGN KEY FK_ELEVE_DISCIPLINE (DIS_ID) REFERENCES DISCIPLINE (ID)
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PARTITION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTITIONS
 (
   ID INTEGER(50) NOT NULL  ,
   NOM CHAR(50) NULL  ,
   AUTEUR CHAR(50) NULL,
   PRIMARY KEY (ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : DISCIPLINE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS DISCIPLINE
 (
   ID INTEGER(50) NOT NULL  ,
   LIBELLE CHAR(50) NULL,
   PRIMARY KEY (ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PARTITIONELEVE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTITION_ELEVE
 (
   ELE_ID INTEGER(50) NOT NULL  ,
   PAR_ID INTEGER(50) NOT NULL  ,
   NUM_PAGE_CLASSEUR INTEGER(50) NULL,
   PRIMARY KEY (ELE_ID,PAR_ID),
   FOREIGN KEY FK_PARTITIONELEVE_ELEVE (ELE_ID) REFERENCES ELEVE (ID),
   FOREIGN KEY FK_PARTITIONELEVE_PARTITION (PAR_ID) REFERENCES PARTITIONS (ID)
 ) 
 comment = "";


