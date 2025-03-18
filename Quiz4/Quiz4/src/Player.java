import java.util.Objects;

public class Player
{
    int playerID;
    String userName;
    int level;

    public Player(int playerID, String name, int level)
    {
        this.playerID = playerID;
        this.userName = name;
        this.level = level;
    }

    public int getPlayerID()
    {
        return playerID;
    }

    public void setPlayerID(int playerID)
    {
        this.playerID = playerID;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    @Override
    public String toString()
    {
        return "Player{" + playerID + "," + userName + "," + level +'}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerID == player.playerID && level == player.level && Objects.equals(userName, player.userName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(playerID, userName, level);
    }
}
