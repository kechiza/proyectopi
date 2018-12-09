CREATE DATABASE  IF NOT EXISTS `db_empresarial2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_empresarial2`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_empresarial2
-- ------------------------------------------------------
-- Server version	5.5.60-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_empleado`
--

DROP TABLE IF EXISTS `tb_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_empleado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empleado`
--

LOCK TABLES `tb_empleado` WRITE;
/*!40000 ALTER TABLE `tb_empleado` DISABLE KEYS */;
INSERT INTO `tb_empleado` VALUES (1,'Chirinos Zapata','123456','46448120','1990-05-27','Kevin','Jefe','M','kevin123');
/*!40000 ALTER TABLE `tb_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_marca`
--

DROP TABLE IF EXISTS `tb_marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_marca` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `marca` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_marca`
--

LOCK TABLES `tb_marca` WRITE;
/*!40000 ALTER TABLE `tb_marca` DISABLE KEYS */;
INSERT INTO `tb_marca` VALUES (1,'LG'),(2,'Samsung'),(3,'Asus'),(4,'Nvidia');
/*!40000 ALTER TABLE `tb_marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_presentacion`
--

DROP TABLE IF EXISTS `tb_presentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_presentacion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `presentacion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_presentacion`
--

LOCK TABLES `tb_presentacion` WRITE;
/*!40000 ALTER TABLE `tb_presentacion` DISABLE KEYS */;
INSERT INTO `tb_presentacion` VALUES (1,'Docena'),(2,'Unidad');
/*!40000 ALTER TABLE `tb_presentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_producto` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `id_presentacion` bigint(20) DEFAULT NULL,
  `id_marca` bigint(20) DEFAULT NULL,
  `id_proveedor` bigint(20) DEFAULT NULL,
  `id_zona` bigint(20) DEFAULT NULL,
  `codigo` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `iva` int(11) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_presentacion` (`id_presentacion`),
  KEY `id_marca` (`id_marca`),
  KEY `id_proveedor` (`id_proveedor`),
  KEY `id_zona` (`id_zona`),
  CONSTRAINT `tb_producto_ibfk_1` FOREIGN KEY (`id_presentacion`) REFERENCES `tb_presentacion` (`id`),
  CONSTRAINT `tb_producto_ibfk_2` FOREIGN KEY (`id_marca`) REFERENCES `tb_marca` (`id`),
  CONSTRAINT `tb_producto_ibfk_3` FOREIGN KEY (`id_proveedor`) REFERENCES `tb_proveedor` (`id`),
  CONSTRAINT `tb_producto_ibfk_4` FOREIGN KEY (`id_zona`) REFERENCES `tb_zona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_producto`
--

LOCK TABLES `tb_producto` WRITE;
/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
INSERT INTO `tb_producto` VALUES (2,'laptop',1,1,1,1,123,1233,1,12,13),(3,'asd',1,1,1,1,12,12,12,12,12),(5,'alienware',2,4,2,2,123,16000,5,50,35),(6,'aaaaaaa',2,3,2,1,111,22222,2,2,2);
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_proveedor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `proveedor` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` VALUES (1,'Deltron'),(2,'AnTan');
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_zona`
--

DROP TABLE IF EXISTS `tb_zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_zona` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `zona` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_zona`
--

LOCK TABLES `tb_zona` WRITE;
/*!40000 ALTER TABLE `tb_zona` DISABLE KEYS */;
INSERT INTO `tb_zona` VALUES (1,'Esperanza'),(2,'Trujillo');
/*!40000 ALTER TABLE `tb_zona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_empresarial2'
--

--
-- Dumping routines for database 'db_empresarial2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-09 11:13:44
