package es.ulpgc.eite.da.quiz.cheat;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.da.quiz.app.QuestionToCheatState;

public interface CheatContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayAnswer(CheatViewModel viewModel);
    void resetAnswer();
    void onFinish();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void onResume();
    void onStart();
    void onRestart();
    void onDestroy();
    void onBackPressed();
    void onWarningButtonClicked(int option);
  }

  interface Model {
    String getAnswer();
    void setAnswer(String answer);
  }

  interface Router {
    void passStateToQuestionScreen(CheatToQuestionState state);
    QuestionToCheatState getStateFromQuestionScreen();
  }
}
