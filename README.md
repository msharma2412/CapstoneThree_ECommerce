![Readme screeshop 1](https://github.com/msharma2412/CapstoneThree_ECommerce/assets/166542550/62a2c52c-76ef-43c4-86af-2768d03a57f7)
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
Phase 2: Errors in the search function
General Description of errors: There is an error in the website's search functionality and the creation of multiple products on the website.
Description of error 1: The user is not able to search for the lowest priced items on the website. 
Cause of error: In the MySqlProductDao class, there is a method that only allows the website to search using the maxinum price. That is wrong because we have asked java to search for categoryId, minPrice,maxPrice, and color. A query was written that only asked java to search for the maxinum price. Additonally, on the search parameters only contained the mininum price.
Solution: First we wrote:
 AND (price >= ? OR ? = -1)
We put this statement in the query field. It asks for  java to search for items with a minumun price in the database. It will return null if a price searched is not included in the database.
Second we wrote:
statement.setBigDecimal(5, maxPrice);
statement.setBigDecimal(6, maxPrice);
We put this statement in the parameter field. It asks for java to search for items with a maxinum price in the database. 

Image of Error 1 Corrected:
 



Description of error 2: There are duplicates of a laptop on the webstie. It seems that the website created new laptops when the admin tried to update the price
Cause of error: In the Product controller class, there is an endpoint that allows the user to update an item. However, the word "create" was written in that end point instead of "update".
Solution: We replaced the word "create" with "update" along with specifying that the item will be updated. We used a program called Postman to test if the error is fixed. We had to reverify as an admin in order for us to check if that feature has been changed. We would try to change an item using Postman to check if it workes.

Image of Error 2 corrected:
 

Phase 3: Adding shopping cart feature

General description: We created a MySqlShoppingCartDao and ShoppingCartController. These methods would allow Java to connect to a My Sql database that contained a shopping cart table that can be used to create an shopping cart section for our online store.
MySqlShoppingCartDao: MySqlShoppingCartDao uses an interface called ShoppingCartDao. ShoppingCartDao contains methods that will be used to create, add, update, and delete items from the shopping cart once it is connected to the My Sql database. In the MySqlShoppingCartDao class we use search queries and prepared statements to connect to the shopping cart mysql database. This will allow the the user to add, update, search, and delete items in their shopping cart on the website.

Image of ShoppingCartDao:
 
Description of code shown in image: ShoppingCartDao contains methods that allows the user to create,add,update, and delete items from the shopping cart. The shopping cart lets the user login using their user id and searches for a product using its product id.

Image of MySqlShoppingCartDao:
 
Description of code shown in image: Contains the sql query and the prepared that statement that will allow this method to connect to the shopping cart mysql database. It contains a try and catch statement that handles errors.		Project Title:CapstoneThree_ECommerce
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
Phase 2: Errors in the search function
General Description of errors: There is an error in the website's search functionality and the creation of multiple products on the website.
Description of error 1: The user is not able to search for the lowest priced items on the website. 
Cause of error: In the MySqlProductDao class, there is a method that only allows the website to search using the maxinum price. That is wrong because we have asked java to search for categoryId, minPrice,maxPrice, and color. A query was written that only asked java to search for the maxinum price. Additonally, on the search parameters only contained the mininum price.
Solution: First we wrote:
 AND (price >= ? OR ? = -1)
We put this statement in the query field. It asks for  java to search for items with a minumun price in the database. It will return null if a price searched is not included in the database.
Second we wrote:
statement.setBigDecimal(5, maxPrice);
statement.setBigDecimal(6, maxPrice);
We put this statement in the parameter field. It asks for java to search for items with a maxinum price in the database. 

Image of Error 1 Corrected:
 



Description of error 2: There are duplicates of a laptop on the webstie. It seems that the website created new laptops when the admin tried to update the price
Cause of error: In the Product controller class, there is an endpoint that allows the user to update an item. However, the word "create" was written in that end point instead of "update".
Solution: We replaced the word "create" with "update" along with specifying that the item will be updated. We used a program called Postman to test if the error is fixed. We had to reverify as an admin in order for us to check if that feature has been changed. We would try to change an item using Postman to check if it workes.

Image of Error 2 corrected:
 

Phase 3: Adding shopping cart feature

General description: We created a MySqlShoppingCartDao and ShoppingCartController. These methods would allow Java to connect to a My Sql database that contained a shopping cart table that can be used to create an shopping cart section for our online store.
MySqlShoppingCartDao: MySqlShoppingCartDao uses an interface called ShoppingCartDao. ShoppingCartDao contains methods that will be used to create, add, update, and delete items from the shopping cart once it is connected to the My Sql database. In the MySqlShoppingCartDao class we use search queries and prepared statements to connect to the shopping cart mysql database. This will allow the the user to add, update, search, and delete items in their shopping cart on the website.

Image of ShoppingCartDao:
 
Description of code shown in image: ShoppingCartDao contains methods that allows the user to create,add,update, and delete items from the shopping cart. The shopping cart lets the user login using their user id and searches for a product using its product id.

Image of MySqlShoppingCartDao:
 
Description of code shown in image: Contains the sql query and the prepared that statement that will allow this method to connect to the shopping cart mysql database. It contains a try and catch statement that handles errors.

ShoppingCartController: The shoppingcartcontroller contains endpoints that connect the mysqlshoppingcartdao to the website. These endpoints will allow the user to utilize mysql shopping cart, shopping cart dao and mysqlshoppingcartdao to create, add, update, and remove items from a shopping cart on the online store website. There was an error was creating this class. The cart would not load on the website even though it seems that the endpoints for creating and adding an item to the cart were created correctly. There is most likely an error in the shoppingcart, shoppingcartdao,myshoppingcartdao, or shoppingcart controller. We would need to test each feature using software such as Postman and redo each method to find the source of our error.

Image of ShoppingCartController:
 
Description of Image: Image contains methods to allow a user to log into the controller. The user would log in using the principal. Then, the shopping cart would search for the item using the productID.

Ways to improve project:
⦁	Test each method in all classes more throughly
⦁	Improve spelling errors on front end.
⦁	Create clearer names and objects.
⦁	Format code


ShoppingCartController: The shoppingcartcontroller contains endpoints that connect the mysqlshoppingcartdao to the website. These endpoints will allow the user to utilize mysql shopping cart, shopping cart dao and mysqlshoppingcartdao to create, add, update, and remove items from a shopping cart on the online store website. There was an error was creating this class. The cart would not load on the website even though it seems that the endpoints for creating and adding an item to the cart were created correctly. There is most likely an error in the shoppingcart, shoppingcartdao,myshoppingcartdao, or shoppingcart controller. We would need to test each feature using software such as Postman and redo each method to find the source of our error.

Image of ShoppingCartController:
 
Description of Image: Image contains methods to allow a user to log into the controller. The user would log in using the principal. Then, the shopping cart would search for the item using the productID.

Ways to improve project:
⦁	Test each method in all classes more throughly
⦁	Improve spelling errors on front end.
⦁	Create clearer names and objects.
⦁	Format code
