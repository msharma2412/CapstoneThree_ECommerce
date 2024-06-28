

package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Category;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.data.ProductDao;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {

    private ProductDao productDao;

    public MySqlShoppingCartDao(DataSource dataSource,ProductDao productDao) {
        super(dataSource);
        this.productDao=productDao;
    }

    @Override
    public ShoppingCart getByUserId(int UserId) {
       String sql = "Select * From shopping_cart join products.product_id=shopping_cart.product_id Where user_id=?";
        ShoppingCart ShoppingCart = new ShoppingCart();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,UserId);
            ResultSet ShoppingCartItems=statement.executeQuery();

            while (ShoppingCartItems.next()) {
                ShoppingCartItem shoppingcartitem = new ShoppingCartItem();
                shoppingcartitem.setProduct(MySqlProductDao.mapRow(ShoppingCartItems));
                shoppingcartitem.setQuantity(ShoppingCartItems.getInt("quantity"));
                ShoppingCart.add(shoppingcartitem);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new ShoppingCart();
    }

    @Override
    public ShoppingCart addItem(int UserId, int ProductId) {


        String sql = "INSERT INTO shopping_cart (user_id, product_id,quantity) VALUES (?, ?,1)";

        ShoppingCart ShoppingCart = new ShoppingCart();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, UserId);
            preparedStatement.setInt(2, ProductId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ShoppingCart;
//
    }

        //1. sql query. There are 3 parameters.UserID=?,product_id=?, quantity=1
        //2.connection statement with try
        //3.prepared statement and setting int to the prepared statement line 29-31. ? marks where you are setting it.

    @Override
    public void updateShoppingCart(int UserId,int ProductID) {
        String sql = "UPDATE products SET user_id=?, product_id=?, quantity=quantity+1";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, UserId);
            statement.setInt(2, ProductID);
            statement.executeUpdate(); // Execute the update statement

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void deleteShoppingCart(int UserId) {

        String sql = "DELETE FROM shopping_cart " +
                " WHERE user_id = ?;";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, UserId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }}

//                int productID=ShoppingCartItems.getInt("product_id");
//                int quantity=ShoppingCartItems.getInt("quantity");
//                Product product= productDao.getById( productID);
//                ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
//                ShoppingCartItemList.add(shoppingCartItem);
//String sql = "Select * From Shopping_Cart Where UserID=?";