package no.jeppe.jbdc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDao {

    private DataSource dataSource;

    public ParticipantDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertParticipant(String participantName) {

        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(
                    "insert into participants (name) values (?)");
            statement.setString(1, participantName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> listAll() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "select * from participants"
            )) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<String> result = new ArrayList<>();

                    while (resultSet.next()) {
                        result.add(resultSet.getString("name"));
                    }

                    return result;
                }
            }
        }
    }
}