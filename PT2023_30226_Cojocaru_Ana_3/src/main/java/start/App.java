package start;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import dataAccessLayer.ClientDAO;
import model.Client;
import presentation.MainFrame;

public class App {
    /**
     *
     */
        protected static final Logger LOGGER = Logger.getLogger(App.class.getName());

    /**
     * @param args
     * @throws SQLException
     */
        public static void main(String[] args) throws SQLException {

     /*     //  StudentBLL studentBll = new StudentBLL();

            Client client = null;

            try {
            //    client = ClientBLL.findStudentById(1245);

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }

            // obtain field-value pairs for object through reflection
          //  Reflection.retrieveProperties(client);
*/

            MainFrame m = new MainFrame();
//            ClientBLL clientBLL= new ClientBLL();
            ClientDAO c = new ClientDAO();
            List<Client> clientList = c.findAll();
            for(Client client : clientList){
                if(client!=null){
                    System.out.println(client);
                }
            }
            //   List<client> clientList = clientDAO.findAll();
            System.out.println(clientList);

        }

 }

