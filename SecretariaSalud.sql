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
INSERT INTO `expediente` VALUES (1,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0	( \Z%\"1!%)+...383-7(-.+\n\n\n\r-------+-----+---------7---------+-0+-------77-7+--ÿÀ\0\0ú\0\Ê\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0=\0\0\0\0\0!1AQaqÁ\"‘¡±#2\Ñ\áð3Rbr‚ñB\Â$4S¢²ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\01A!B\"aÿ\Ú\0\0\0?\0ð\äD@DDD@DDD@D\\\Ök3ªhù(µ\Æøø‚Ì­H´ÁSƒ—\Â\" \"\"\" \"\"\" \"\"\" \"\"\" \"-[²\ì\Ä1;VÀƒ)%{„j\Ã\Ç5i¢X\âÓ±o•Ä©.\n 0\ÌsñSj¦\å\í¿{R¸û0…1\Ð\ì\â\Újº2Ž\nz÷¥\î\ß\Ë\ÑULJ\"-K¦\í\Ç\Úv­ƒz…²\ÑSZ®vð\á;S•©–¸´\ëld¯„DX\Ñ\ëFaX\Ý\Ðä£›¬*û$Ž\åQ:hÚ›\Ù*Bü°w…ehšB‘\Òv›\Þ²2UvŽ˜c2Ÿ©R*·GŸa\ã\ÕdUV{È°\Ï\î§¯¶\äðD@!V6\Ï$\âT\Åúd\Ô\ïôW\\\â	W\Üô\á¬W7U)\rÀ¨‹®Í©žõ\'¤4aÁ\Û\Ä\åoV\Ì`ƒ\Þv)}\"¥\î\çq%U‘4ˆŠ\"\"\" \"\"\" \"\"\" +K “„\r£¤¨µYqT\ì°ð¢Ø(œ\É\Èù•¤`\äNò®ÿ\0\ã\çÜ¢tˆvgõ|\ÕVF®Ži%\Ûì½¾\ïk\â\0¯FYP—l7> ‰ÝµX\Ý\Ú5vW`6+afDŠu`zƒ]…\Þ—Œ+m§Ù¦9©šj¯Jk˜\0\É\Ð#/‘P:G@±\Õ\ZD\ÌŽbUU+\É\í—=£LZ\Öû+E™–ŠD$l=—®\Zõª¼9\Îc\ÃÎŽÃ½œ\êõZ_ñôz\Ùð¾µ‚¡œ&œ÷—\0?“V\åƒÿ\0\Ï*\Óe7P¯J\ÓOX{NBd›šrýJfWu=ø\Í4†r\Ñ\ìR—\ï\á;»\Ô/B½®\ê”\Øülsu\æF]\ÇQP7\ë}Ó¾ö…´\ÍH¢\"\æ\è\"\"\" \"\"\" Ý¹®æ¹¡\ÎN©\Ø\Õ\çt%‚Ù½wn*†r©k§=Ê¸G/?EÜ½h`ª\á°\æ;þ²ºjV*{ƒ64q\ê¦.ü\r\ç\Õle\\e´ýÂŽ\Òj0×\Äª›Ú•‘}Q\Ä]DB+\í\Ã\Ù\Å a\'V\å\á/EÑª@½ƒ—S•iD\êÿ\0\È@ýM ÷D\ÊÃ¾\Ë ¸¸í––ÇŠª­dtˆ?8ê§´²‹Zñ„D´xŒÏ½]s-ª;Dq>«Ñ´Y\ï¤A¦\ç2\×\ÎYLk\ï^{I³T\r\î\ê½/GÉƒ#^bOvaFW®•6\r0´4\Ãð\Ôn\ÜC	ñlW\í+\Æ\í­\í*Ô±5•,\ì}¡Ã³\ì\ß\ì\ã\"\Z@y.-\É\Ì\ÎV%H‚\à\É\ÛñeÝµJ\ß\Õ˜ó\Ù9n\É]µ1QòI1™\' \0\Ïp\Z‚ùD\\„D@DDD@DD\Ú=W²[¸úª\æQ.\Z²Û¹yõ\Ù_A¸\ä{þª\Ú\ÃS5’F\É$x*ˆ¬\r&³\á\Èò?U:®¯j2b\nŠ´\ÑÀ\âÕ•R¸•.>\Z\âT\Ò\Þ\Ñ\×dFâ«\Ë3ZZ€\Æ\Év¿%Ô¾KD44N±3–\ÂI[7k¨7ôˆ\ï™2¸/öK-S’\è\ç\Ï×”Þ´ð\Õp\ïòW\Z8\î\Ý#\Èù(\Ûü{\Þ\á\ÕW\èŽf—\íD\íw§£\á—\È(­-¼wü\Õm:þª\'J\êö\ßÁ½\nº\çž\Ðw;1U$¯P\Ñ\ÊX˜\è\ßõ^q£­\íž]W¦\è»b›\É\Ûý)Ê¶Ð§I¬kœvH\Þ#\ï^u>);”x\ä½\n÷|Y\Ý\Ç%\æºLÿ\0vò:•ºfS(ˆ¹ºˆˆ€ˆˆˆ€ˆˆ\n¶\âµ\ÎOz)%£r\Ú0»	\Ô}V\ÆU\ÍpJ–¾\î\ÒF 3aUY 	 e\ã\Èm\\v\ë>&\ä\"6m<\Õ%\çF\ã«#x_—½—¤j>Eulu0½§ˆSÒ»\\Ñº¾\èŽ=Rþt\Ò\å+;GkvÀýWvò \ÓpŽk§Ž^¼\Öÿ\0om§x\íV\èm20NP\Â~üVY \àH˜\Ì*K‚ŽO\0\Ñ\Þdú2}]¿´”ž”4º¥P6\å\âÐ·ñ,‹ù“P»ó\0zt[Sw™\Ís‹„dô[ø)4~lüNJV\Ï@“Y*•\Â ltè‘ºú\ç¿+{\äU\ç\ZOS\ào3\Ñ]^\Î÷C÷\äWži\æ¬nhõ+4e–ˆŠ}S¦\\@IUU\Ò\ÖAvnß»’\Ùk\ÏtUvx`q\Ë\É}W¹ª´LrÖ­löb\î[\×¾ˆf²·†\'Ÿ\"æ¶¼\ZŽ#Q&\n•ˆ€¿X\è ‹ñ[\\6\àp»~G‡\ÙTo¤<W›Ü¶¼\Âu;È¯A»-8\éÁ\Ö\ÏEr¹Ø›½ì¹¹§ö¥\ÙD\ã\rŒçª¿½¨\â†±\æ-\Z©Yceo\Ü\"þm\ê»\îtŒ\×V\ì¥\Ø\ËY3\Ñh>\Äð\'	ð*’šö0H\Ú2U·U•¦›{@É¹,‹e›´\×oŸ/\ín\ÝfŠa\Äfv\í\×	\\µ,,?ñ²\'’Ã¾\éü9gŸ8\Ë\ë\à¨kP–8‰	\ÊAT\ÍV™2d\ï+k!sY\åÄb#\Ï?E¸n\Òu9¤\î5ŸtY1?=@I\è>÷-\Ç\Ù\ç\à\×\Â\'¹!k\nð¥\î\Ü\é\ïyÖ’SŠ€\ï‡\ê¯\ï[K\É!\Æc#\ÔF“7&ž=\éy`\".\Õ\Ýe57\É\è¡mÛŠ\ï\Â\ÜG\â>Crß¥f&6÷©u\ì”\ç ·\ì¶þ}wFõr9\Ú\ë±\Í`\Êp·3¼¨$½‹\ÜX2~J³H³x¸÷}•\æõ$\äŸ\ÓrùDE~‚¬ô~\Ý8O\æO~^ª-P\èñ\ì÷­ŒªÁ+ªû\Ö<>KV\ÅE®\' Fq¿`–µ0-gyt\Ç5h\åÖºj8\Ðr\Ï8\Ì\r°¶g“¬\Îùù¬»œl\Í\ßE¬_\Ä\Ö]¶ƒƒ\Èy’2TV?Álg:…~™-;KDñ\Ù>Aw®34{ðž\ìÇ‘[zsÝ¤\ãAF\Ã9)\Û{\0{€\Ì|•[\ì\ØúƒüZ\â9\Ä2¤!)\Zw\ìTžS\Ëb\çms9+÷GiOµý€øª\ì²\Ì\'½{O\é=ªH\È8G=~j.ü³0\å1˜V7\ÕBú\Ï;\Â7\02Y5\è5\Ò<\ìQwY°4kŠ\Ñs{Àöˆ$uV•%2*\×~\ë¤K n•JZÃˆ9ñŒ\×B\é³{6\Éø\ä7/\Ý,µû66\ÖF\'\Ã`òV\ç~\Ô>”^A$»y˜l\êSš\Ù\\½\å\Û\Î\\¶.Îº\È\"\"Æˆˆ€ˆˆz\á=Žõ‚¶\î\rGŸE±•et\ç’bt	.õEN»D\0\Þ`Ÿ/vVÀ\àU[hA~õ®‘\ËL»u%¹	‘\êý:!\íc\Äv€ñÚ³/\æEw˜\äZ:\Ê\Õ\Ñ÷M\'7ò:{õlí—§CH)û÷\r€0\æ\0»z.\ÙmV\î‡1\Ñqi=\ì\ïkON‹\ïE\ï^\Ý\ì>D|\Ó\Ö~­\Äa³T\ã\ÍG•e|·þ™üÇ¨RØš2¡\ÑFÀ¬@eh†µ\Ï;\\:1O\Ý\Õ<@\ë\Õr\ß}ŠŽ^9-ñ—´{›=\åqÔ¤»0¾›JT­”l\Å\Î\r2»4\ìb™\Þwü–‘±\æ\ç\ÃÜ­K-®\Ú1\Ô\É\Û-p\ïI!k\È\îÜ»\áO!™ôPú[z——\Í\çÀJ\×H©û½³2\0x$t•\åw­lU¸d\éYŽš\"(tmh\éø‡±V®Ž»¶Fñ\ÕleXYÂ°¹Ž*@\íi\Âzy)+:¤\Ñz‘P°\êxóŽªãžºwtŠŒ–T˜Ov®«óF_\ï3H\ïŽ«F\×C73n±\Ì,{¢[]›ñ\ÐõU\ê<i\ékÍ§\Ôu]-ÿ\0¸þ\'\Ô-\ËcC\Úöùp+/E\éEg“±¤w“ô[\ë%þ­K\Èb¡Psú):TÕ&N&oß±MÑ²ñLk&Ï¸%3T-<4÷8Ÿ8\èOJŽMoAõ[8KZ54\0”»Þ¸zŸ¢\Û\ÒglÔ¯\Ø_‡5­[¦™ ºu3ž³¨-;Ma2!|Ñ )Sk\ÄD»†\ß^6ò´\nl/9ªv\Ì\êâ«¤v‹ÒŠ\Ä=\à™\r9p=W›½\ÒI\ÞeS\éM\à]‹<\Þ|”º\å§|ˆˆ¥B\" \"\"\" .õ\Êøª8\È]\Éf«…ÁÛŠB²Kv\év\Z;E9wU\nÞ²T‚\n\éª½õd\Ê2\Ç\Úö€f=,ø\êZT¤\rŸ{2]#•øè“µrXZQ\ÜDžk’½•\àIal\ê\Ê}åŽ‘˜Ÿ‡?ª%ó\æ\Ëg}j‡^(ùýò]\Æ\ãh’Öù$ñ\Ê5£\Èp\ÈH\Ù\n‘Ë«V®`òX\ÚB\Ép~ñ·]BN¨\ç\Ñf^v8€rh\Îz÷­MTN¹j]vL1Q\ã?ñoû‹œX\Ú\Ì\à¼\ç\à’IY\Âùs—\â$Z\É^{¥÷\Ð{‹¦)³&û1s?%½¤÷®h°þó¿ô¯/\Ò;\\ÀxžNª±–]ª\Ð^\â\ãý.E\É\ØDDD@DDD@DDš9n\Ë\Ö5rVV\Ì//²W,xp\Ù\è½\æ´LqW*5·eSˆÝ½V\Ù2\Î;[÷rÜ£\î\Û;ª‡(Û¹VY):”ºA\È;Ž\ç.¹yöÐ®Óº\ä•Ó§gƒ·g\ßò\Íwä“Ÿ\ß%\ÔG\êwÿ\0_Eu\Î9T}ó_–zg@\å\ÃTe\ï‚ù»˜ùsƒ\È\Î \æ\ÝÚ»ñ\ß#\"Ý›WB\ÕP2˜q1	\Þw0¹­•\ÎcQõ\ä³j[\0×©-l›E6ÁŒ\ÇÞ¥=z\Ûý“\\F½M\ç½pV½\ÞÀ`ˆ\ÜD\ÉJ\ß‰q%\Ç\ä9.V»g,»\æß¥\Ç3\êJŒ¨òI\'2s]»\Ò\Ù\íúF¯š\é.V»\È\"\"Æˆˆ€ˆˆˆ€ˆˆˆ€¬4^¼°ox(õ¿¢¯\ÍÃ’\Ø\Ê÷k}˜ü\Æ\ÑU¹s]˜\"Óˆ^g£÷©§†D’±²^r10\ë\à½\Ô\á\ä\Þo.\Ë\ëšP\×N\Ç~aÝµsY\\\Ð{û\É$ú®¥– ¨}£¾!ƒ~÷sZÌ®Ì²#–¥Q5\Ö\ÂFdj\\Ì§\Øn³ßš\ãq\Ú&sùx¯Šøµ\ç\ÎV±×½\Ù\îŽ}¡›N\ÙP\Ö\ëQ\Ôgï‚·¬Z\\óü[\0G%Ei%(†øñ\ÍsÓ¯\ãN^v\ÈN¥zÞ¦¤µ¿ýÿ\0E«¥v“„7óE,¸\ÚôH\"\"•ˆ€ˆˆˆ€ˆˆˆ€ˆˆwEþ\'w„¨t\\z­Œ««#Aªv­7b\î\\öqZ›Y0AN­D\î*ž\Ïbe8\Â8Lk\âº\È\á­3\î«Å¤5‡\"jaPRd\êŸ²«YÛŒ:\0 \Ìú‚¨¤Œ›÷’\é—-W;\ä™\rkð]œ\r`ü\Ç\Ép¾£Žµô\âU!“x\×s¦T–’þò‡è¬­LÖ¤´œf\êŸýO\ÑsÓ¶E¥n\í´p\'\Ïè°–Þ–6*·‹z¬EÂ½3¡4DDD@DDD@DDD@T:2\èšž[º9¨þ\î‹c+\×4Pd8¯EiDHQ\Zð7™õ*\îÈ½y\'l\Û\ìa\r[§¸¯¢\îÜ•±²¶\ë\äºZAøý£Ô¯½üaû]è·ªŸÕ²Z¿\\®GjV\æ\éUd¨.…¿¸øÀÿ\0R®Þ¡ô\Çñ\í\êW=ô\ëøûy.˜SøÄú)¥[¥¿‡ü‚’^zõÎ„DX\Ñÿ\Ù','RADIOGRAFIA','radiografÃ­a de mano','D2G8A5',1);
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
