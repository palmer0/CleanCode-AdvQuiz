package es.ulpgc.eite.da.quiz.question;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.quiz.app.AppMediator;
import es.ulpgc.eite.da.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.da.quiz.app.QuestionToCheatState;

public class QuestionPresenter implements QuestionContract.Presenter {

  public static String TAG = QuestionPresenter.class.getSimpleName();

  private AppMediator mediator;
  private WeakReference<QuestionContract.View> view;
  private QuestionState state;
  private QuestionContract.Model model;

  public QuestionPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getQuestionState();
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

    //TODO: falta implementacion

    // update the model
    model.setQuizIndex(state.quizIndex);
    Log.e(TAG, "index: "+ state.quizIndex);

    // update the view
    if(state.optionClicked){
      Log.e(TAG, "option: "+ state.option);
      Log.e(TAG, "correct: "+ model.isCorrectOption(state.option));
      view.get().updateReply(model.isCorrectOption(state.option));
      //onOptionButtonClicked(state.option);

    } else {
      view.get().resetReply();
    }
  }


  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    //TODO: falta implementacion

    // use passed state if is necessary
    CheatToQuestionState savedState = getStateFromCheatScreen();
    if (savedState != null) {

      // update the state
      state.answerCheated = savedState.answerCheated;
    }

    // update the view
    if(state.answerCheated){
      state.answerCheated=false;

      if(!model.hasQuizFinished()) {
        onNextButtonClicked();

      } else {
        state.optionEnabled=false;
        view.get().displayQuestion(state);

        //boolean isCorrect = model.isCorrectOption(state.option);
        //view.get().updateReply(isCorrect);
      }

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

    //state.optionClicked=false;
    //state.option=0;

    model.updateQuizIndex();
    state.quizIndex=model.getQuizIndex();
    onStart();
    onResume();
  }

  @Override
  public void onCheatButtonClicked() {
    Log.e(TAG, "onCheatButtonClicked()");

    //TODO: falta implementacion

    QuestionToCheatState nextState = new QuestionToCheatState();
    nextState.answer = model.getAnswer();
    passStateToCheatScreen(nextState);
    view.get().navigateToCheatScreen();
  }

  private void passStateToCheatScreen(QuestionToCheatState state) {

    //TODO: falta implementacion

    mediator.setQuestionToCheatState(state);
  }

  private CheatToQuestionState getStateFromCheatScreen() {

    //TODO: falta implementacion

    CheatToQuestionState state = mediator.getCheatToQuestionState();
    return state;
  }


  private void disableNextButton() {
    state.optionEnabled=true;
    state.cheatEnabled=true;
    state.nextEnabled=false;

  }

  private void enableNextButton() {
    state.optionEnabled=false;

    if(!model.hasQuizFinished()) {
      state.nextEnabled=true;
    }
  }

  @Override
  public void injectView(WeakReference<QuestionContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(QuestionContract.Model model) {
    this.model = model;
  }

}
