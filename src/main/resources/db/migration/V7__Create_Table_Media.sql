CREATE TABLE IF NOT EXISTS `media` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `editorial_id` bigint(20) NOT NULL,
  `slug` varchar(100),
  `title` varchar(100),
  `url` varchar(255) NOT NULL,
  `language` varchar(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `section` (`editorial_id`),
  CONSTRAINT `section` FOREIGN KEY (`editorial_id`) REFERENCES `editorial` (`id`)
)