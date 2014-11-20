package soundPoint;

public class FactoryDAO {
	private static final String MONGO_URL = "jdbc:mongo://127.0.0.1:8080";
	private static final String MONGO_DRIVER = "jdbc:mongo://<serverName>/<databaseName>";
	public static String getMongoDriver() {
		return MONGO_DRIVER;
	}
}
