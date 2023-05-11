package daos;

import model.Slot;

import java.sql.SQLException;
import java.util.List;

public class SlotDao_MySQL implements Dao<Slot>{

    @Override
    public Slot get(String primaryKey) {
        return null;
    }

    @Override
    public List<Slot> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Slot slot) throws SQLException {

    }

    @Override
    public void update(Slot slot) throws SQLException {

    }

    @Override
    public void delete(Slot slot) throws SQLException {

    }
}
