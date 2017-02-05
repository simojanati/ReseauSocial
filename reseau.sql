-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 05 Février 2017 à 05:08
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `reseau`
--

-- --------------------------------------------------------

--
-- Structure de la table `affecter`
--

CREATE TABLE `affecter` (
  `username` varchar(255) NOT NULL,
  `nom_competence` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `affecter`
--

INSERT INTO `affecter` (`username`, `nom_competence`) VALUES
('janati', 'JAVA'),
('janati', 'JAVA EE'),
('janati', 'SPRING MVC'),
('kadani', 'JAVA EE'),
('kadani', 'PHP');

-- --------------------------------------------------------

--
-- Structure de la table `attribuer`
--

CREATE TABLE `attribuer` (
  `date_attribution` datetime DEFAULT NULL,
  `id_etudiant` varchar(255) NOT NULL,
  `id_classe` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `attribuer`
--

INSERT INTO `attribuer` (`date_attribution`, `id_etudiant`, `id_classe`) VALUES
('2017-02-01 00:00:00', 'bachir', 1),
('2017-02-01 00:00:00', 'janati', 1),
('2017-02-01 00:00:00', 'kadani', 1),
('2017-02-01 00:00:00', 'khatiri', 1),
('2017-02-01 00:00:00', 'sabrine', 1),
('2017-02-01 00:00:00', 'janati', 2);

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `id_classe` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `date_creation` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `professeur` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `classe`
--

INSERT INTO `classe` (`id_classe`, `nom`, `photo`, `date_creation`, `description`, `professeur`) VALUES
(1, '5 ILDW', '/dist/img/groupe.png', '2017-01-30 00:00:00', 'Groupe 5 éme année génie logiciel et developpement web', 'habib'),
(2, 'M2 Miage', '/dist/img/groupe.png', '2017-01-30 00:00:00', '2 éme année master de méthode informatique appliquer à la gestion des entreprises', 'habib');

-- --------------------------------------------------------

--
-- Structure de la table `commenter`
--

CREATE TABLE `commenter` (
  `id_commentaire` bigint(20) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `id_poste` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commenter`
--

INSERT INTO `commenter` (`id_commentaire`, `message`, `date`, `id_poste`, `username`) VALUES
(1, 'test commentaire 1', '2017-02-07 00:00:00', 49, 'janati'),
(2, 'test com 2', '2017-02-06 00:00:00', 37, 'kadani'),
(3, 'test comment 2', '2017-02-05 00:34:09', 49, 'janati'),
(4, 'test hhhhhhhhhhhhhhhhh', '2017-02-05 00:59:54', 41, 'janati'),
(5, 'yes mister kadani', '2017-02-05 01:02:03', 37, 'janati'),
(6, 'test prof comment', '2017-02-05 02:38:24', 36, 'habib'),
(7, 'bon image', '2017-02-05 02:39:08', 48, 'habib');

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

CREATE TABLE `competence` (
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `competence`
--

INSERT INTO `competence` (`nom`) VALUES
('JAVA'),
('JAVA EE'),
('PHP'),
('SPRING MVC'),
('SQL');

-- --------------------------------------------------------

--
-- Structure de la table `etat_amis`
--

CREATE TABLE `etat_amis` (
  `etat` varchar(255) DEFAULT NULL,
  `username_utilisateur_inviteur` varchar(255) NOT NULL,
  `username_utilisateur_inviter` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etat_amis`
--

INSERT INTO `etat_amis` (`etat`, `username_utilisateur_inviteur`, `username_utilisateur_inviter`) VALUES
('refuser', 'janati', 'bachir'),
('accepter', 'habib', 'janati'),
('accepter', 'khatiri', 'janati'),
('accepter', 'janati', 'kadani'),
('accepter', 'sabrine', 'kadani');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id_evenement` bigint(20) NOT NULL,
  `mois` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `jour` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `messagerie`
--

CREATE TABLE `messagerie` (
  `id_mesagerie` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `username_utilisateur_envoie` varchar(255) DEFAULT NULL,
  `username_utilisateur_recoie` varchar(255) DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `vu` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `id_notification` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `username_utilisateur` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `poste`
--

CREATE TABLE `poste` (
  `id_poste` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `id_type` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `lien` varchar(255) DEFAULT NULL,
  `nom_lien` varchar(255) DEFAULT NULL,
  `username_tage` varchar(255) DEFAULT NULL,
  `groupe` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `poste`
--

INSERT INTO `poste` (`id_poste`, `date`, `statut`, `id_type`, `username`, `lien`, `nom_lien`, `username_tage`, `groupe`) VALUES
(1, '2017-01-31 00:00:00', 'ana bachir  hhhhhhh :)', 1, 'bachir', NULL, NULL, NULL, 0),
(2, '2017-01-31 00:05:00', 'ana kadani lmola9ab b gipsy king ljil ljadid ', 1, 'kadani', NULL, NULL, NULL, 0),
(3, '2017-01-31 00:11:00', 're kandhak m3akom ', 1, 'bachir', NULL, NULL, NULL, 0),
(4, '2017-01-31 00:17:00', 'ana re 7ma9 madiwch 3lya', 1, 'khatiri', NULL, NULL, NULL, 0),
(5, '2017-01-31 00:24:00', ' kijak statuts  hhhhhhhhh', 1, 'janati', NULL, NULL, NULL, 0),
(6, '2017-01-31 00:13:00', 'statut sabrine', 1, 'sabrine', NULL, NULL, NULL, 0),
(7, '2017-01-31 05:41:10', 'test ajouter statut', 1, 'janati', NULL, NULL, NULL, 0),
(8, '2017-01-31 07:04:13', 'wawawawawawa', 1, 'kadani', NULL, NULL, 'janati', 0),
(9, '2017-01-31 16:23:36', 'kadani', 1, 'janati', NULL, NULL, NULL, 0),
(10, '2017-01-31 16:43:13', 'HHHHHHHHH\r\n', 1, 'kadani', NULL, NULL, NULL, 0),
(11, '2017-01-31 17:23:42', 'hh', 1, 'kadani', NULL, NULL, NULL, 0),
(14, '2017-02-01 05:59:34', 'test cv pdf', 3, 'janati', '/dist/tmpFiles/CV.pdf', 'CV.pdf', NULL, 0),
(16, '2017-02-01 06:26:50', 'oussama hhhh', 2, 'janati', '/dist/imagesPoste/tompo_oussama.png', 'tompo_oussama.png', NULL, 0),
(17, '2017-02-01 06:30:03', 'nabil proget', 2, 'janati', '/dist/imagesPoste/1.PNG', '1.PNG', NULL, 0),
(18, '2017-02-01 15:05:31', 'badiaa', 3, 'janati', '/dist/tmpFiles/110305_164254.jpg', '110305_164254.jpg', NULL, 0),
(19, '2017-02-01 16:05:06', '300 DH', 1, 'kadani', NULL, NULL, NULL, 0),
(22, '2017-02-02 23:24:30', 'test final fichier', 3, 'janati', '/dist/tmpFiles/branche de droit.docx', 'branche de droit.docx', NULL, 0),
(23, '2017-02-03 00:29:11', 'test text', 1, 'janati', NULL, NULL, NULL, 0),
(24, '2017-02-03 00:29:26', 'test text 2', 1, 'janati', NULL, NULL, NULL, 0),
(25, '2017-02-03 00:29:41', 'test img', 2, 'janati', '/dist/imagesPoste/3dfa81df00.jpg', '3dfa81df00.jpg', NULL, 0),
(26, '2017-02-03 00:36:23', 'test', 2, 'janati', '/dist/imagesPoste/3.jpg', '3.jpg', NULL, 0),
(27, '2017-02-03 00:43:48', '', 3, 'janati', '/dist/tmpFiles/Les élèves qui réussissent vont en cours.docx', 'Les élèves qui réussissent vont en cours.docx', NULL, 0),
(28, '2017-02-03 01:00:30', 'test ico', 2, 'janati', '/dist/imagesPoste/icon.ico', 'icon.ico', NULL, 0),
(29, '2017-02-03 02:46:18', 'test image', 2, 'janati', '/dist/imagesPoste/~OBOB700.JPG', '~OBOB700.JPG', NULL, 0),
(30, '2017-02-03 02:47:12', '', 2, 'janati', '/dist/imagesPoste/100marocain.jpg', '100% marocain.jpg', NULL, 0),
(34, '2017-02-03 03:23:32', '', 2, 'janati', '/dist/imagesPoste/18_kids_16957J.jpg', '18_kids_16957J.jpg', NULL, 0),
(35, '2017-02-03 03:33:00', '', 3, 'janati', '/dist/tmpFiles/Logo-Pdf(1).pdf', 'Logo-Pdf(1).pdf', NULL, 0),
(36, '2017-02-03 18:17:08', 'test tag 1', 1, 'janati', NULL, NULL, 'kadani', 0),
(37, '2017-02-22 00:00:00', 'test statut groupe', 1, 'janati', NULL, NULL, NULL, 1),
(39, '2017-02-04 03:01:03', 'test kadani statut group', 1, 'kadani', NULL, NULL, NULL, 1),
(40, '2017-02-04 03:11:40', '', 3, 'kadani', '/dist/tmpFiles/kadani_test.txt', 'kadani_test.txt', NULL, 1),
(41, '2017-02-04 10:52:03', '', 2, 'sabrine', '/dist/imagesPoste/sabrine_1.jpg', 'sabrine_1.jpg', NULL, 0),
(48, '2017-02-04 15:40:02', '', 2, 'janati', '/dist/imagesPoste/janati_12000.jpg', 'janati_12000.jpg', NULL, 0),
(49, '2017-02-04 16:10:08', 'test tag hhhhhh', 1, 'kadani', NULL, NULL, 'janati', 0);

-- --------------------------------------------------------

--
-- Structure de la table `relation`
--

CREATE TABLE `relation` (
  `id_poste` bigint(20) NOT NULL,
  `id_classe` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `relation`
--

INSERT INTO `relation` (`id_poste`, `id_classe`) VALUES
(37, 1),
(39, 1),
(40, 1);

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `roles`
--

INSERT INTO `roles` (`role`) VALUES
('ADMIN'),
('ETUDIANT'),
('PROFESSEUR');

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE `type` (
  `id_type` bigint(20) NOT NULL,
  `message` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type`
--

INSERT INTO `type` (`id_type`, `message`) VALUES
(1, 'Text'),
(2, 'Image'),
(3, 'Fichier');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `type_utilisateur` varchar(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `active` bit(1) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `branche` varchar(255) DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `ecoles` varchar(255) DEFAULT NULL,
  `ecole` varchar(255) DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `date_creation` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`type_utilisateur`, `username`, `active`, `adresse`, `branche`, `date_naissance`, `nom`, `password`, `pays`, `photo`, `prenom`, `tel`, `ville`, `ecoles`, `ecole`, `fonction`, `date_creation`) VALUES
('Etudiant', 'bachir', b'1', 'agdal', '5 ILWD', '1992-01-01 00:00:00', 'Elyacoubi', 'a452f8e8f18cd553499e9a3aa077f62d', 'Maroc', '/dist/img/avatar6.png', 'Bachir', '0688000088', 'Tifelt', NULL, 'ISGA', 'Futur développeur web', '2017-01-31'),
('Professeur', 'habib', b'1', 'agdal', 'branche', '1975-04-02 00:00:00', 'belahmar', '1391921ec73a2f5dff54e075bbda7487', 'Maroc', '/dist/img/avatar6.png', 'habib', '0655889933', 'Rabat', 'ISGA, EMSI, Unicérsite Mohamed 5', NULL, 'Professeur', '2017-02-05'),
('Etudiant', 'janati', b'1', 'kouass cym', 'M2 Miage', '1992-11-17 00:00:00', 'janati', '0a23278227221a805eeb6549e072acb1', 'Maroc', '/dist/img/janati.jpg', 'simo', '0611445522', 'Rabat', NULL, 'université de lorraine', 'Futur développeur web', '2017-01-02'),
('Etudiant', 'kadani', b'1', 'sid elabd harhoura', '5 ILDW', '1993-01-01 00:00:00', 'kadani', '869c6b3f2a30dc83d767820a63894a6c', 'Maroc', '/dist/img/kadani.jpg', 'anas', '0655996633', 'Temara', NULL, 'ISGA', 'Futur développeur web', '2017-01-16'),
('Etudiant', 'khatiri', b'1', 'diour jamaa', '5 ILWD', '1990-01-01 00:00:00', 'Khatiri', '10a6b4bb4a3d253f254a9a19253fe774', 'Maroc', '/dist/img/khatiri.jpg', 'Ismail', '0688997788', 'Nador', NULL, 'ISGA', 'Futur développeur web', '2017-01-31'),
('Etudiant', 'sabrine', b'1', 'gich lwdaya', '5 ILWD', '1994-01-01 00:00:00', 'Talamcamani', '09017c56d784333dee9f6d735efef96a', 'Maroc', '/dist/img/sabrine.jpg', 'Sabrine', '0688944488', 'Temara', NULL, 'ISGA', 'Futur développeur web', '2017-01-31');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur_roles`
--

CREATE TABLE `utilisateur_roles` (
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur_roles`
--

INSERT INTO `utilisateur_roles` (`role`, `username`) VALUES
('ETUDIANT', 'bachir'),
('PROFESSEUR', 'habib'),
('ETUDIANT', 'janati'),
('ETUDIANT', 'kadani'),
('ETUDIANT', 'khatiri'),
('ETUDIANT', 'sabrine');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `affecter`
--
ALTER TABLE `affecter`
  ADD PRIMARY KEY (`nom_competence`,`username`),
  ADD KEY `FKdb5kcin501batu4efb80ryvnx` (`username`);

--
-- Index pour la table `attribuer`
--
ALTER TABLE `attribuer`
  ADD PRIMARY KEY (`id_classe`,`id_etudiant`),
  ADD KEY `FK5o62g87b1e5gcm9tuxbe2a6d7` (`id_etudiant`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id_classe`),
  ADD KEY `FK35nymr0ov4i2sd5x3lahqkidl` (`professeur`);

--
-- Index pour la table `commenter`
--
ALTER TABLE `commenter`
  ADD PRIMARY KEY (`id_commentaire`),
  ADD KEY `FKh2rt1ck7si25l0makdy9k1ggk` (`id_poste`),
  ADD KEY `FKpy7j23tgqddq3ooyk6wi203gd` (`username`);

--
-- Index pour la table `competence`
--
ALTER TABLE `competence`
  ADD PRIMARY KEY (`nom`);

--
-- Index pour la table `etat_amis`
--
ALTER TABLE `etat_amis`
  ADD PRIMARY KEY (`username_utilisateur_inviter`,`username_utilisateur_inviteur`),
  ADD KEY `FK4e06r7xylarjaej0iysi7655k` (`username_utilisateur_inviteur`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id_evenement`);

--
-- Index pour la table `messagerie`
--
ALTER TABLE `messagerie`
  ADD PRIMARY KEY (`id_mesagerie`),
  ADD KEY `FK7xtan5oxvaoqdie43w0plqm50` (`username_utilisateur_envoie`),
  ADD KEY `FKgs3n91qtskgbhqfgkcuqko5qo` (`username_utilisateur_recoie`);

--
-- Index pour la table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id_notification`),
  ADD KEY `FKie5kw6lvphsq78cmbh33xfy7w` (`username`),
  ADD KEY `FKl19ou90rosbqwu8gbboabkkaa` (`username_utilisateur`);

--
-- Index pour la table `poste`
--
ALTER TABLE `poste`
  ADD PRIMARY KEY (`id_poste`),
  ADD KEY `FKrv0g7v72lnkf48cxivrxpqsh7` (`id_type`),
  ADD KEY `FKpvymdh46j2mtr2tge2u4cs69r` (`username`),
  ADD KEY `FKqxx41fnoob4lp73h4rdekkuyn` (`username_tage`);

--
-- Index pour la table `relation`
--
ALTER TABLE `relation`
  ADD PRIMARY KEY (`id_classe`,`id_poste`),
  ADD KEY `FKiy4g5os9f6en3s0qr2vky79pp` (`id_poste`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role`);

--
-- Index pour la table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id_type`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `utilisateur_roles`
--
ALTER TABLE `utilisateur_roles`
  ADD PRIMARY KEY (`role`,`username`),
  ADD KEY `FK22b9btn517470yd77mkumivg8` (`username`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id_classe` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `commenter`
--
ALTER TABLE `commenter`
  MODIFY `id_commentaire` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id_evenement` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `messagerie`
--
ALTER TABLE `messagerie`
  MODIFY `id_mesagerie` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `notification`
--
ALTER TABLE `notification`
  MODIFY `id_notification` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `poste`
--
ALTER TABLE `poste`
  MODIFY `id_poste` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT pour la table `type`
--
ALTER TABLE `type`
  MODIFY `id_type` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `affecter`
--
ALTER TABLE `affecter`
  ADD CONSTRAINT `FKdb5kcin501batu4efb80ryvnx` FOREIGN KEY (`username`) REFERENCES `utilisateur` (`username`),
  ADD CONSTRAINT `FKr3el5n8s9x7gv6vdgx9wbwb9j` FOREIGN KEY (`nom_competence`) REFERENCES `competence` (`nom`);

--
-- Contraintes pour la table `attribuer`
--
ALTER TABLE `attribuer`
  ADD CONSTRAINT `FK5o62g87b1e5gcm9tuxbe2a6d7` FOREIGN KEY (`id_etudiant`) REFERENCES `utilisateur` (`username`),
  ADD CONSTRAINT `FKmiwmgd274l6gy67ee3pr9fhgx` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`);

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `FK35nymr0ov4i2sd5x3lahqkidl` FOREIGN KEY (`professeur`) REFERENCES `utilisateur` (`username`);

--
-- Contraintes pour la table `commenter`
--
ALTER TABLE `commenter`
  ADD CONSTRAINT `FKh2rt1ck7si25l0makdy9k1ggk` FOREIGN KEY (`id_poste`) REFERENCES `poste` (`id_poste`),
  ADD CONSTRAINT `FKpy7j23tgqddq3ooyk6wi203gd` FOREIGN KEY (`username`) REFERENCES `utilisateur` (`username`);

--
-- Contraintes pour la table `etat_amis`
--
ALTER TABLE `etat_amis`
  ADD CONSTRAINT `FK4e06r7xylarjaej0iysi7655k` FOREIGN KEY (`username_utilisateur_inviteur`) REFERENCES `utilisateur` (`username`),
  ADD CONSTRAINT `FKok4a5kudu2yibl8hw5mvf2mmx` FOREIGN KEY (`username_utilisateur_inviter`) REFERENCES `utilisateur` (`username`);

--
-- Contraintes pour la table `messagerie`
--
ALTER TABLE `messagerie`
  ADD CONSTRAINT `FK7xtan5oxvaoqdie43w0plqm50` FOREIGN KEY (`username_utilisateur_envoie`) REFERENCES `utilisateur` (`username`),
  ADD CONSTRAINT `FKgs3n91qtskgbhqfgkcuqko5qo` FOREIGN KEY (`username_utilisateur_recoie`) REFERENCES `utilisateur` (`username`);

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `FKie5kw6lvphsq78cmbh33xfy7w` FOREIGN KEY (`username`) REFERENCES `utilisateur` (`username`),
  ADD CONSTRAINT `FKl19ou90rosbqwu8gbboabkkaa` FOREIGN KEY (`username_utilisateur`) REFERENCES `utilisateur` (`username`);

--
-- Contraintes pour la table `poste`
--
ALTER TABLE `poste`
  ADD CONSTRAINT `FKpvymdh46j2mtr2tge2u4cs69r` FOREIGN KEY (`username`) REFERENCES `utilisateur` (`username`),
  ADD CONSTRAINT `FKqxx41fnoob4lp73h4rdekkuyn` FOREIGN KEY (`username_tage`) REFERENCES `utilisateur` (`username`),
  ADD CONSTRAINT `FKrv0g7v72lnkf48cxivrxpqsh7` FOREIGN KEY (`id_type`) REFERENCES `type` (`id_type`);

--
-- Contraintes pour la table `relation`
--
ALTER TABLE `relation`
  ADD CONSTRAINT `FKihuwh7xfupr4xx4u45j84umex` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `FKiy4g5os9f6en3s0qr2vky79pp` FOREIGN KEY (`id_poste`) REFERENCES `poste` (`id_poste`);

--
-- Contraintes pour la table `utilisateur_roles`
--
ALTER TABLE `utilisateur_roles`
  ADD CONSTRAINT `FK22b9btn517470yd77mkumivg8` FOREIGN KEY (`username`) REFERENCES `utilisateur` (`username`),
  ADD CONSTRAINT `FKlwufqm54pnnvxdn1t8u6k5ppm` FOREIGN KEY (`role`) REFERENCES `roles` (`role`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
