# Transaction-Project
## Devoir Transaction réalisé par Souhail El-Yazami

La page [index.html](TransactionFinal/src/main/webapp/index.html) permet d'ajouter les transaction dans la base de données 

![image](https://user-images.githubusercontent.com/63423980/234691750-53f22999-71ee-493b-a979-325f2db94206.png)
Apres la submission du formulaire précédent la servlet [AddServlet](TransactionFinal/src/main/java/main/AddServlet.java) récupére les information du formulaire puis il initialise un objet de de type [Transaction](TransactionFinal/src/main/java/main/Transaction.java)
puis la servlet fait appelle aux methodes du class [TransactionDaoImpl](TransactionFinal/src/main/java/main/TransactionDaoImpl.java)(implementation de l'interface  [TransactionDao](TransactionFinal/src/main/java/main/TransactionDao.java)) afin de créer le design pattern DAO), qui permet d'implementer le JPA d'eclipselink(la configuration se trouve dans le fichier [persistence.xml](TransactionFinal/src/resources/META-INF/persistence.xml)
Le mapping de l'entité se fait par la les annotations **@Entity** et **@ID** pour la clé primaire 

```Java
@Entity
public class Transaction {
	@Id
	String Ref;
	String CompteDeb;
	String CompteCred;
	double Montant;
	String Devise;
	String Type;
	String Date;
  ...
```

Pour l'affichage des données on fait appele au page [display.jsp](TransactionFinal/src/main/webapp/display.jsp) qui récupére les données a partir du base de données MySQL

![image](https://user-images.githubusercontent.com/63423980/234713792-3287320a-2c4c-4a7d-a967-f000a732cfba.png)

**Il faut importer les class qui sont utiliser dans la page**

```jsp
<%@ page import="main.TransactionDao,main.Transaction ,main.TransactionDaoImpl,java.util.List" %>
```

L'application est sécuriser par **KeyCloak** 

![image](https://user-images.githubusercontent.com/63423980/234714519-83a4821f-3d8c-4d9e-ac4e-c2cda45c14e0.png)





