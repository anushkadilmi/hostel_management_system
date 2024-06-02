-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2023 at 12:10 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hostel`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', 'admin'),
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `newstudent`
--

CREATE TABLE `newstudent` (
  `Unique_ID` int(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Father_Name` varchar(150) NOT NULL,
  `Mother_Name` varchar(500) NOT NULL,
  `Telephone_Number` int(10) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Permenant_Address` varchar(200) NOT NULL,
  `University_Name` varchar(200) NOT NULL,
  `Room_Number` int(100) NOT NULL,
  `Living_Status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `newstudent`
--

INSERT INTO `newstudent` (`Unique_ID`, `Name`, `Father_Name`, `Mother_Name`, `Telephone_Number`, `Email`, `Permenant_Address`, `University_Name`, `Room_Number`, `Living_Status`) VALUES
(1, 'anu', 'sunil', 'nayana', 719949822, 'anu@gmail.com', 'walasmullaa', 'nibm', 3, 'Yes'),
(5, 'dhanushka', 'gamage', 'nimnadee', 713549700, 'dilki@gmail.com', 'waththala', 'peradeniya', 1, 'No'),
(6, 'kasun', 'nimal', 'amali', 785418234, 'kas@gmail.com', 'negambo', 'colombo', 3, 'Yes'),
(9, 'kethaka', 'gamage', 'madhuwanthi', 713020644, 'madhu@gmail.com', 'Thissa', 'Jaffna', 2, 'Yes'),
(10, 'Tanuri Bawanya', 'Weerathunga', 'Mallika', 714326156, 'Tanuri@gmail.com', 'Godagama,Matara', 'Ruhuna', 3, 'Yes'),
(11, 'Zaina', 'Mawlana', 'Akira', 721453278, 'zaina@gmail.com', 'Weligama', 'NIBM', 1, 'Yes'),
(13, 'Kulani Ovenya', 'Ayesh', 'Dilki', 760112345, 'kulani@gmail.com', 'colombo7', 'jayawardhanapura', 2, 'Yes'),
(14, 'nisham', 'nishaff', 'amina', 785639140, 'nisham@gmail.com', 'galle', 'NSBM', 2, 'No');

-- --------------------------------------------------------

--
-- Table structure for table `psyment`
--

CREATE TABLE `psyment` (
  `Unique_ID` int(100) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Room_Number` int(20) NOT NULL,
  `Month` int(12) NOT NULL,
  `Amount` int(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `psyment`
--

INSERT INTO `psyment` (`Unique_ID`, `Name`, `Email`, `Room_Number`, `Month`, `Amount`) VALUES
(1, 'anu', 'anu@gmail.com', 3, 12, 12000),
(5, 'dhanushka', 'dilki@gmail.com', 1, 12, 16000),
(9, 'kethaka', 'madhu@gmail.com', 2, 10, 12000),
(10, 'Tanuri Bawanya', 'Tanuri@gmail.com', 3, 10, 5000),
(11, 'Zaina', 'zaina@gmail.com', 1, 10, 13000),
(12, 'sv', 'sdf@gmail.com', 1, 10, 5000),
(13, 'Kulani Ovenya', 'kulani@gmail.com', 2, 5, 10000),
(14, 'nisham', 'nisham@gmail.com', 2, 12, 2000),
(15, 'hgjy', 'ghg@gmail.com', 2, 8, 123457),
(16, 'Shanya Shanel', 'shan@gmail.com', 1, 8, 13000);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `rid` int(100) NOT NULL,
  `actiavtion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`rid`, `actiavtion`) VALUES
(2, 'Yes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `newstudent`
--
ALTER TABLE `newstudent`
  ADD PRIMARY KEY (`Unique_ID`);

--
-- Indexes for table `psyment`
--
ALTER TABLE `psyment`
  ADD PRIMARY KEY (`Unique_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `newstudent`
--
ALTER TABLE `newstudent`
  MODIFY `Unique_ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
