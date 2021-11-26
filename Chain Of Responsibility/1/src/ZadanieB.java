import java.util.ArrayList;
import java.util.List;

abstract class Observer {
    protected Subject subject;
    public abstract void Update();
}

class Subject {

    private List<Observer> observers = new ArrayList<>();
    private String state;

    public String GetState() {
        return state;
    }

    public void SetState(String state) {
        this.state = state;
        NotifyAllObservers();
    }

    public void Attach(Observer observer){
        observers.add(observer);
    }

    public void NotifyAllObservers(){
        for (Observer observer : observers) {
            observer.Update();
        }
    }
}

class MouseClick extends Observer{

    public MouseClick(Subject subject){
        this.subject = subject;
        this.subject.Attach(this);
    }

    @Override
    public void Update() {
        System.out.println("MouseClick: " + subject.GetState());
    }
}

class MouseRelease extends Observer{
    public MouseRelease(Subject subject){
        this.subject = subject;
        this.subject.Attach(this);
    }

    @Override
    public void Update() {
        System.out.println("MouseRelease: " + subject.GetState());
    }
}

public class ZadanieB {
    public static void main(String[] args){
        Subject subject = new Subject();
        new MouseClick(subject);
        new MouseRelease(subject);

        subject.SetState("true");
        System.out.println();
        subject.SetState("false");
    }
}
