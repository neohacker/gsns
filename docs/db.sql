-- 사용자

CREATE TABLE `Users` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY (`no`),
  UNIQUE KEY `id_UNIQUE` (`id`)
)