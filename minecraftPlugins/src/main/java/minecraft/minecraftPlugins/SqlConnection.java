package minecraft.minecraftPlugins;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import org.yaml.snakeyaml.Yaml;

public class SqlConnection {
	private Connection connection;

	// class to store user and credentials for SQL server

	public class Creds {
		private String user;
		private String pass;
	}

	// Load the YAML file and then load the data into the Creds class

	Yaml yaml = new Yaml();
	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("creds.yml");
	Creds creds = yaml.load(inputStream);

	// Initialize the SQL connection

	public Connection getConnection() throws SQLException {
		if (connection != null)
			return connection;

		String url = "jdbc:mysql://localhost/minecraft";
		String usr = creds.user;
		String pass = creds.pass;

		Connection connection = DriverManager.getConnection(url, usr, pass);
		this.connection = connection;

		return connection;
	}

	// Create the table if it does not exist already

	public void initialize() throws SQLException {
		Statement statement = getConnection().createStatement();

		String create = "CREATE TABLE IF NOT EXISTS player_stats (uuid varchar(36) primary key, muted int, deaths int, kills int, blocks_broken long, balance double, last_login DATE, last_logout DATE)";

		statement.execute(create);
		statement.close();
	}

	// Get the stats of a specific player and load the data into a PlayerStats
	// object

	public PlayerStats findStats(String uuid) throws SQLException {
		PlayerStats stats;

		PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM player_stats WHERE uuid = ?");
		statement.setString(1, uuid);
		ResultSet results = statement.executeQuery();

		if (results.next()) {
			stats = new PlayerStats(results.getString("uuid"), results.getInt("deaths"), results.getInt("kills"),
					results.getLong("blocks_broken"), results.getDouble("balance"), results.getDate("last_login"),
					results.getDate("last_logout"));
			statement.close();
			return stats;
		}

		statement.close();
		return null;
	}

	// Add a new player and stats to the SQL table

	public void createStats(PlayerStats stats) throws SQLException {
		PreparedStatement statement = getConnection().prepareStatement(
				"INSERT INTO player_stats(uuid, deaths, kills, blocks_broken, balance, last_login, last_logout) VALUES (?, ?, ?, ?, ?, ?, ?)");
		statement.setString(1, stats.getUUID());
		statement.setInt(2, stats.getDeaths());
		statement.setInt(3, stats.getKills());
		statement.setLong(4, stats.getBlocksBroken());
		statement.setDouble(5, stats.getBalance());
		statement.setDate(6, new Date(stats.getLastLogin().getTime()));
		statement.setDate(7, new Date(stats.getLastLogout().getTime()));

		statement.executeUpdate();
		statement.close();
	}

	public void updateStats(PlayerStats stats) throws SQLException {
		PreparedStatement statement = getConnection().prepareStatement(
				"UPDATE player_stats SET deaths = ?, kills = ?, blocks_broken = ?, balance = ?, last_login = ?, last_logout = ? WHERE uuid = ?");
		statement.setInt(1, stats.getDeaths());
		statement.setInt(2, stats.getKills());
		statement.setLong(3, stats.getBlocksBroken());
		statement.setDouble(4, stats.getBalance());
		statement.setDate(5, new Date(stats.getLastLogin().getTime()));
		statement.setDate(6, new Date(stats.getLastLogout().getTime()));
		statement.setString(7, stats.getUUID());

		statement.executeUpdate();
		statement.close();

	}

	// Delete the stats of a specific player

	public void deleteStats(PlayerStats stats) throws SQLException {

		PreparedStatement statement = getConnection().prepareStatement("DELETE FROM player_stats WHERE uuid = ?");
		statement.setString(1, stats.getUUID());

		statement.executeUpdate();
		statement.close();
	}
}
