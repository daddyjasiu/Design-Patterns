import java.util.LinkedList;
import java.util.List;

abstract class Multimedia implements Cloneable{
    String name = "";
    String type = "";
    public Multimedia(){}
    public Multimedia(String name, String type){
        this.name = name;
        this.type = type;
    }
    public Multimedia Clone(){
        try {
            return (Multimedia) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void ToString(){
        System.out.println(name + " " + type);
    }
}

class Picture extends Multimedia{
    Picture(){}
    Picture(String name, String type){
        super(name, type);
    }
}
class Music extends Multimedia{
    Music(){}
    Music(String name, String type){
        super(name, type);
    }
}
class Movie extends Multimedia{
    Movie(){}
    Movie(String name, String type){
        super(name, type);
    }
}

public class ZadanieB {
    public static void main(String[] args){

        List<Multimedia> myMultimedia = new LinkedList<>();
        myMultimedia.add(new Picture("Obrazek", "Obraz"));
        myMultimedia.add(new Music("Muzyczka", "Muzyka"));
        myMultimedia.add(new Movie("Filmek", "Film"));
        List<Multimedia> myMultimediaCopy = new LinkedList<>();

        for (int i = 0; i < myMultimedia.size(); i++) {
            myMultimediaCopy.add(myMultimedia.get(i).Clone());
        }

        for (int i = 0; i < myMultimedia.size(); i++) {
            myMultimediaCopy.get(i).ToString();
        }
    }
}
