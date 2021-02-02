package es.ulpgc.eite.da.quiz.question;

import es.ulpgc.eite.da.quiz.app.AppMediator;
import es.ulpgc.eite.da.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.da.quiz.app.QuestionToCheatState;

public class QuestionRouter implements QuestionContract.Router {

  public static String TAG = QuestionRouter.class.getSimpleName();

  //private WeakReference<FragmentActivity> context;
  private AppMediator mediator;

  public QuestionRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  /*
  public QuestionRouter(WeakReference<FragmentActivity> context) {
    this.context=context;
  }
  */

//  @Override
//  public void navigateToCheatScreen() {
//
//    //TODO: falta implementacion
//
//    Context context = mediator.getApplicationContext();
//    Intent intent = new Intent(context, CheatActivity.class);
//    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//    context.startActivity(intent);
//  }

  @Override
  public void passStateToCheatScreen(QuestionToCheatState state) {

    //TODO: falta implementacion

    mediator.setQuestionToCheatState(state);
  }

  @Override
  public CheatToQuestionState getStateFromCheatScreen() {

    //TODO: falta implementacion

    CheatToQuestionState state = mediator.getCheatToQuestionState();
    return state;
  }
}
