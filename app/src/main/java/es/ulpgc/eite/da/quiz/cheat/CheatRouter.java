package es.ulpgc.eite.da.quiz.cheat;

import es.ulpgc.eite.da.quiz.app.AppMediator;
import es.ulpgc.eite.da.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.da.quiz.app.QuestionToCheatState;

public class CheatRouter implements CheatContract.Router {

  public static String TAG = CheatRouter.class.getSimpleName();

  private AppMediator mediator;

  public CheatRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void passStateToQuestionScreen(CheatToQuestionState state) {

    //TODO: falta implementacion

    mediator.setCheatToQuestionState(state);
  }

  @Override
  public QuestionToCheatState getStateFromQuestionScreen() {

    //TODO: falta implementacion

    QuestionToCheatState state = mediator.getQuestionToCheatState();
    return state;
  }
}
