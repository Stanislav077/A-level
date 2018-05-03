-- phpMyAdmin SQL Dump
-- version 4.0.10.10
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Время создания: Май 04 2018 г., 02:11
-- Версия сервера: 5.5.45
-- Версия PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `testjava`
--

-- --------------------------------------------------------

--
-- Структура таблицы `tables`
--

CREATE TABLE IF NOT EXISTS `tables` (
  `id_table_name` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_table_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Дамп данных таблицы `tables`
--

INSERT INTO `tables` (`id_table_name`, `table_name`) VALUES
(1, 'test'),
(2, 'test2'),
(4, 'teststt'),
(5, 'sta'),
(6, 'stanislav');

-- --------------------------------------------------------

--
-- Структура таблицы `tables_value`
--

CREATE TABLE IF NOT EXISTS `tables_value` (
  `tabels_id` int(11) NOT NULL AUTO_INCREMENT,
  `row_name` varchar(255) DEFAULT NULL,
  `row_value` varchar(255) NOT NULL,
  `table_name_id` varchar(11) NOT NULL,
  PRIMARY KEY (`tabels_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=28 ;

--
-- Дамп данных таблицы `tables_value`
--

INSERT INTO `tables_value` (`tabels_id`, `row_name`, `row_value`, `table_name_id`) VALUES
(15, 'Row_1', 'str', '1'),
(16, 'Row_0', '123', '1'),
(17, 'Row_1', 'no', '2'),
(18, 'Row_0', 'yes', '2'),
(25, 'Row_0', '1', '4'),
(26, 'Row_1', 'stas2', '6'),
(27, 'Row_0', 'stas1', '6');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
