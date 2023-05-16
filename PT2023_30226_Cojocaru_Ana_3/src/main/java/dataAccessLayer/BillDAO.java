package dataAccessLayer;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;


import connection.ConnectionFactory;
import model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillDAO<Bill>  {

    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/schooldb";
    private static final String USER = "root";
    private static final String PASS = "octombrie";


    private String createSelectQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM log ");
        return sb.toString();
    }

    private String createInsertQuery(ArrayList<String> field){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO log (");
        for(int i = 0;i < field.size();i++){
            if(i == 0){
                continue;
            }
            if(i == field.size()-1){
                sb.append(field.get(i)+") ");
                break;
            }
            sb.append(field.get(i)+",");
        }
        sb.append(" VALUES (");
        for(int i = 0;i < field.size();i++){
            if(i == 0){
                continue;
            }
            if(i == field.size()-1){
                sb.append("?);");
                break;
            }
            sb.append("?,");
        }
        return sb.toString();
    }

    private void getValuesFromT(Bill t,ArrayList<Object> values,ArrayList<String> fields){
        for(Field field:t.getClass().getDeclaredFields()){
            field.setAccessible(true);
            fields.add(field.getName());
            Object value;
            try {
                value = field.get(t);
                values.add(value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void insert(Bill t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ArrayList<Object> values = new ArrayList<>();
        ArrayList<String> fields = new ArrayList<String>();
        getValuesFromT(t,values,fields);
        String query = createInsertQuery(fields);
        System.out.println(query);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            for(int i=1;i<fields.size();i++){
                if(values.get(i) instanceof Integer){
                    statement.setInt(i,((Integer) values.get(i)).intValue());
                }
                if(values.get(i) instanceof String){
                    statement.setString(i,values.get(i).toString());
                }
                if(values.get(i) instanceof Double){
                    statement.setDouble(i,((Double) values.get(i)).doubleValue());
                }
            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(statement);
        }
    }


}

   /* @SuppressWarnings("unchecked")
    public BillDAO() {
        Type genericSuperclass = getClass().getGenericSuperclass();

        if (genericSuperclass instanceof ParameterizedType) {
            this.type = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        } else if (genericSuperclass instanceof Class && Record.class.isAssignableFrom((Class<?>) genericSuperclass)) {
            this.type = (Class<T>) ((Class<?>) genericSuperclass).getRecordComponents()[0].getType();
        } else {
            throw new IllegalArgumentException("Unsupported superclass type for BillDAO");
        }
    }*/

