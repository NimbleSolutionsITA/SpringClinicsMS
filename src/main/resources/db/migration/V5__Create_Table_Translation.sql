CREATE TABLE IF NOT EXISTS `translation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `editorial_id` bigint(20) NOT NULL,
  `slug` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(255),
  `body` text,
  `language` varchar(10),
  PRIMARY KEY (`id`)
)