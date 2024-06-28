package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
@Autowired
public MySqlCategoryDao(DataSource dataSource)
{
super(dataSource);

}

@Override
public List<Category> getAllCategories(){
List<Category> categories = new ArrayList<>();
String sql = "SELECT * FROM categories";

try(Connection connection = getConnection()){

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet eachCategory = statement.executeQuery();

    while (eachCategory.next()) {

    Category category = mapRow(eachCategory);
    categories.add(category);
}
   // return all categories
    return categories;

} catch (SQLException e) {
System.out.println(e.getLocalizedMessage());
}

// return null if there are no categories
return null;
}

@Override
public Category getById(int categoryId)
{

Category category;

String sql = "SELECT * FROM categories WHERE categoryID=?";

try {
Connection connection = getConnection(); //get connect by calling this method from the parent class (MySQLDaoBase)
PreparedStatement preparedStatement = connection.prepareStatement(sql); //create prepared statement from sql string
    //we created above

preparedStatement.setInt(1, categoryId); // set the '?' in the sql string with this value
    //we want to add an int to the query string from method param


ResultSet categoryById = preparedStatement.executeQuery(); //after we execiute the query we get back a result set


while(categoryById.next()){

category = mapRow(categoryById);

    return category; // return category by id

}

} catch(SQLException e){
e.getLocalizedMessage();
}

return null;
}

@Override
public Category create(Category category) {

String query = "INSERT INTO categories(came, category_id, description) VALUES (?,?,?)";

try (
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
) {
    preparedStatement.setString(1, category.getName());
    preparedStatement.setInt(2, category.getCategoryId());
    preparedStatement.setString(3, category.getDescription());

    int rowsAffected = preparedStatement.executeUpdate();

    if (rowsAffected > 0) {
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (generatedKeys.next()) {

           int categoryId = generatedKeys.getInt(1);
          category.setCategoryId(categoryId);
            return category;
        }// create a new category
        }


} catch (SQLException e){
    System.out.println(e.getLocalizedMessage());
}
return null;
}

@Override
public void update(int categoryId, Category category){

String query = "UPDATE products SET name=?, description=? WHERE category_id=?";

try(
Connection connection = getConnection();
PreparedStatement preparedStatement = connection.prepareStatement(query);
){
preparedStatement.setString(1, category.getName());
preparedStatement.setString(2, category.getDescription());

preparedStatement.setInt(2, categoryId);
preparedStatement.executeUpdate();

} catch (SQLException sql){
sql.printStackTrace();
}
}



@Override
public void delete(int categoryId){

String query = "DELETE FROM products WHERE category_id=?";

try(
Connection connection = getConnection();
PreparedStatement preparedStatement = connection.prepareStatement(query);
){
preparedStatement.setInt(1, categoryId);

preparedStatement.executeUpdate();

} catch(SQLException sql){
sql.printStackTrace();
}
}



@Override
public List<Category> findAll() {
return null;
}



private Category mapRow(ResultSet row) throws SQLException
{
int categoryId = row.getInt("category_id");
String name = row.getString("name");
String description = row.getString("description");

Category category = new Category()
{{
    setCategoryId(categoryId);
    setName(name);
    setDescription(description);
}};

return category;
}

}