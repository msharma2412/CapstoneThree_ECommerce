package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.ShoppingCart;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {
    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int UserId) {
        String sql = "Select * From Shopping_Cart Where UserID=?";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,UserId);
            ResultSet ShoppingCartItems=statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public ShoppingCart addItem(int UserId, int ProductId) {
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













