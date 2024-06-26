package es.ulpgc.eite.da.quiz.app;

import es.ulpgc.eite.da.quiz.cheat.CheatState;
import es.ulpgc.eite.da.quiz.question.QuestionState;

public class AppMediator  {


  private QuestionState questionState;
  private CheatState cheatState;

  private QuestionToCheatState questionToCheatState;
  private CheatToQuestionState cheatToQuestionState;

  private static AppMediator INSTANCE;

  private AppMediator() {
    questionState = new QuestionState();
    cheatState = new CheatState();
  }

  public static AppMediator getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new AppMediator();
    }

    return INSTANCE;
  }

  public static void resetInstance() {
    INSTANCE = null;
  }

  public CheatState getCheatState() {
    return cheatState;
  }

  public QuestionState getQuestionState() {
    return questionState;
  }

  public void setCheatToQuestionState(CheatToQuestionState state) {
    cheatToQuestionState = state;
  }

  public CheatToQuestionState getCheatToQuestionState() {
    CheatToQuestionState state = cheatToQuestionState;
    cheatToQuestionState=null; // reset state after getting it
    return state;
  }

  public QuestionToCheatState getQuestionToCheatState() {
    QuestionToCheatState state = questionToCheatState;
    //questionToCheatState = null;
    return state;
  }

  public void setQuestionToCheatState(QuestionToCheatState state) {
    questionToCheatState = state;
  }
}
