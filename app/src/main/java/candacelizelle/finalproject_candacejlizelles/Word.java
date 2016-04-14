package candacelizelle.finalproject_candacejlizelles;

public class Word {
    public int audio;
    public boolean correct;
    public int image;

    public Word() {
        // empty default constructor, necessary for Firebase to be able to deserialize data
    }

    public int getAudio() {
        return audio;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int getImage() {
        return image;
    }
}
