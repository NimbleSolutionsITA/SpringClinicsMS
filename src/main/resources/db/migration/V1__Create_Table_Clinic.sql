CREATE TABLE IF NOT EXISTS `clinic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `google_place_id` varchar(255) NOT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `is_group` bit(1) NOT NULL,
  `logo` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `group` (`group_id`),
  CONSTRAINT `group` FOREIGN KEY (`group_id`) REFERENCES `clinic` (`id`)
)