package es.ulpgc.eite.da.quiz.question;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.da.quiz.app.QuestionToCheatState;

public class QuestionPresenter implements QuestionContract.Presenter {

  public static String TAG = QuestionPresenter.class.getSimpleName();

  private WeakReference<QuestionContract.View> view;
  private QuestionState state;
  private QuestionContract.Model model;
  private QuestionContract.Router router;

  public QuestionPresenter(QuestionState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // call the model
    state.question = model.getQuestion();
    state.option1 = model.getOption1();
    state.option2 = model.getOption2();
    state.option3 = model.getOption3();

    // reset state to tests
    state.answerCheated=false;
    state.optionClicked = false;
    state.option = 0;

    // update the view
    disableNextButton();
    view.get().resetReply();
  }


  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // update the model
    model.setQuizIndex(state.quizIndex);

    if(state.optionClicked){
      view.get().updateReply(model.isCorrectOption(state.option));

    } else {
      view.get().resetReply();
    }
  }


  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    CheatToQuestionState savedState = router.getStateFromCheatScreen();
    if (savedState != null) {

      //TODO: falta implementacion

      // update state
      state.answerCheated = savedState.answerCheated;
    }

    if(state.answerCheated){
      state.answerCheated=false;
      onNextButtonClicked();

    } else {
      view.get().displayQuestion(state);
    }

  }


  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onOptionButtonClicked(int option) {
    Log.e(TAG, "onOptionButtonClicked()");

    state.optionClicked=true;
    state.option=option;

    enableNextButton();

    boolean isCorrect = model.isCorrectOption(option);
    if(isCorrect) {
      state.cheatEnabled=false;
    } else {
      state.cheatEnabled=true;
    }

    view.get().updateReply(isCorrect);
    onResume();
  }

  @Override
  public void onNextButtonClicked() {
    Log.e(TAG, "onNextButtonClicked()");

    //TODO: falta implementacion

    model.updateQuizIndex();
    onStart();
    onResume();
  }

  @Override
  public void onCheatButtonClicked() {
    Log.e(TAG, "onCheatButtonClicked()");

    //TODO: falta implementacion

    QuestionToCheatState nextState = new QuestionToCheatState();
    nextState.answer = model.getAnswer();
    router.passStateToCheatScreen(nextState);
    router.navigateToCheatScreen();
  }


  private void disableNextButton() {
    state.optionEnabled=true;
    state.cheatEnabled=true;
    state.nextEnabled=false;

  }

  private void enableNextButton() {
    state.optionEnabled=false;
    state.nextEnabled=true;
  }

  @Override
  public void injectView(WeakReference<QuestionContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(QuestionContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(QuestionContract.Router router) {
    this.router = router;
  }
}
