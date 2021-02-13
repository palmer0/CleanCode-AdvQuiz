package es.ulpgc.eite.da.quiz.cheat;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.quiz.app.AppMediator;
import es.ulpgc.eite.da.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.da.quiz.app.QuestionToCheatState;

public class CheatPresenter implements CheatContract.Presenter {

  public static String TAG = CheatPresenter.class.getSimpleName();

  private AppMediator mediator;
  private WeakReference<CheatContract.View> view;
  private CheatState state;
  private CheatContract.Model model;

  public CheatPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getCheatState();
  }


  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // reset state to tests
    state.answerEnabled=true;
    state.answerCheated=false;
    state.answer = null;

    // update the view
    view.get().resetAnswer();
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    //TODO: falta implementacion

  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    //TODO: falta implementacion

    // use passed state if is necessary
    QuestionToCheatState savedState = getStateFromQuestionScreen();
    if (savedState != null) {

      Log.e(TAG, "savedState.answer: "+savedState.answer);

      // fetch the model
      model.setAnswer(savedState.answer);


      // update the state
      if(state.answerCheated) {
        state.answer = model.getAnswer();
      }

    }

    // update the view
    view.get().displayAnswer(state);
    if(state.answer == null) {
      view.get().resetAnswer();
    }
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    //TODO: falta implementacion

    Log.e(TAG, "cheated "+state.answerCheated);

    CheatToQuestionState passedState=new CheatToQuestionState();
    passedState.answerCheated=state.answerCheated;
    passStateToQuestionScreen(passedState);

    view.get().onFinish();
  }

  @Override
  public void onWarningButtonClicked(int option) {
    Log.e(TAG, "onWarningButtonClicked()");

    //TODO: falta implementacion
    //option=1 => yes, option=0 => no

    if(option==1) {
      showAnswer();

    } else {
      onBackPressed();
      //view.get().onFinish();
    }
  }

  private void passStateToQuestionScreen(CheatToQuestionState state) {

    //TODO: falta implementacion

    mediator.setCheatToQuestionState(state);
  }

  private QuestionToCheatState getStateFromQuestionScreen() {

    //TODO: falta implementacion

    QuestionToCheatState state = mediator.getQuestionToCheatState();
    return state;
  }

  private void showAnswer() {
    state.answerCheated=true;
    state.answerEnabled=false;
    state.answer = model.getAnswer();

    // update the view
    view.get().displayAnswer(state);
  }

  @Override
  public void injectView(WeakReference<CheatContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CheatContract.Model model) {
    this.model = model;
  }

}
