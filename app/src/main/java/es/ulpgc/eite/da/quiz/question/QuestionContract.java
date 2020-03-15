package es.ulpgc.eite.da.quiz.question;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.da.quiz.app.QuestionToCheatState;

public interface QuestionContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayQuestion(QuestionViewModel viewModel);
    void resetReply();
    void updateReply(boolean isCorrect);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void onResume();
    void onStart();
    void onRestart();
    void onOptionButtonClicked(int option);
    void onNextButtonClicked();
    void onCheatButtonClicked();
    void onDestroy();
  }

  interface Model {
    String getQuestion();
    String getOption1();
    String getOption2();
    String getOption3();
    boolean isCorrectOption(int option);
    void setQuizIndex(int index);
    String getAnswer();
    void updateQuizIndex();
  }

  interface Router {
    void navigateToCheatScreen();
    void passStateToCheatScreen(QuestionToCheatState state);
    CheatToQuestionState getStateFromCheatScreen();
  }
}
