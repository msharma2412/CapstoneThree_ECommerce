		Project Title:CapstoneThree_ECommerce
Purpose of project: Fix errors in the backend for an online store along with adding features to create the categories and adding items to cart.
Image of current website: 

			Methods that fixed the webpage
Phase 1: Missing category feature
General Description for Categories : The website's backend was missing it's CategoriesController and MySqlCategoriesDao. 
CategoriesController: A website's backend is the functional side that the user can not see. It stores and organizes data. We can connect the backend to a website's graphical side using a program called Spring boot. Spring boot connects a website's backends and front ends using a controller class. This class contains endpoints which contains actions that allows the user to find,create, update, and delete features on a website. Usually a person with admin priviledges will be to update, create, and delete those features.
Image of Categories controller:
 
Description of code shown in image: This image features a GetMapping request which means that java will match colums in a MySql if provided. It contains a try and catch method that will handle errors that are made during the implentation or building of this method.

MySqlCategoriesDao: The MySqlCategoriesDao is an interface called DAO(data access object). This a special class in Java that allows users to connect with another program such as MySql. Charts that are listed in My Sql can be connected to Java and utilized in websites using a DAO. We write sql queries in a MySql database that tells Java to search tables in Java and return the items in those tables. We are looking for the shopping website's catagories that are contained in a my sql database.

Image of MySqlCategoriesDao: 
 

Description of code shown in image: This image features a sql query.This query tells java to connect to the my sql database and returns the items requested in that query. It contains a try and catch method that will handle errors that are made during the implentation or building of this method.
Phase 2: Erros in the search function
General Description for Categories : The website's backend was missing it's CategoriesController and MySqlCategoriesDao. 

