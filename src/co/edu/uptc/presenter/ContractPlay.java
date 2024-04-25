package co.edu.uptc.presenter;

import co.edu.uptc.pojo.Element;

import java.util.ArrayList;

public interface ContractPlay {

    interface Model {
        void setPresenter(Presenter presenter);

        void start();

        void stop();

        ArrayList<Element> loadElements(int numberElements);
    }

    interface View {
        void setPresenter(Presenter presenter);

        void run();

        void moveElements();

        int getNumberElements();

        void paintElements();

        void setElements(ArrayList<Element> elements);
    }

    interface Presenter {
        void setView(View view);

        void setModel(Model model);

        void run();

        void start();

        void stop();

        void loadAndPaint();
    }
}
