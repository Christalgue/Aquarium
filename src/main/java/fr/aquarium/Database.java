package fr.aquarium;

import java.util.Calendar;
import java.util.List;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;

public class Database {
    private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private MysqlDataSource dataSource;
    
    public Database(String serverName, int port, String database, String user, String password) throws SQLException {
        this.dataSource = new MysqlDataSource();
        this.dataSource.setServerName(serverName);
        this.dataSource.setPort(port);
        this.dataSource.setDatabaseName(database);
        this.dataSource.setUser(user);
        this.dataSource.setPassword(password);
        
        this.dataSource.getConnection(); //Test de connection
        logger.info("Connexion réussie à la BDD {}", database);
    }

    public Sensor querySensor(int sensorId) {
        try (Connection connection = dataSource.getConnection()) {
            //TODO
            //PreparedStatement ps = connection.prepareStatement("Ma requête SQL");
            //return new Sensor(sensorId, name, unit);
            return null;
        } catch (SQLException ex) {
            logger.error(ex.getClass().getName(), ex);
            return null;
        }
    }
    
    public Threshold queryThreshold(int fishId, int sensorId) {
        try (Connection connection = dataSource.getConnection()) {
            //TODO
            //return new Threshold(fishId, sensorId, fishId, fishId)
            return null;
        } catch (SQLException ex) {
            logger.error(ex.getClass().getName(), ex);
            return null;
        }
    }
    
    public List<Measure> queryMeasures(Calendar start, Calendar stop) {
        try (Connection connection = dataSource.getConnection()) {
            //TODO
            //List<Measure> measures = new LinkedList<Measure>();
            //...
            //measures.add(new Measure(sensorId, date, rawValue, value));
            //...
            //return measures;
            return null;
        } catch (SQLException ex) {
            logger.error(ex.getClass().getName(), ex);
            return null;
        }
    }
    
    public List<Measure> queryMeasures(int sensorId, Calendar start, Calendar stop) {
        //TODO
        //Idem que le précédent
        return null;
    }
    
    public void insertMeasures(List<Measure> measures) {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            //Ici, on fait 1 requête pour ajouter toutes les mesures d'un coup
            //PreparedStatement ps = connection.prepareStatement("Ma requête SQL");
            //for (Measures measure : measures) {
            //    ps.setInt(1, xxx);
            //    ps.setDouble(2, xxx);
            //    etc.
            //    ps.addBatch();
            //}
            connection.commit();
        } catch (SQLException ex) {
            logger.error(ex.getClass().getName(), ex);
        }
    }
}
