# TP 2 et 4 de SIR

A la découverte de JPA et de Servlet

Binôme : Dimas ESPINASSE - Inès ATMANI

## Tuto

Etape 1 : Lancer la classe JpaTest qui se trouve dans le package jpa

## Liste des packages

- "dao" :
Contient les classes se basant sur le pattern DAO (Data Access Object) afin que les données de la base puissent être utilisées via des objets Java 
- "domain"
Conformément au diagramme UML fourni dans l'énoncé, nous avons choisi de créer les classes Person, Home, Heater, ElectronicDevice et en bonus pour gérer l'héritage, la classe SmartDevice
- "jpa"
Contient la classe de service permettant de peupler la base mais aussi de faire des requêtes sur la base de données
- "rest"
Contient les routes de chaque entité du package domain ainsi que le type de requête HTTP.
Pour accéder aux objets, il faut envoyer une requête GET de cette forme : http://localhost:8080/<objet voulu>/
Le formulaire pour créer une personne : http://localhost:8080/index.html 

- "servlet"
Contient deux classes, une on l'on a utilisé un affichage en list (UserInfo1) et l'autre (UserInfo2) en json en utilisant les méthodes du package DAO correspondantes afin d'afficher les personnes présentent dans la base de données
De plus, la classe UserInfo2 contient une méthode permettant d'ajouter une personne dans la bdd


