CREATE TABLE IF NOT EXISTS `editorial` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clinic_id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `section` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
)