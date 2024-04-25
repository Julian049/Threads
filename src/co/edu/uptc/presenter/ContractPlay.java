package co.edu.uptc.presenter;

import co.edu.uptc.pojo.Element;

import java.util.ArrayList;

public interface ContractPlay {

    public interface Model {
        public void setPresenter(Presenter presenter);

        public void start();

        public void stop();
        public ArrayList<Element> loadElements(int numberElements);
        public void rightCircle();

        void leftCircle();

        void upCircle();

        void downCircle();

        public void rightImage();

        void leftImage();

        void upImage();

        void downImage();

        public Element getElement();
    }

    public interface View {
        public void setPresenter(Presenter presenter);

        public void run();
        public void moveElements();
        public int getNumberElements();
        public void paintElements();
        public void setElements(ArrayList<Element> elements);
    }

    public interface Presenter {
        public void setView(View view);

        public void setModel(Model model);

        public void run();

        public Element getElement();

        public void start();

        public void stop();

        public void loadAndPaint();

        public void rightCircle();

        void leftCircle();

        void upCircle();

        void downCircle();

        public void rightImage();

        void leftImage();

        void upImage();

        void downImage();
    }
}
