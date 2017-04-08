package gameManager;

/**
 * Created by Ann on 05.04.2017.
 */

public class Question {
    public int id;
    public String question;
    public String img;
    public String rightAnswer;
    public String[] otherAnswers = new String[3];

    public Question(){}

    public Question(int id, String question, String img,
                    String rightAnswer, String a, String b, String c ){
        this.id = id;
        this.question = question;
        this.img = img;
        this.rightAnswer = rightAnswer;
        this.otherAnswers[0] = a;
        this.otherAnswers[1] = b;
        this.otherAnswers[2] = c;
    }
}
