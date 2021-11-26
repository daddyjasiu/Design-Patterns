import java.util.List;
import java.util.Locale;

interface GUIHandler {
    GUIHandler SetNext(GUIHandler handler);

    String Handle(String request);
}

abstract class AbstractHandler implements GUIHandler {
    private GUIHandler nextHandler;

    @Override
    public GUIHandler SetNext(GUIHandler handler){
        this.nextHandler = handler;
        return handler;
    }

    @Override
    public String Handle(String request){

        if(this.nextHandler != null){
            return this.nextHandler.Handle(request);
        }
        else{
            return null;
        }
    }

}

class MouseDidClick extends AbstractHandler{

    @Override
    public String Handle(String request){
        if(request.toLowerCase(Locale.ROOT).contains("click")){
            return "Mouse Button Click Registered";
        }
        return super.Handle(request);
    }
}

class MouseDidClickButton extends  AbstractHandler{
    @Override
    public String Handle(String request){
        if(request.toLowerCase(Locale.ROOT).contains("button")){
            return "Mouse Button Click Registered and some onscreen button was clicked";
        }
        return super.Handle(request);
    }
}

class MouseDidRelease extends  AbstractHandler{
    @Override
    public String Handle(String request){
        if(request.toLowerCase(Locale.ROOT).contains("released")){
            return "Mouse Button Click Registered, some onscreen button was clicked and Mouse Button was released";
        }
        return super.Handle(request);
    }
}

class Client{
    public static void ClientCode(AbstractHandler handler){
        String[] strings = {
                "Mouse Clicked",
                "Mouse Button Clicked and some onscreen button clicked",
                "Mouse Button Clicked, some onscreen button clicked and Mouse Button Released"
        };

        for (int i = 0; i < strings.length; i++) {
            String result = handler.Handle(strings[i]);
            if(result != null){
                System.out.println(result);
            }
            else{
                System.out.println("Did not click!");
            }
        }
    }
}

public class ZadanieA{
    public static void main(String[] args){
        MouseDidClick mouseDidClick = new MouseDidClick();
        MouseDidClickButton mouseDidClickButton = new MouseDidClickButton();
        MouseDidRelease mouseDidRelease = new MouseDidRelease();

        Client.ClientCode(mouseDidClick);

    }
}