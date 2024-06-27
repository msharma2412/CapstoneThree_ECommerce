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
        String sql = "Select * From Shopping_Cart Where UserID=?";

        List<ShoppingCartItem> ShoppingCartItemList= new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,UserId);
            ResultSet ShoppingCartItems=statement.executeQuery();

            while (ShoppingCartItems.next()) {
                int productID=ShoppingCartItems.getInt("product_id");
                int quantity=ShoppingCartItems.getInt("quantity");
                Product product= productDao.getById( productID);
                ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
                ShoppingCartItemList.add(shoppingCartItem);
            }

                } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new ShoppingCart();
    }

    @Override
    public ShoppingCart addItem(int UserId, int ProductId) {

       //1. sql query. There are 3 parameters.UserID=?,product_id=?, quantity=1
        //2.connection statement with try
        //3.prepared statement and setting int to the prepared statement line 29-31. ? marks where you are setting it.

        return null;
    }

    @Override
    public void updateShoppingCart(int UserId) {

    }

    @Override
    public void deleteShoppingCart(int UserId) {

    }

//    private  mapShoppingCartItems(ResultSet ShoppingCartItems) throws SQLException
//    {
//        int UserId = ShoppingCartItems.getInt("User_id");
//        String name = ShoppingCartItems.getString("product_id");
//        int quantity = ShoppingCartItems.getInt("quantity");
//
////        ShoppingCart ShoppingCart = new ShoppingCart()
////        {{
////            setuserid (categoryId);
////            setName(name);
////            setDescription(description);
////        }};
//////
//        return null;
    }













