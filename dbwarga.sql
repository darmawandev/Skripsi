-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 27, 2019 at 05:53 AM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbwarga`
--

-- --------------------------------------------------------

--
-- Table structure for table `datakegiatan`
--

CREATE TABLE IF NOT EXISTS `datakegiatan` (
  `no` varchar(50) NOT NULL,
  `idpenanggungjawab` varchar(50) NOT NULL,
  `idwarga` varchar(50) NOT NULL,
  `namawarga` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `jeniskegiatan` varchar(50) NOT NULL,
  `hari` varchar(100) NOT NULL,
  `tanggal` date NOT NULL,
  `jammulai` varchar(100) NOT NULL,
  `jamselesai` varchar(100) NOT NULL,
  `keterangan` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datakegiatan`
--

INSERT INTO `datakegiatan` (`no`, `idpenanggungjawab`, `idwarga`, `namawarga`, `alamat`, `jeniskegiatan`, `hari`, `tanggal`, `jammulai`, `jamselesai`, `keterangan`) VALUES
('0001', 'IDPJ001', 'IDW001', 'Aziz', 'Kebagusan 2', 'Futsal', 'Rabu', '2019-01-02', '16:00', '17:00', 'Latihan'),
('0002', 'IDPJ001', 'IDW002', 'Rafi', 'Kebagusan1', 'Basket', 'Jumat', '2019-01-18', '16:00', '17:00', 'Latihan'),
('0003', 'IDPJ002', 'IDW003', 'Alfian', 'Kebagusan 4', 'Futsal', 'Selasa', '2019-07-16', '13:00', '14:00', 'Latihan'),
('0004', 'IDPJ002', 'IDW005', 'Ayu', 'Kebagusan 5', 'Menari', 'Kamis', '2019-07-26', '16:00', '18:00', 'Latihan'),
('0005', 'IDPJ001', 'IDW004', 'Siti', 'Kebagusan 3', 'Basket', 'Sabtu', '2019-07-20', '17:00', '19:00', 'Latihan'),
('0006', 'IDPJ001', 'IDW001', 'Aziz', 'Kebagusan 2', 'Futsal', 'Rabu', '2019-07-17', '19:00', '20:00', 'Lomba'),
('0007', 'IDPJ001', 'IDW005', 'Ayu', 'Kebagusan 5', 'Voli', 'Sabtu', '2019-07-27', '16:00', '17:00', 'Lomba'),
('0008', 'IDPJ001', 'IDW001', 'Aziz', 'Kebagusan 2', 'Futsal', 'Rabu', '2019-07-17', '15:00', '16:00', 'Lomba');

-- --------------------------------------------------------

--
-- Table structure for table `datapenanggungjawab`
--

CREATE TABLE IF NOT EXISTS `datapenanggungjawab` (
  `idpenanggungjawab` varchar(50) NOT NULL,
  `namapenanggungjawab` varchar(100) NOT NULL,
  `tempatlahir` varchar(100) NOT NULL,
  `tanggallahir` date NOT NULL,
  `jeniskelamin` varchar(20) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `idpetugas` varchar(50) NOT NULL,
  `namapetugas` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datapenanggungjawab`
--

INSERT INTO `datapenanggungjawab` (`idpenanggungjawab`, `namapenanggungjawab`, `tempatlahir`, `tanggallahir`, `jeniskelamin`, `alamat`, `idpetugas`, `namapetugas`) VALUES
('IDPJ001', 'Yusuf', 'Jakarta', '1990-07-11', 'PRIA', 'Kalibata', 'IDP001', 'Darmawan'),
('IDPJ002', 'Rahma', 'Jakarta', '1995-02-13', 'WANITA', 'Pasar Minggu', 'IDP001', 'Darmawan');

-- --------------------------------------------------------

--
-- Table structure for table `datapetugas`
--

CREATE TABLE IF NOT EXISTS `datapetugas` (
  `idpetugas` varchar(100) NOT NULL,
  `namapetugas` varchar(200) NOT NULL,
  `jeniskelamin` varchar(20) NOT NULL,
  `tempatlahir` varchar(100) NOT NULL,
  `tanggallahir` date NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datapetugas`
--

INSERT INTO `datapetugas` (`idpetugas`, `namapetugas`, `jeniskelamin`, `tempatlahir`, `tanggallahir`, `alamat`) VALUES
('IDP001', 'Darmawan', 'PRIA', 'Grobogan', '1997-01-05', 'Komplek Batan'),
('IDP002', 'Yusuf', 'PRIA', 'Jakarta', '1990-07-11', 'Kalibata'),
('IDP003', 'Rahma', 'WANITA', 'Jakarta', '1995-02-13', 'Pasar Minggu'),
('IDP004', 'Sintia', 'WANITA', 'Jakarta', '1999-07-03', 'Pasar Rebo'),
('IDP005', 'Bayu', 'PRIA', 'Jakarta', '1997-08-12', 'Pejaten Barat');

-- --------------------------------------------------------

--
-- Table structure for table `datasumbangan`
--

CREATE TABLE IF NOT EXISTS `datasumbangan` (
  `nosumbang` varchar(50) NOT NULL,
  `idwarga` varchar(50) NOT NULL,
  `namapenyumbang` varchar(100) NOT NULL,
  `jeniskelamin` varchar(50) NOT NULL,
  `sumbangan` varchar(100) NOT NULL,
  `jumlah` varchar(100) NOT NULL,
  `hari` varchar(100) NOT NULL,
  `tanggal` date NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `idpetugas` varchar(100) NOT NULL,
  `namapetugas` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datasumbangan`
--

INSERT INTO `datasumbangan` (`nosumbang`, `idwarga`, `namapenyumbang`, `jeniskelamin`, `sumbangan`, `jumlah`, `hari`, `tanggal`, `alamat`, `idpetugas`, `namapetugas`) VALUES
('0001', 'IDW001', 'Alfian', 'PRIA', 'Tanaman', '5', 'Rabu', '2019-07-09', 'Kebagusan 1', 'IDP001', 'Darmawan'),
('0004', 'IDW004', 'Wawann', 'PRIA', 'Bola', '4', 'Rabu', '2019-07-17', 'Jakarta', 'IDP001', 'Darmawan'),
('0005', 'IDW001', 'Alfiann', 'PRIA', 'Jam', '2', 'Selasa', '2019-07-09', 'Jakarta', 'IDP005', 'Bayu'),
('0006', 'IDW002', 'Ranti', 'WANITA', 'Tanaman', '10', 'Selasa', '2019-07-16', 'Kabagusan 2', 'IDP002', 'Yusuf');

-- --------------------------------------------------------

--
-- Table structure for table `datawarga`
--

CREATE TABLE IF NOT EXISTS `datawarga` (
  `idwarga` varchar(50) NOT NULL,
  `namawarga` varchar(100) NOT NULL,
  `tempatlahir` varchar(100) NOT NULL,
  `tanggallahir` date NOT NULL,
  `jeniskelamin` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datawarga`
--

INSERT INTO `datawarga` (`idwarga`, `namawarga`, `tempatlahir`, `tanggallahir`, `jeniskelamin`, `alamat`) VALUES
('IDW001', 'Aziz', 'Jakarta', '1997-07-16', 'PRIA', 'Kebagusan 2'),
('IDW002', 'Rafi', 'Jakarta', '1997-05-20', 'PRIA', 'Kebagusan1'),
('IDW003', 'Alfian', 'Jakarta', '2013-10-15', 'PRIA', 'Kebagusan 4'),
('IDW004', 'Siti', 'Jakarta', '1998-12-29', 'WANITA', 'Kebagusan 3'),
('IDW005', 'Ayu', 'Jakarta', '2010-07-10', 'WANITA', 'Kebagusan 5');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin'),
('admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datakegiatan`
--
ALTER TABLE `datakegiatan`
  ADD PRIMARY KEY (`no`);

--
-- Indexes for table `datapenanggungjawab`
--
ALTER TABLE `datapenanggungjawab`
  ADD PRIMARY KEY (`idpenanggungjawab`);

--
-- Indexes for table `datapetugas`
--
ALTER TABLE `datapetugas`
  ADD PRIMARY KEY (`idpetugas`);

--
-- Indexes for table `datasumbangan`
--
ALTER TABLE `datasumbangan`
  ADD PRIMARY KEY (`nosumbang`);

--
-- Indexes for table `datawarga`
--
ALTER TABLE `datawarga`
  ADD PRIMARY KEY (`idwarga`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
