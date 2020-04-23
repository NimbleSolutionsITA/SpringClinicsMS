CREATE TABLE IF NOT EXISTS `content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `editorial_id` bigint(20) NOT NULL,
  `slug` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(255),
  `body` text,
  `language` varchar(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `editorial` (`editorial_id`),
  CONSTRAINT `editorial` FOREIGN KEY (`editorial_id`) REFERENCES `editorial` (`id`)
)