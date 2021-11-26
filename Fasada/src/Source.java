import java.util.*;

class ManagementSystem{
    ArrayList<Client> ClientList = new ArrayList<Client>();

    void AddClient(Client Client_input){
        ClientList.add(Client_input);
    }

    void RemoveClient(Client Client_input){
        for (int i = 0; i < ClientList.size(); i++) {
            if(ClientList.get(i) == Client_input){
                ClientList.remove(i);
            }
        }
    }

    void PrintClientInstruments(){
        System.out.println(ClientList);
    }
};

class Client {
    ArrayList<Instrument> InstrumentList = new ArrayList<Instrument>();

    void BuyInstrument(Instrument Instrument_input){
        if(Instrument_input.IsRegistered())
            InstrumentList.add(Instrument_input);
    }
    void SellInstrument(Instrument Instrument_input){
        if(Instrument_input.IsRegistered()) {
            for (int i = 0; i < InstrumentList.size(); i++) {
                if (InstrumentList.get(i) == Instrument_input) {
                    InstrumentList.remove(i);
                }
            }
        }
    }
};

class Instrument {

    boolean Registered;;

    void Register(){
        Registered = true;
    }
    void Unregister(){
        Registered = false;
    }

    boolean IsRegistered() {
        return Registered;
    }
};

public class Source {

    ManagementSystem MS = new ManagementSystem();
    Client C = new Client();

    void AddClient(Client Client_input){
        MS.AddClient(Client_input);
    }
    void RemoveClient(Client Client_input){
        MS.RemoveClient(Client_input);
    }
    void PrintClientInstruments(){
        MS.PrintClientInstruments();
    }
    void BuyInstrument(Instrument Instrument_input){
        C.BuyInstrument(Instrument_input);
    }
    void SellInstrument(Instrument Instrument_input){
        C.SellInstrument(Instrument_input);
    }
    void IsRegistered(Instrument Instrument_input){
        Instrument_input.IsRegistered();
    }

    public static void main(String[] args)
    {
        Source input = new Source();

        input.PrintClientInstruments();
    }
}