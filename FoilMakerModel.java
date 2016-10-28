import java.util.ArrayList;

/**
 * Created by Nicholas on 10/24/2016.
 */
public class FoilMakerModel {
    private String username, userToken, gameToken, score, question, correctAnswer, suggestion, choice;
    private ArrayList<String> choices = new ArrayList<>();

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void addChoices(String s) {
        choices.add(s);
    }

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

    public void setScore() {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public void setChoice(String choice) {

        this.choice = choice;

    }

    public String getChoice() {

        return choice;

    }
}
