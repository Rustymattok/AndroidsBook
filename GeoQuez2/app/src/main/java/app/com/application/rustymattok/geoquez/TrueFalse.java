package app.com.application.rustymattok.geoquez;

public class TrueFalse {
    private int indexQuestions;
    private boolean isQuestion;

    public TrueFalse(int indexQuestions, boolean isQuestion) {
        this.indexQuestions = indexQuestions;
        this.isQuestion = isQuestion;
    }

    public int getIndexQuestions() {
        return indexQuestions;
    }

    public void setIndexQuestions(int indexQuestions) {
        this.indexQuestions = indexQuestions;
    }

    public boolean isQuestion() {
        return isQuestion;
    }

    public void setIsQuestion(boolean isQuestion) {
        this.isQuestion = isQuestion;
    }
}
