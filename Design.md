## Liste des packages

- "dao" :
Contient les classes se basant sur le pattern DAO (Data Access Object) afin que les données de la base puissent être utilisées via des objets Java 
- "domain"
Conformément au diagramme UML fourni dans l'énoncé, nous avons choisi de créer les classes Person, Home, Heater, ElectronicDevice et en bonus pour gérer l'héritage, la classe SmartDevice
- "jpa"
Contient la classe de service permettant de peupler la base mais aussi de faire des requêtes sur la base de données
- "rest"
Contient les routes de chaque entité du package domain ainsi que le type de requête HTTP.
Pour accéder aux objets, il faut envoyer une requête GET de cette forme : http://localhost:8080/**objet voulu**/
Le formulaire pour créer une personne : http://localhost:8080/index.html 

- "servlet"
Contient deux classes, une on l'on a utilisé un affichage en list (UserInfo1) et l'autre (UserInfo2) en json en utilisant les méthodes du package DAO correspondantes afin d'afficher les personnes présentent dans la base de données
De plus, la classe UserInfo2 contient une méthode permettant d'ajouter une personne dans la bdd

# Représentation des classes 

# La classe ElectronicDevice 

La classe ElectronicDevice est composée des attribus suivants:
Id et consommation , qui représente la consommation moyenne en Watt/h
et un attribut de type personne.

Nous avons ajouté les annotations suivantes:
@Entity : pour définir l'entité ElectronicDevice
@Id @GeneratedValue: Pour générer l'id automatiquement
@ManyToOne: Une personne peut avoir une ou plusieurs équipements électroniques 

# La classe Heater

La classe Heater est composée des attributs suivants: id, nom, consommation et un attribut de type home.

Nous avons ajouté les annotations suivantes:
@Entity : pour définir l'entitée Heater
@Id @GeneratedValue: Pour générer l'id automatiquement
@ManyToOne: Une résidence peut avoir une ou plusieurs heaters. 

# La classe Home

La classe Home est composée des attributs suivants : id généré automatiquemnt, nombre de pièces, la taille, collection de heaters et de personnes
Une résidence peut avoir une ou plusieurs heaters. 
   
Nous avons ajouté les annotations suivantes:

@Entity : pour définir entité Home
@Id @GeneratedValue: Pour générer l'id automatiquement
@OneToMany(mappedBy="home", cascade=CascadeType.PERSIST): Pour exprimer la relation entre home et heaters, une résidence peut avoir un ou plusieurs heaters.
@ManyToMany: Une maison peut avoir plusieurs personnes


### La classe Person


La classe Personne est composée des attributs suivants : id généré automatiquemnt, nom, prenom, email.
La classe Personne a trois collection : homes friends et devices.

Une personne peut avoir un ou plusieurs amis.
Une personne peut avoir une ou plusieurs résidences.
Une personne peut avoir un ou plusieurs équipements électroniques.
  
Nous avons ajouté les annotations suivantes:

@Entity : pour définir une entité
@Id @GeneratedValue: Pour générer l'id automatiquement
@OneToMany (mappedBy="consumers", cascade=CascadeType.PERSIST): Pour exprimer la relation une ou plusieurs entre l'entité personne et les autres entités homes et devices.


# La classe SmartDevices
Cette classe représente la classe mère pour les deux classes : Heater et ElectronicDevice. 
public class ElectronicDevice extends SmartDevices mais ça nous a généré un problème du coup on a enlevé le "extends" dans la classe Heater et ElectronicDevice
 
# La classe de service

La classe JpaTest est composée d'un attribut de type EntityManager.

EntityManager nous permet de faire les opérations de persistance
 
Le code pour créer des personnes :
 
		Person p1 = new Person("Ines", "Atm", "ineskatm@gmail.com");
		Person p2 = new Person("Dimas", "Do", "dimas35000@gmail.com ");
		
		
L'utilisation des criteria query:

        Collection<Person> persons = manager.createQuery( "SELECT p FROM Person p", Person.class).getResultList();
		
		System.out.println("Nombre de personnes : " + persons.size());
		
		for (Person p : persons) {
			System.out.println("Personne : " + persons.toString());
		}

