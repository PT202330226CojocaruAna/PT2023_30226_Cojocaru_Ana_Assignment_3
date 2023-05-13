package businessLayer;

import businessLayer.validators.EmailValidator;
import businessLayer.validators.Validator;
import dataAccessLayer.ClientDAO;
import dataAccessLayer.ProductDAO;
import model.Client;
import model.Product;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {


    private List<Validator<Product>> validators;
    private Validator validator;

    private ProductDAO productDAO;


    public ProductBLL(){
        validator = new EmailValidator();
        productDAO = new ProductDAO();
    }

    public List<Product> findAllProducts() {
        List<Product> list = (new ProductDAO()).findAll();
        if (list == null) {
            throw new NoSuchElementException("There are no products");
        }
        return list;
    }

    public void deleteProduct(int cod)
    {
        ProductDAO d = new ProductDAO();
        Product c = d.findByCod(cod);
        d.deleteProduct(c.getCodProdus());
    }
    public void insertProduct(Product cl){
       // validator.validate(cl);
        (new ProductDAO()).insert(cl);
    }

    public void updateProductByCod(Product cl, int codProdus){
      //  validator.validate(cl);
        productDAO.updateP(cl,codProdus);
    }

    public Product findByName(String s){
        //  validator.validate(cl);
        return productDAO.findByName(s);
    }

}
