mysqldump: [Warning] Using a password on the command line interface can be insecure.
-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: db_academy_05_2026
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienti` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `denominazione` varchar(255) NOT NULL,
  `p_iva` varchar(16) NOT NULL,
  `indirizzo` varchar(255) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `p_iva` (`p_iva`),
  UNIQUE KEY `telefono` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES (1,'una srl','111111111111','Corso Francia 231','4456790'),(2,'due srl','222222222222','Via Roma 34 bis','3476342'),(3,'tre srl','333333333333','Via Garibaldi 240','455436');
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `dipendente_view`
--

DROP TABLE IF EXISTS `dipendente_view`;
/*!50001 DROP VIEW IF EXISTS `dipendente_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `dipendente_view` AS SELECT 
 1 AS `id_dipendente`,
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `stipendio`,
 1 AS `nome_ufficio`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `dipendenti`
--

DROP TABLE IF EXISTS `dipendenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dipendenti` (
  `id_dipendente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `cognome` varchar(200) NOT NULL,
  `data_assunzione` date NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `mansioni` varchar(50) NOT NULL DEFAULT 'impiegato',
  `stipendio` decimal(10,0) NOT NULL,
  `id_ufficio` int DEFAULT NULL,
  PRIMARY KEY (`id_dipendente`),
  UNIQUE KEY `telefono` (`telefono`),
  KEY `id_ufficio` (`id_ufficio`),
  CONSTRAINT `id_ufficio` FOREIGN KEY (`id_ufficio`) REFERENCES `uffici` (`id_ufficio`),
  CONSTRAINT `dipendenti_chk_1` CHECK (((`stipendio` >= 1100) and (`stipendio` <= 3500)))
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendenti`
--

LOCK TABLES `dipendenti` WRITE;
/*!40000 ALTER TABLE `dipendenti` DISABLE KEYS */;
INSERT INTO `dipendenti` VALUES (1,'Paolo','Verdi','2026-10-10','34523987','impiegato',1500,1),(3,'Mirko','Gialli','2023-01-20','34554366','impiegato',3500,1),(20,'Anna','Rossi','2024-04-12','35679887','HR',2500,5),(21,'Pietro','Gialli','2021-06-18','33354654','impiegato',3500,2),(22,'Sara','Neri','2022-02-04','33478906','HR',3000,2),(23,'Nicola','Violetto','2018-04-02','34789056','impiegato',3500,2),(24,'Chiara','Arancini','2024-04-12','31343435','Team Manager',2500,5),(25,'Alberto','Mezzi','2021-06-18','33314412','Team Manager',3500,1),(26,'Cristina','Aghilera','2022-02-04','334733232','HR',3000,5),(27,'Sandro','Blu','2018-04-02','32343555','Amministratore',3000,2),(28,'Marco','Rossi','2023-01-15','3401234567','Sviluppatore',2200,NULL),(29,'Francesca','Ferrari','2020-11-01','3359876543','Designer',1900,NULL),(30,'Alessandro','Russo','2025-03-10','3291122334','Contabile',2100,NULL),(31,'Giulia','Bianchi','2019-07-22','3475566778','Segretaria',1500,NULL),(32,'Roberto','Gallo','2022-05-14','3389900112','Sistemista',2400,NULL),(33,'Elena','Marini','2024-09-01','3204455667','Marketing',1800,NULL);
/*!40000 ALTER TABLE `dipendenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genera_dipendente`
--

DROP TABLE IF EXISTS `genera_dipendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genera_dipendente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  `cognome` varchar(250) NOT NULL,
  `nome_ufficio` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genera_dipendente`
--

LOCK TABLES `genera_dipendente` WRITE;
/*!40000 ALTER TABLE `genera_dipendente` DISABLE KEYS */;
INSERT INTO `genera_dipendente` VALUES (1,'Paolo','Verdi','Amministrazione'),(2,'Mirko','Gialli','Amministrazione'),(3,'Anna','Rossi','Tecnico'),(4,'Pietro','Gialli','Vendite'),(5,'Sara','Neri','Vendite'),(6,'Nicola','Violetto','Vendite'),(7,'Chiara','Arancini','Tecnico'),(8,'Alberto','Mezzi','Amministrazione'),(9,'Cristina','Aghilera','Tecnico'),(10,'Sandro','Blu','Vendite'),(11,'Marco','Rossi',NULL),(12,'Francesca','Ferrari',NULL),(13,'Alessandro','Russo',NULL),(14,'Giulia','Bianchi',NULL),(15,'Roberto','Gallo',NULL),(16,'Elena','Marini',NULL);
/*!40000 ALTER TABLE `genera_dipendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prova_data`
--

DROP TABLE IF EXISTS `prova_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prova_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) DEFAULT NULL,
  `data_nascita` date NOT NULL,
  `data_inserimento` datetime DEFAULT CURRENT_TIMESTAMP,
  `data_modifica` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prova_data`
--

LOCK TABLES `prova_data` WRITE;
/*!40000 ALTER TABLE `prova_data` DISABLE KEYS */;
INSERT INTO `prova_data` VALUES (1,'Pino','1970-02-27','2026-05-26 12:09:49','2026-05-26 12:14:24'),(2,'Luca','1986-04-25','2026-05-26 12:13:11','2026-05-26 12:13:11');
/*!40000 ALTER TABLE `prova_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rapporto_cliente`
--

DROP TABLE IF EXISTS `rapporto_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rapporto_cliente` (
  `id_rapporto` int NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(255) DEFAULT NULL,
  `id_cliente` int NOT NULL,
  `id_dipendente` int NOT NULL,
  PRIMARY KEY (`id_rapporto`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_dipendente` (`id_dipendente`),
  CONSTRAINT `rapporto_cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clienti` (`id_cliente`),
  CONSTRAINT `rapporto_cliente_ibfk_2` FOREIGN KEY (`id_dipendente`) REFERENCES `dipendenti` (`id_dipendente`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rapporto_cliente`
--

LOCK TABLES `rapporto_cliente` WRITE;
/*!40000 ALTER TABLE `rapporto_cliente` DISABLE KEYS */;
INSERT INTO `rapporto_cliente` VALUES (13,'Consulenza strategica e HR',1,1),(14,'Sviluppo piattaforma Web',2,3),(15,'Assistenza tecnica retail',3,20);
/*!40000 ALTER TABLE `rapporto_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` int DEFAULT NULL,
  `descrizione` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,2,'aaa'),(2,3,'bbb'),(3,4,'ccc'),(4,5,'ddd'),(5,6,'eee'),(6,7,'fff'),(7,8,'ggg'),(8,9,'hhh');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uffici`
--

DROP TABLE IF EXISTS `uffici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uffici` (
  `id_ufficio` int NOT NULL AUTO_INCREMENT,
  `nome_ufficio` varchar(50) NOT NULL,
  PRIMARY KEY (`id_ufficio`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uffici`
--

LOCK TABLES `uffici` WRITE;
/*!40000 ALTER TABLE `uffici` DISABLE KEYS */;
INSERT INTO `uffici` VALUES (1,'Amministrazione'),(2,'Vendite'),(3,'Marketing'),(4,'Sviluppo'),(5,'Tecnico');
/*!40000 ALTER TABLE `uffici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `dipendente_view`
--

/*!50001 DROP VIEW IF EXISTS `dipendente_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `dipendente_view` AS select `d`.`id_dipendente` AS `id_dipendente`,`d`.`nome` AS `nome`,`d`.`cognome` AS `cognome`,`d`.`stipendio` AS `stipendio`,`u`.`nome_ufficio` AS `nome_ufficio` from (`dipendenti` `d` left join `uffici` `u` on((`d`.`id_ufficio` = `u`.`id_ufficio`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-03  9:39:07
