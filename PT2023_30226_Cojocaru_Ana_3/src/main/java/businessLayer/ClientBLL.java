package businessLayer;

import java.util.List;
import java.util.NoSuchElementException;

import businessLayer.validators.EmailValidator;
import businessLayer.validators.Validator;
import dataAccessLayer.ClientDAO;
import model.Client;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class ClientBLL {

    private List<Validator<Client>> validators;
    private Validator validator;

    private ClientDAO clientDAO;


        public ClientBLL(){
            validator = new EmailValidator();
            clientDAO = new ClientDAO();
        }

        public Client findClientById(int id) {
            Client cl = clientDAO.findById(id);
            if (cl == null) {
                throw new NoSuchElementException("The student with id =" + id + " was not found!");
            }
            return cl;
        }

        public Client findClientByName(String name) {
            Client cl = clientDAO.findByName(name);
            if (cl == null) {
                throw new NoSuchElementException("The student with name =" + name + " was not found!");
            }
            return cl;
        }

        public void insertClient(Client cl){
            validator.validate(cl);
            clientDAO.insert(cl);
        }

        public List<Client> findAllClients(){
            List<Client> list = clientDAO.findAll();
            if(list == null){
                throw new NoSuchElementException("There are no clients");
            }
            return list;
        }

/*
    public List<client> findAllClients(){
        List<client> l;
        l=(new ClientDAO()).findAll();
        return l;
    }
*/

        public void updateClientById(Client cl, int id){
            validator.validate(cl);
            clientDAO.update(cl,id);
        }

        public void deleteClient(String name)
        {
            Client c = clientDAO.findByName(name);
            clientDAO.delete(c.getId());
        }

    public void deleteClientById(int id)
    {
        Client c = clientDAO.findById(id);
        clientDAO.delete(c.getId());
    }

}
