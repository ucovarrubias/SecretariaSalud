CREATE DATABASE  IF NOT EXISTS `secretaria_salud` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `secretaria_salud`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: secretaria_salud
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `id_cita` int NOT NULL AUTO_INCREMENT,
  `hora_cita` datetime NOT NULL,
  `acceso_expediente` tinyint NOT NULL,
  `id_paciente` int NOT NULL,
  `id_trabajador_salud` int NOT NULL,
  PRIMARY KEY (`id_cita`),
  KEY `fk_paciente_idx` (`id_paciente`),
  KEY `fk_trabajador_salud_idx` (`id_trabajador_salud`),
  CONSTRAINT `fk_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`),
  CONSTRAINT `fk_trabajador_salud` FOREIGN KEY (`id_trabajador_salud`) REFERENCES `trabajador_salud` (`id_trabajador_salud`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (1,'2022-03-16 10:00:00',1,1,1);
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expediente`
--

DROP TABLE IF EXISTS `expediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expediente` (
  `id_expediente` int NOT NULL AUTO_INCREMENT,
  `archivo` blob NOT NULL,
  `TIPO_ARCHIVO` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `folio` varchar(45) NOT NULL,
  `id_paciente` int NOT NULL,
  PRIMARY KEY (`id_expediente`),
  KEY `fk_paciente_idx` (`id_paciente`),
  CONSTRAINT `fk_paciente_exp` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expediente`
--

LOCK TABLES `expediente` WRITE;
/*!40000 ALTER TABLE `expediente` DISABLE KEYS */;
INSERT INTO `expediente` VALUES (1,_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�\0	( \Z%\"1!%)+...383-7(-.+\n\n\n\r-------+-----+---------7---------+-0+-------77-7+--��\0\0�\0\�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0=\0\0\0\0\0!1AQaq�\"����#2\�\��3Rbr��B\�$4S���\�\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0\0\0\0\0\0\0\0\0\0\01A!B\"a�\�\0\0\0?\0�\�D@DDD@DDD@D\\\�k3�h�(��\����̭H��S��\�\" \"\"\" \"\"\" \"\"\" \"\"\" \"-[�\�\�1;V��)%{��j\�\�5�i�X\�ӱo�ĩ.\n 0\�s�Sj�\�\�{R��0�1\�\�\�\�j�2�\nz��\�\�\�\�ULJ\"-K�\�\�\�v��z��\�SZ�v�\�;S�����\�ld��DX\�\�FaX\�\�䣛�*�$�\�Q:hڛ\�*B��w�eh�B�\�v�\��2Uv��c2��R*�G�a\�\�dUV{Ȱ\�\����\��D@!V6\�$\�T\��d\�\��W\\\�	W\��\��W7U)\r�����ͩ���\'�4a�\�\�\�oV\�`��\�v)}\"�\�\�q%U�4��\"\"\" \"\"\" \"\"\" +K���\r����YqT\���؝(�\�\����`\�N��\0\�\�ܢt�vg�|\�VF��i%\�콍�\�k\�\0�FYP��l7> �ݵX\�\�5vW`6+afD�u`�z�]�\���+m�٦9��j�Jk�\0\�\�#/�P:G@�\�\ZD\��bUU+\�\��=�LZ\��+E���D$l=��\Z���9\�c\�Ύý�\��Z_��z\�𾵂���&���\0?�V\��\0\�*\�e7P�J\�OX{NBd��r�JfWu=�\�4�r\�\�R�\�\�;�\�/B��\�\��lsu\�F]\�QP7\�}Ӿ���\�H�\"\�\�\"\"\" \"\"\" ݹ�湡\�N�\�\�\�t%�ٽwn*��r��k��=ʸG/?Eܽh`�\�\�;���jV*{�64q\�.��\r\�\�le\\e��\�j0׍\���ڕ�}Q\�]DB+\�\�\�\� a�\'V\�\�/EѪ@����S�iD\��\0\�@�M �D\�þ\� ��햖Ǌ��dt��?8꧴��Z�D�x��Ͻ]s�-�;Dq>�ѴY\�A�\�2\�\�YLk\�^{I�T\r\�\�/GɃ�#^bOvaFW��6\r0�4\��\�n\�C	�lW\�+\�\�\�*Ա5�,\�}�ó\�\�\�\�\"\Z@y.-\�\�\�V%H�\�\�\��eݵJ\�\���\�9n\�]�1Q�I1�\' \0\�p\Z��D\\��D@DDD@DD\�=W�[���\�Q.\Z�۹y�\�_A�\�{��\�\�S5�F\�$x*��\r&�\�\��?U:��j2�b\n��\��\�ՕR��.�>\Z\�T\�\�\�\�dF␫\�3ZZ�\�\�v�%ԾKD44N�3�\�I[7k�7�\�2�/�K-S�\�\�\�ה޴�\�p\��W\Z8\�\�#\��(\��{\�\�\�W\�f�\��D\�w��\�\�(�-�w�\�m:��\'J\��\���\n�\�\�w;1U$�P\�\�X�\�\��^q��\�]W�\�b�\�\��)ʶЧI�k�vH\�#\�^u>);�x\�\n�|Y\�\�%\�L�\0v�:��fS(������������\n�\�\�Oz)%�r\�0�	\�}V\�U\�pJ��\�\�F 3aUY 	 e\�\�m\\v\�>&\�\"6m<\�%\�F\�#x_����j>Eulu0���Sһ�\\Ѻ�\�=R�t\�\�+;Gkv��Wv� \�p��k��^�\��\0om�x�\�V\�m20NP\�~�VY�\�H�\�*K��O\0\�\�d�2}]������4��P6\�\�з�,���P��\0zt[Sw�\�s��d�[��)4~l�NJV\�@�Y*�\� lt葺�\�+{�\�U\�\ZOS\�o3\�]^\��C�\�W�i\�nh�+4e���}S�\\@IUU\�\�Avn߻�\�k\�tUvx`q\�\�}W���Lr֭l�b\�[\���f���\'�\"涼\Z�#Q&\n����X\� ���[\\6\�p�~G�\�To�<W�ܶ�\�u;ȯA�-8\��\�\�Er�؛�칹����\�D\�\r�窿��\���\�-\Z�Yceo\�\"�m\�\�t�\�V\�\�\�Y3\�h>\��\'	�*���0H\�2U�U���{@ɝ�,�e��\�o�/\�n\�f�a\�fv\�\�	\\�,,?��\'�þ\��9g�8\�\�\�kP�8��	\�AT\�V�2d\�+k!sY\�čb#\�?E�n\�u9�\�5�tY1?=@I\�>�-\�\�\�\�\�\�\'�!k\n�\�\�\�\�y֒S��\��\�\�[K\�!\�c#�\�F�7&�=\�y`\".\�\�e57\�\�mۊ\�\�\�G\�>Crߥf&6��u\�\� �\��}wF�r9\�\�\�`\�p�3���$��\�X2~J�H�x��}�\��$�\�\�r�DE~���~\�8O\�O~^�-P\��\������+��\�<>KV\�E�\' Fq�`��0-gyt\�5h\�ֺj8\�r\�8\�\r��g��\������l\�\�E�_\�\�]���\�y�2TV?�lg:��~�-;KD�\�>Aw�34{�\�Ǒ[zsݤ\�A�F\�9)\�{\0{�\�|�[\�\����Z\�9\�2�!)\Zw\�T��S\�b\�ms9+�GiO�����\�\�\'�{O\�=�H\�8G=~j.��0\�1�V7\�B�\�;\�7\02Y5\�5\�<\�QwY�4k�\�s{���$uV�%2*\�~\�K�n�JZÈ9�\�B\�{6\���\�7/\�,��66�\�F\'�\�`�V\�~\�>�^A$�y�l\�S�\�\\�\�\�\�\\�.κ\�\"\"ƈ����z\�=����\�\rG�E��et\��bt	.�EN�D\0\�`��/vV�\�U[hA~���\�L�u%�	�\��:!\�c\�v��ڳ/\�Ew���\�Z:\�\�\��M\'7�:{��l헧CH)��\r�0\�\0�z.\�mV\�1\�qi=\�\�kON�\�E\�^\�\�>D|\�\�~�\�a�T\�\�G�e|����ǨRؚ2�\�F��@eh��\�;\\:1O\�\�<@\�\�r\�}��^9-�{�=\�qԤ�0��JT��l\�\�\r2�4\�b�\�w����\�\�\�ܭK-��\�1\�\�\�-p\�I!k\�\�ܻ\�O!��P�[z��\�\��J\�H����2\0x$t�\�w�lU�d\�Y��\"(tmh\����V����F�\�leXY°��*@\�i\�zy)+:�\�z�P�\�x���㞺wt���T��Ov���F_\�3H\���F\�C73n�\�,{�[]��\��U\�<i\�kͧ\�u]-�\0��\'\�-\�cC\���p+/E\�Eg���w��[\�%��K\�b�Ps�):T՝&N&o߱MѲ�Lk&ϸ%3T-<4�8�8\�OJ�MoA�[8KZ54\0��ށ�z��\�\�glԯ\�_�5�[�� �u3���-;Ma2!|Ѡ)Sk\�D��\�^6�\nl/9�v\�\�⫤v�Ҋ\�=\��\r9p=W��\�I\�eS\�M\�]�<\�|��\�|���B\" \"\"\" .�\���8\�]\�f���ۊB�Kv\�v\Z�;�E9wU�\n޲T�\n\����d\�2\�\���f=,�\�ZT�\r�{2]#��蓵rXZQ\�D�k���\�Ial\�\�}厑���?�%�\�\�g}j�^(���]\�\�h�ց��$�\�5�\�p\�H\�\n�˫V�`�X\�B\�p~��]BN�\�\�f^v8�rh\�z��MTN�j]vL1Q\�?�o���X\�\�\��\�\��IY\��s�\�$�Z\�^{��\�{��)�&��1s?%����h�����/\�;\\��x��N���]�\�^\�\��.E\�\�DDD@DDD@DD�9n\�\�5rVV\�//�W,xp\�\�\�LqW*5�eS�ݽV\�2\�;[�rܣ\�\�;��(۹VY):��A\�;�\�.�y�ЮӁ�\�ӧg��g\��\�w䓟\�%\�G\�w�\0_Eu\�9�T}�_�zg@\�\�Te\�����s�\�\� \�\�ڻ��\�#\"ݛWB\�P2�q1	\�w0���\�cQ�\�j[\0ש-l��E6��\�ޥ=z\���\\F�M\�pV�\��`�\�D�\�J\��q%\�\�9.V�g,�\�߁�\�3\�J���I\'2s]�\�\�\��F��\�.V�\�\"\"ƈ�����������4^��ox(����\�Ò\�\��k}��\�\�U��s]�\"ӈ^g�����D����^r10\�\�\�\�\�\�o.\�\�P\�N\�~aݵsY\\\�{�\�$������}��!�~�sZ̮̲#��Q5\�\�Fdj\\̧\�n�ߚ\�q\�&s�x����\�\�V�׽\�\�}��N\�P\�\�Q\�g�Z\\��[\0G%Ei%(���\�sӯ\�N^v\�N�zަ�����\0E��v��7�E,�\��H\"\"�������������wE�\'w��t\\z����#A�v�7b\�\\�qZ�Y0AN�D\�*�\�be8\�8Lk\�\�\�3\�Ť5�\"j�aPRd\���Yی:\0 \���������\�-W;\�\rk�]�\r`�\�\�p�����\�U!�x\�s�T�����謭L֤��f\��O\�sӶE�n\�p\'\�谖ޖ6*��z�E½3�4DDD@DDD@DDD@T:2\���[�9��\�c+\�4Pd8��EiDHQ\Z�7��*\�Ƚy\'l\�\�a\r[����\�ܕ���\�\�ZA����ԯ��a�]跪�ղZ�\\�GjV\�\�Ud��.������\0R�ޡ�\��\�\�W=�\���y.�S�ď�)�[������^z�΄DX\��\�','RADIOGRAFIA','radiografía de mano','D2G8A5',1);
/*!40000 ALTER TABLE `expediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `id_paciente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `curp` varchar(18) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `huella_dactilar` varchar(45) NOT NULL,
  `tutor` int DEFAULT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (1,'Zutano','OASD124586JSLTOS12','1986-02-02','9ASVHF0ASWHNVG9034HTG0W94GFJ0P0SPF',NULL);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador_salud`
--

DROP TABLE IF EXISTS `trabajador_salud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador_salud` (
  `id_trabajador_salud` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `curp` varchar(18) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `huella_dactilar` varchar(45) NOT NULL,
  `cedula_profesional` varchar(8) NOT NULL,
  `contrasenia` varchar(15) NOT NULL,
  PRIMARY KEY (`id_trabajador_salud`),
  UNIQUE KEY `curp_UNIQUE` (`curp`),
  UNIQUE KEY `cedula_profesional_UNIQUE` (`cedula_profesional`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador_salud`
--

LOCK TABLES `trabajador_salud` WRITE;
/*!40000 ALTER TABLE `trabajador_salud` DISABLE KEYS */;
INSERT INTO `trabajador_salud` VALUES (1,'Fulano','MAFL254793HSRVLT01','1993-01-01','89AESYH9FHASO9FN89HHAO0HJ90ERFJ','12345678','test');
/*!40000 ALTER TABLE `trabajador_salud` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-04 21:19:45
