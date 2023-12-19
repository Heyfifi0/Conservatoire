DROP DATABASE IF EXISTS Conservatoire;

CREATE DATABASE IF NOT EXISTS Conservatoire;
USE Conservatoire;
# -----------------------------------------------------------------------------
#       TABLE : ELEVE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ELEVE
 (
   ELENUM INTEGER(50) NOT NULL  ,
   DISNUM INTEGER(50) NOT NULL  ,
   ELENOM CHAR(50) NULL  ,
   ELEPRENOM CHAR(50) NULL  ,
   ELECYCLE INTEGER(1) NULL  ,
   ELEANNEECYCLE INTEGER(1) NULL  ,
   ELELOGIN CHAR(50) NULL  ,
   ELEMDP CHAR(50) NULL  
   , PRIMARY KEY (ELENUM) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PARTITION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTITIONS
 (
   PARNUM INTEGER(50) NOT NULL  ,
   PARNOM CHAR(50) NULL  ,
   PARAUTEUR CHAR(50) NULL  
   , PRIMARY KEY (PARNUM) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : DISCIPLINE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS DISCIPLINE
 (
   DISNUM INTEGER(50) NOT NULL  ,
   DISLIBELLE CHAR(50) NULL  
   , PRIMARY KEY (DISNUM) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PARTITIONELEVE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTITIONELEVE
 (
   ELENUM INTEGER(50) NOT NULL  ,
   PARNUM INTEGER(50) NOT NULL  ,
   NUMEROPAGECLASSEUR INTEGER(50) NULL  
   , PRIMARY KEY (ELENUM,PARNUM) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE ELEVE 
  ADD FOREIGN KEY FK_ELEVE_DISCIPLINE (DISNUM)
      REFERENCES DISCIPLINE (DISNUM) ;


ALTER TABLE PARTITIONELEVE 
  ADD FOREIGN KEY FK_PARTITIONELEVE_ELEVE (ELENUM)
      REFERENCES ELEVE (ELENUM) ;


ALTER TABLE PARTITIONELEVE 
  ADD FOREIGN KEY FK_PARTITIONELEVE_PARTITION (PARNUM)
      REFERENCES PARTITIONS (PARNUM) ;

