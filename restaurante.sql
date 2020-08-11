-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 02/04/2015 às 16h17min
-- Versão do Servidor: 5.5.20
-- Versão do PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `restaurante`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alimentos`
--

CREATE TABLE IF NOT EXISTS `alimentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `alimentos`
--

INSERT INTO `alimentos` (`id`, `nome`, `preco`) VALUES
(1, 'pizte', 21),
(2, 'Água', 2),
(3, 'Macarrão', 14.5),
(4, 'Pastel Misto', 6.5),
(5, 'salami', 23.32);

-- --------------------------------------------------------

--
-- Estrutura da tabela `listarfuncionario`
--

CREATE TABLE IF NOT EXISTS `listarfuncionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sexo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `rg` varchar(14) COLLATE utf8_unicode_ci NOT NULL,
  `cpf` varchar(14) COLLATE utf8_unicode_ci NOT NULL,
  `telefone` varchar(14) COLLATE utf8_unicode_ci NOT NULL,
  `data_nasc` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `rua` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `bairro` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `cep` varchar(14) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `listarfuncionario`
--

INSERT INTO `listarfuncionario` (`id`, `sexo`, `nome`, `rg`, `cpf`, `telefone`, `data_nasc`, `rua`, `bairro`, `cep`, `email`) VALUES
(1, 'Masculino', 'Vinícius Nunes Barbosa', '2007286639-4', '070.187.023-05', '96094289', '04/08/1998', 'Teófilo Pinto ,152', 'Farias Brito', '62800-000', 'vinicius@hotmail.com'),
(3, 'Masculino', 'wallacelucas', '1222212122-2', '21212121212', '1212121212', '21/21/2121', 'w12w2w12s', 'swswqwqsw', '121212121212', 'edeweq@hotmlai.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `listarpedido`
--

CREATE TABLE IF NOT EXISTS `listarpedido` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Mesa` int(4) NOT NULL,
  `CodPedido` int(10) NOT NULL,
  `pedido` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `quantidade` int(3) NOT NULL,
  `preco` double NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

--
-- Extraindo dados da tabela `listarpedido`
--

INSERT INTO `listarpedido` (`Id`, `Mesa`, `CodPedido`, `pedido`, `quantidade`, `preco`, `total`) VALUES
(13, 1, 3, 'Macarrão', 2, 14.5, 29),
(14, 1, 2, 'Água', 2, 2, 4),
(15, 1, 2, 'Água', 2, 2, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `senha` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`id`, `usuario`, `senha`) VALUES
(1, 'nunes', 123456),
(2, 'wallace', 1212);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
