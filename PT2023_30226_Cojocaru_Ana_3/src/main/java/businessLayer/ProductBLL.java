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


    /**
     * fiecare instanta va crea un obicet ProductDAO
     */
    public ProductBLL(){
        validator = new EmailValidator();
        productDAO = new ProductDAO();
    }

    /**
     * @param id id de gasit
     * @return returenaza produsul
     */
    public Product findProductByCod(int id) {
        Product cl = productDAO.findByCod(id);
        if (cl == null) {
            throw new NoSuchElementException("The student with id =" + id + " was not found!");
        }
        return cl;
    }

    /**
     * @return all products
     */
    public List<Product> findAllProducts() {
        List<Product> list = (new ProductDAO()).findAll();
        if (list == null) {
            throw new NoSuchElementException("There are no products");
        }
        return list;
    }

    /**
     * @param cod cod produs de sters
     */
    public void deleteProduct(int cod)
    {
        ProductDAO d = new ProductDAO();
        Product c = d.findByCod(cod);
        d.deleteProduct(c.getCodProdus());
    }

    /**
     * @param cl produs e editat
     */
    public void insertProduct(Product cl){
       // validator.validate(cl);
        (new ProductDAO()).insert(cl);
    }

    /**
     * @param cl produs
     * @param codProdus codul cl
     */
    public void updateProductByCod(Product cl, int codProdus){
      //  validator.validate(cl);
        productDAO.updateP(cl,codProdus);
    }

    /**
     * @param s numele
     * @return produsul
     */
    public Product findByName(String s){
        //  validator.validate(cl);
        return productDAO.findByName(s);
    }

}
