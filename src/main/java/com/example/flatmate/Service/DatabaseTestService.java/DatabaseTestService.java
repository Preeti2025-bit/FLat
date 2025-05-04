import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class DatabaseTestService {

    private final DataSource dataSource;

    // Constructor that Spring will use to inject the DataSource bean automatically
    public DatabaseTestService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // This method will run when the Spring Boot app starts up
    @PostConstruct
    public void testDbConnection() {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("✅ Successfully connected to the database: " + connection.getMetaData().getURL());
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
        }
    }
}
