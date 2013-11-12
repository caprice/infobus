CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `idCard` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `nickName` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `plate` varchar(255) NOT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `userLog` varchar(255) DEFAULT NULL,
  `accountName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$