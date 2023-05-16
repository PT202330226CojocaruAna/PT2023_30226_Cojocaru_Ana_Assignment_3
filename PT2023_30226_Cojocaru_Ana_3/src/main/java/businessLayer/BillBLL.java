package businessLayer;

import java.util.List;
import java.util.NoSuchElementException;

import businessLayer.validators.EmailValidator;
import businessLayer.validators.Validator;
import dataAccessLayer.BillDAO;
import dataAccessLayer.ClientDAO;
import model.Bill;
import model.Client;

/**
 *  Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 *  Apr 03, 2017
 */
public class  BillBLL {

    private BillDAO billDAO;


    /**
     * creeaza un obiect Bill
     */
    public BillBLL(){

        billDAO = new BillDAO();
    }


    /**
     * @param bl the Bill that is going to be added to the Log table
     */
    public void insert(Bill bl){
        billDAO.insert(bl);
    }

}
