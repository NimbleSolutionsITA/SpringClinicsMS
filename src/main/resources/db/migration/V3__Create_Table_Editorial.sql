CREATE TABLE `editorial` (
     `id` bigint(20) NOT NULL AUTO_INCREMENT,
     `clinic_id` bigint(20) NOT NULL,
     `parent_id` bigint(20) DEFAULT NULL,
     `section` varchar(100) NOT NULL,
     PRIMARY KEY (`id`),
     KEY `clinic` (`clinic_id`),
     KEY `parent` (`parent_id`),
     CONSTRAINT `clinic` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`id`),
     CONSTRAINT `parent` FOREIGN KEY (`parent_id`) REFERENCES `editorial` (`id`)
)