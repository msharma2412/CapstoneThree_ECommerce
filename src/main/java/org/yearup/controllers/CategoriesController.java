package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.Arrays;
import java.util.List;

@RestController                            // add the annotations to make this a REST controller
@RequestMapping("/categories")        // add the annotation to make this controller the endpoint for the following url
// http://localhost:8080/categories
@CrossOrigin
public class CategoriesController {                                          // add annotation to allow cross site origin requests
private CategoryDao categoryDao;
private ProductDao productDao;


@Autowired // create an Autowired controller to inject the categoryDao and ProductDao
public CategoriesController(CategoryDao categoryDao, ProductDao productDao) {
    this.categoryDao = categoryDao;
    this.productDao = productDao;
}


// add the appropriate annotation for a get action


@GetMapping("")  // add the appropriate annotation for a get action
@ResponseStatus(value = HttpStatus.OK)
public List<Category> getCategories() {
    try {
        return categoryDao.getAllCategories();
    } catch (Exception ex) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
    }
}


// add the appropriate annotation for a get action  // get the category by id
public Category getbycategoryID(@PathVariable int id) {

    try {
        var category = categoryDao.getById(id);

        if (category == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return category;
    } catch (Exception ex) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
    }
}                                                                   // get the category by id


// the url to return all products in category 1 would look like this
// https://localhost:8080/categories/1/products

@GetMapping("/categories/{categoryId}/products")
public List<Product> getProductsInCategory(@PathVariable Long categoryId) {
    if (categoryId == 1) {
        return Arrays.asList(new Product());
    } else {
        return null;

    }
}
    //add annotation to call this method for a POST action
//    // add annotation to ensure that only an ADMIN can call this function
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Category addCategory(@RequestBody Category Category)
    {
        try
        {
            return categoryDao.create(Category);//erro is incompatable types fourn. org. yearup.models.category needed
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

// add annotation to call this method for a PUT (update) action - the url path must include the categoryId
//    // add annotation to ensure that only an ADMIN can call this function
//    public void updateCategory(@PathVariable int id, @RequestBody Category category)
//    {
//        // update the category by id
//    }
@PutMapping("{id}")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public void updateCategory(@PathVariable int id, @RequestBody Category category)
{
    try
    {
        categoryDao.create(category);
    }
    catch(Exception ex)
    {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
    }
}
    //Issue with pre autorization. Work on other mappings then going back
//
//    // add annotation to call this method for a DELETE action - the url path must include the categoryId
//    // add annotation to ensure that only an ADMIN can call this function
//    public void deleteCategory(@PathVariable int id)
//    {
//        // delete the category by id



    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCategory(@PathVariable int id)
    {
        try
        {
            var category = categoryDao.getById(id);

            if(category== null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            categoryDao.delete(id);
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }
}










