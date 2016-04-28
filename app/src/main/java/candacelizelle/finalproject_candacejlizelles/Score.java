package candacelizelle.finalproject_candacejlizelles;

public class Score {
    public int score = 0;

    public Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addPoint() {
        score++;
    }
}
