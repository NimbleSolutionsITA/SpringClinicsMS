CREATE TABLE IF NOT EXISTS `media` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `editorial_id` bigint(20) NOT NULL,
  `slug` varchar(100),
  `title` varchar(100),
  `url` varchar(255) NOT NULL,
  `language` varchar(10),
  PRIMARY KEY (`id`)
)