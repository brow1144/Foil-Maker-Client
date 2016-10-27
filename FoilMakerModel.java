/**
 * Created by Nicholas on 10/24/2016.
 */
public class FoilMakerModel {
    private String username, userToken, gameToken;

    protected FoilMakerView view;
    protected FoilMakerController controller;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public void setGameToken(String gameToken) {
        this.gameToken = gameToken;
    }

    public String getGameToken() {
        return gameToken;
    }
}
