-- create database comfort_hub;
-- use comfort_hub;

CREATE TABLE IF NOT EXISTS `employees` (
  `eId` int(11) NOT NULL DEFAULT '0',
  `eName` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL,
   Primary key (`eId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `suites` (
  `sName` varchar(255) NOT NULL,
  `sNum` varchar(55) NOT NULL,
  `type` varchar(55) NOT NULL,
  `sPrice` decimal(10,0) NOT NULL,
  `availability` varchar(20) NOT NULL,
   PRIMARY KEY (`sNum`)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `reservations` (
  `pName` varchar(255) NOT NULL,
  `roomNo` int(11) NOT NULL DEFAULT '0',
  `nationality` varchar(50) NOT NULL,
  `phoneNO` varchar(13) NOT NULL,
  `roomType` varchar(5) NOT NULL,
  `price` decimal(10,0) NOT NULL,
   `TimeIn` time NOT NULL,
  `TimeOut` time NOT NULL,
Primary key (`phoneNO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;