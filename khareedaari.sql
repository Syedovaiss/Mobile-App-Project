-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2020 at 07:01 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `khareedaari`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `firstName` varchar(125) NOT NULL,
  `lastName` varchar(125) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile` varchar(25) NOT NULL,
  `address` text NOT NULL,
  `password` varchar(100) NOT NULL,
  `type` varchar(20) NOT NULL,
  `confirmCode` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `firstName`, `lastName`, `email`, `mobile`, `address`, `password`, `type`, `confirmCode`) VALUES
(5, 'Ovais', 'Akhtar', 'ovais@khareedaari.com', '03362402603', 'abcdefehfrjg', '$5$rounds=535000$/.OCiei8l0vSggqi$Mu7fnX8OVBfUISfjjsfQAptpUJvfw2EUCxRprpIx91B', 'type', '123');

-- --------------------------------------------------------

--
-- Table structure for table `get_categories`
--

CREATE TABLE `get_categories` (
  `id` int(11) NOT NULL,
  `category_name` text NOT NULL,
  `category_image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `get_categories`
--

INSERT INTO `get_categories` (`id`, `category_name`, `category_image`) VALUES
(1, 'T-Shirt', 'http://10.0.2.2:5000/static/uploaded_image/shirt.jpg'),
(2, 'Shoes', 'http://10.0.2.2:5000/static/uploaded_image/shoes.jpg'),
(3, 'Wallet', 'http://10.0.2.2:5000/static/uploaded_image/wallet.jpg'),
(4, 'Belt', 'http://10.0.2.2:5000/static/uploaded_image/belt.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `ofname` text NOT NULL,
  `pid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `oplace` text NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `dstatus` varchar(10) NOT NULL DEFAULT 'no',
  `odate` timestamp NOT NULL DEFAULT current_timestamp(),
  `ddate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `pName` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `description` text NOT NULL,
  `available` int(11) NOT NULL,
  `category` varchar(100) NOT NULL,
  `item` varchar(100) NOT NULL,
  `pCode` varchar(20) NOT NULL,
  `picture` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `pName`, `price`, `description`, `available`, `category`, `item`, `pCode`, `picture`, `date`) VALUES
(22, 'Printed T-Shirt', 500, 'blue color ki t shirt hai bhai', 0, 'tshirt', 'Shirt', '0029', 'images.jpg', '2019-12-18 18:21:30'),
(23, 'Shoes', 5000, 'Formal Shoes Brown Color', 100, 'shoes', 'Shoes', '0029', 'images_(1).jpg', '2019-12-18 18:50:41'),
(24, 'Formal Shoe', 5000, 'Formal Shoe Brown Color', 100, 'tshirt', 'Shoes', '0030', 'image.jpg', '2019-12-18 18:51:52'),
(25, 'LV Belt', 1200, 'louis vuitton imported belt', 20, 'belt', 'LV-Belt', '1234556', 'belt.jpg', '2019-12-18 19:02:21'),
(26, 'Leather Wallet ****buy wallet get watch free*****', 649, 'Leather wallet\r\nget watch free', 10, 'tshirt', 'wallet', '001', 'wallet.jpg', '2019-12-18 19:03:37'),
(27, 'Wallet', 2148, 'ljdflsadfl', 12, 'wallet', 'FDF', '132', 'wallet.jpg', '2019-12-18 19:05:29'),
(28, 'BELT', 2147483647, 'djfsdkjgsd cjsf38924534 tvkf wdgd', 1, 'belt', 'fgdg', '132145', 'belt.jpg', '2019-12-18 19:05:52'),
(29, 'shoe', 238, 'ldvnosdvos', 34091, 'shoes', 'Shoes', '45', 'image.jpg', '2019-12-18 19:06:23'),
(30, 'Belt-LG', 12000, 'Brown color ki belt hai', 200, 'belt', 'Belt', '32423', 'images.jpg', '2019-12-19 22:29:48'),
(31, 'sddd', 21, 'eqwr', 10, 'tshirt', '12sad', '242', 'http://127.0.0.1:5000/static/uploaded_image/splash.png', '2019-12-28 18:24:19'),
(32, 'Dummy Product', 499, 'This is a dummy product', 10, 'shoes', 'Shoes', '1234', 'http://127.0.0.1:5000/static/uploaded_image/slide_two.png', '2019-12-28 18:28:04'),
(33, 'Dummy Belt', 199, 'This is a test product', 12, 'belt', 'belt', '0', 'http://127.0.0.1:5000/static/uploaded_image/slide3.png', '2019-12-28 18:33:27'),
(34, 'Shayan', 1200, 'Shayan .c.dfgghrgherh', 100, 'wallet', 'Wallet', '1234', 'http://127.0.0.1:5000/static/uploaded_image/splash_screen.png', '2020-01-02 12:49:55'),
(35, 'Dummy Product', 123, 'abcdefghijkl', 100, 'tshirt', 'TShirt', '123454321', 'https://127.0.0.1:5000/static/uploaded_image/Web_1920_1.png', '2020-01-05 19:49:08');

-- --------------------------------------------------------

--
-- Table structure for table `product_level`
--

CREATE TABLE `product_level` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `v_shape` varchar(10) NOT NULL DEFAULT 'no',
  `polo` varchar(10) NOT NULL DEFAULT 'no',
  `clean_text` varchar(10) NOT NULL DEFAULT 'no',
  `design` varchar(10) NOT NULL DEFAULT 'no',
  `chain` varchar(10) NOT NULL DEFAULT 'no',
  `leather` varchar(10) NOT NULL DEFAULT 'no',
  `hook` varchar(10) NOT NULL DEFAULT 'no',
  `color` varchar(10) NOT NULL DEFAULT 'no',
  `formal` varchar(10) NOT NULL DEFAULT 'no',
  `converse` varchar(10) NOT NULL DEFAULT 'no',
  `loafer` varchar(10) NOT NULL DEFAULT 'no'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_level`
--

INSERT INTO `product_level` (`id`, `product_id`, `v_shape`, `polo`, `clean_text`, `design`, `chain`, `leather`, `hook`, `color`, `formal`, `converse`, `loafer`) VALUES
(22, 22, 'yes', 'no', 'no', 'yes', 'no', 'no', 'no', 'no', 'no', 'no', 'no'),
(23, 23, 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'yes', 'no', 'no'),
(24, 24, 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no'),
(25, 25, 'no', 'no', 'no', 'no', 'no', 'yes', 'no', 'no', 'no', 'no', 'no'),
(26, 26, 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no'),
(27, 27, 'no', 'no', 'no', 'yes', 'yes', 'yes', 'no', 'no', 'no', 'no', 'no'),
(28, 28, 'no', 'no', 'no', 'yes', 'no', 'yes', 'yes', 'yes', 'no', 'no', 'no'),
(29, 29, 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'yes', 'no', 'no'),
(30, 30, 'no', 'no', 'no', 'no', 'no', 'yes', 'yes', 'no', 'no', 'no', 'no'),
(31, 31, 'no', 'no', 'yes', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no'),
(32, 32, 'no', 'no', 'no', 'no', 'no', 'yes', 'no', 'no', 'yes', 'no', 'yes'),
(33, 33, 'no', 'no', 'no', 'yes', 'no', 'yes', 'yes', 'yes', 'no', 'no', 'no'),
(34, 34, 'no', 'no', 'no', 'yes', 'yes', 'yes', 'no', 'no', 'no', 'no', 'no'),
(35, 35, 'no', 'yes', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `product_view`
--

CREATE TABLE `product_view` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(100) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `reg_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `online` varchar(1) NOT NULL DEFAULT '0',
  `activation` varchar(3) NOT NULL DEFAULT 'yes'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `username`, `password`, `mobile`, `reg_time`, `online`, `activation`) VALUES
(16, 'Syed Ovais Akhtar', 'ovaisakhtar97@gmail.com', 'syedovaiss', '$5$rounds=535000$nb9J2JvLNbjdEBHH$vc4GcU8hbDvHnn74znu8cluHLlK0jINEAMiREZSs568', '03362402603', '2019-12-21 19:08:09', '0', 'yes'),
(17, 'Shayan Ahmed ', 'sp16bs0064@maju.edu.pk', 'shayan123', '$5$rounds=535000$ebcE7AhYbKVCVJHh$mrVITpxi1CBUMT0BUZNTuxhs/KOJj/0JCj9E0ff2Fr6', '03462482060', '2020-01-02 12:51:34', '1', 'yes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `get_categories`
--
ALTER TABLE `get_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_level`
--
ALTER TABLE `product_level`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_view`
--
ALTER TABLE `product_view`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `get_categories`
--
ALTER TABLE `get_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `product_level`
--
ALTER TABLE `product_level`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `product_view`
--
ALTER TABLE `product_view`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
