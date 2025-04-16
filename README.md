# Gestion des Réservations Universitaires

## Présenté par
- Hamza Abidi
- Rania Maamer
- Nesrine Said
- Aziz Cherni

## Description
Ce projet est une application de gestion des réservations universitaires permettant de gérer les chambres, les étudiants et leurs réservations dans un établissement universitaire.

## Fonctionnalités principales
- Gestion des étudiants (ajout, modification, suppression, consultation)
- Gestion des chambres (ajout, modification, suppression, consultation)
- Gestion des réservations (création, validation, annulation)
- Authentification et contrôle d'accès

## Structure du projet
Le projet est structuré selon l'architecture MVC (Modèle-Vue-Contrôleur) avec les composants suivants:

### Entités
- **Etudiant**
- **Chambre**
- **Reservation**
- **Bloc**
- **Foyer**
- **Université**

### Points notables de l'implémentation
- **Validation du CIN**: Le numéro de carte d'identité nationale (CIN) est contrôlé pour s'assurer qu'il contient exactement 8 chiffres grâce à l'annotation `@Digits(integer = 8, fraction = 0)`.
- **Relations entre entités**: Le système utilise une relation Many-to-Many entre Etudiants et Réservations, permettant à plusieurs étudiants de partager une réservation et à un étudiant d'avoir plusieurs réservations.
- **Gestion des années universitaires**: Les réservations sont liées à une année universitaire spécifique.

## Technologies utilisées
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Jakarta Persistence API
- Jakarta Bean Validation API
- Lombok

## Installation et démarrage
1. Cloner le dépôt
2. Configurer la base de données dans `application.properties`
3. Exécuter `mvn clean install` pour installer les dépendances
4. Lancer l'application avec `mvn spring-boot:run`

## Prérequis
- Java 21 ou supérieur
- Maven
- Base de données compatible (MySQL, PostgreSQL)

## Structure de la base de données
- Tables principales: `etudiant`, `chambre`, `reservation`, `reservation_etudiant` (table de jointure)
- Contraintes et validations implémentées au niveau entité et base de données
