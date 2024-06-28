package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.User;

import java.util.List;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int UserId);
    // add additional method signatures here

    ShoppingCart addItem(int UserId, int ProductId);

    void updateShoppingCart(int UserId,int ProductId);
    void deleteShoppingCart(int UserId);
}



