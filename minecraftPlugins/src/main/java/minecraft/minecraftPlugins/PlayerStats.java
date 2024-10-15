package minecraft.minecraftPlugins;

import java.util.Date;

/*
 * This class is used to store the data of a specific player for use by other classes. The data will be retrieved
 * from the SQL database from the players UUID. Then other classes can use the information.
 */

public class PlayerStats {

	private String UUID;

	private int kills;
	private int deaths;
	private long blocksBroken;
	private double balance;

	private Date lastLogin;
	private Date lastLogout;

	public PlayerStats(String UUID, int kills, int deaths, long blocksBroken, double balance, Date lastLogin,
			Date lastLogout) {
		this.UUID = UUID;
		this.kills = kills;
		this.deaths = deaths;
		this.blocksBroken = blocksBroken;
		this.balance = balance;
		this.lastLogin = lastLogin;
		this.lastLogout = lastLogout;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public long getBlocksBroken() {
		return blocksBroken;
	}

	public void setBlocksBroken(long blocksBroken) {
		this.blocksBroken = blocksBroken;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getLastLogout() {
		return lastLogout;
	}

	public void setLastLogout(Date lastLogout) {
		this.lastLogout = lastLogout;
	}

}
