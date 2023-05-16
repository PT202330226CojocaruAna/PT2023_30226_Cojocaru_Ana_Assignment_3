package businessLayer;

import dataAccessLayer.OrderDAO;
import model.Orders;

public class OrderBLL {

    private OrderDAO orderDAO;


    /**
     * fiecare instanta a obiectului Order va crea un nou obiectOrderDAO
     */
    public OrderBLL(){
        orderDAO = new OrderDAO();
    }

    /**
     * @param or order to insert
     */
    public void insertOrder(Orders or){
        //validator.validate(or);
        orderDAO.insert(or);
    }
}
