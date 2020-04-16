CREATE TABLE IF NOT EXISTS `clinic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `business_address` varchar(255) NOT NULL,
  `business_name` varchar(255) NOT NULL,
  `fiscal_code` varchar(15) DEFAULT NULL,
  `google_place_id` varchar(255) NOT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `is_group` bit(1) NOT NULL,
  `logo` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `share_capital` varchar(15) DEFAULT NULL,
  `tax_number` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
)