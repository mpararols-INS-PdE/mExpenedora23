package daos;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T get(String primaryKey);

    List<T> getAll() throws SQLException;

    void save(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

}
