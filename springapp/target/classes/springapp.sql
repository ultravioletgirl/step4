-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-05-2014 a las 10:47:44
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- SET time_zone = "+00:00";
-- DROP DATABASE springapp2;

DROP DATABASE springapp;
CREATE DATABASE springapp;

GRANT ALL ON springapp.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON springapp.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';
USE springapp;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `springapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `idClient` varchar(9) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investmentfund`
--

CREATE TABLE IF NOT EXISTS `investmentfund` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idInvestmentFund` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `IF_Amount` int(11) NOT NULL,
  `IF_TotalPrice` double NOT NULL,
  `IF_fee` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `IF_cancellationFee` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `IF_profitability` double NOT NULL,
  `IF_PurchasedAmount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investmentfundpack`
--

CREATE TABLE IF NOT EXISTS `investmentfundpack` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idInvestmentFundPack` varchar(150) NOT NULL DEFAULT 'null',
  `amountDB` int(10) NOT NULL,
  `idClient` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `investmentfundpack`
--
ALTER TABLE `investmentfundpack`
  ADD CONSTRAINT `fk_INVESTMENTFUNDPACK_CLIENT1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
