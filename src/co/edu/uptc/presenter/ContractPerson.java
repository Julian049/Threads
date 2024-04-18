package co.edu.uptc.presenter;

public interface ContractPerson {

    public interface Model{
     public void setPresenter(Presenter presenter);
    }

    public interface View{
        public void setPresenter(Presenter presenter);
    }

    public interface Presenter{
        public void setView(View view);
        public void setModel(Model model);
    }
}