interface ButtonsBuilder{
    void addButtons();
}

interface WelcomeMessageBuilder{
    void printWM();
}

class StudentsButtonsBuilder implements ButtonsBuilder{
    @Override
    public void addButtons(){
        System.out.println("Dostepne opcje:\n1. Oceny\n2. Plan zajec\n3. Rezygnacja ze studiow");
    }
}

class AdminButtonsBuilder implements ButtonsBuilder{
    @Override
    public void addButtons(){
        System.out.println("Dostepne opcje:\n1. Wpisz ocene\n2. Dodaj zadanie\n3. Dopisz studenta do grupy");
    }
}

class StudentsWMBuilder implements WelcomeMessageBuilder{
    @Override
    public void printWM(){
        System.out.println("Witaj studencie!");
    }
}

class AdminWMBuilder implements WelcomeMessageBuilder{
    @Override
    public void printWM(){
        System.out.println("Witaj adminie!");
    }
}

class FormBuilder{

    ButtonsBuilder buttonsBuilder;
    WelcomeMessageBuilder welcomeMessageBuilder;
    Form form;
    void setButtonsBuilder(ButtonsBuilder bb){
        buttonsBuilder = bb;
    }
    void setWMBuilder(WelcomeMessageBuilder wmb){
        welcomeMessageBuilder = wmb;
    }
    void constructForm(){
        form = new Form(buttonsBuilder, welcomeMessageBuilder);
    }
    Form getForm(){
        return form;
    }
}

class Form{
    Form(ButtonsBuilder buttonsBuilder, WelcomeMessageBuilder welcomeMessageBuilder){
        welcomeMessageBuilder.printWM();
        buttonsBuilder.addButtons();
    }
}

public class ZadanieA {
    public static void main(String[] args) {
        FormBuilder fBuilder = new FormBuilder();
        StudentsButtonsBuilder bBuilder = new StudentsButtonsBuilder();
        StudentsWMBuilder wmBuilder= new StudentsWMBuilder();
        fBuilder.setButtonsBuilder(bBuilder);
        fBuilder.setWMBuilder(wmBuilder);
        fBuilder.constructForm();
        Form form = fBuilder.getForm();
    }
}
