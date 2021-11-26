import java.io.*;

interface Tax{
    void calculate(String text, Double baseAmount);
}

class PolishTax implements Tax{
    @Override
    public void calculate(String text, Double baseAmount){
        System.out.println("Country: Poland");
        System.out.println("Amount: " + baseAmount);
        if(baseAmount < 50000){
            double tax = Double.parseDouble(text.substring(0, 2));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
        else{
            double tax = Double.parseDouble(text.substring(3, 5));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
    }
}
class USATax implements Tax{
    @Override
    public void calculate(String text, Double baseAmount){
        System.out.println("Country: USA");
        System.out.println("Amount: " + baseAmount);
        if(baseAmount < 50000){
            double tax = Double.parseDouble(text.substring(0, 2));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
        else{
            double tax = Double.parseDouble(text.substring(3, 5));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
    }
}
class GermanyTax implements Tax{
    @Override
    public void calculate(String text, Double baseAmount){
        System.out.println("Country: Germany");
        System.out.println("Amount: " + baseAmount);
        if(baseAmount < 50000){
            double tax = Double.parseDouble(text.substring(0, 2));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
        else{
            double tax = Double.parseDouble(text.substring(3, 5));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
    }
}

interface SupplementaryPayment{
    void calculate(String text, Double baseAmount);
}

class PolishSP implements SupplementaryPayment{
    @Override
    public void calculate(String text, Double baseAmount){
        System.out.println("Country: Poland");
        System.out.println("Amount: " + baseAmount);
        if(baseAmount < 50000){
            double tax = Double.parseDouble(text.substring(6, 8));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
        else{
            double tax = Double.parseDouble(text.substring(9, 11));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
    }
}
class USASP implements SupplementaryPayment{
    @Override
    public void calculate(String text, Double baseAmount){
        System.out.println("Country: USA");
        System.out.println("Amount: " + baseAmount);
        if(baseAmount < 50000){
            double tax = Double.parseDouble(text.substring(6, 8));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
        else{
            double tax = Double.parseDouble(text.substring(9, 11));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }    }
}
class GermanySP implements SupplementaryPayment{
    @Override
    public void calculate(String text, Double baseAmount){
        System.out.println("Country: Germany");
        System.out.println("Amount: " + baseAmount);
        if(baseAmount < 50000){
            double tax = Double.parseDouble(text.substring(6, 8));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
        else{
            double tax = Double.parseDouble(text.substring(9, 11));
            System.out.println("Tax:" + tax);
            System.out.println("Amount after tax:" + (baseAmount - (baseAmount * tax)/100) + "\n");
        }
    }
}

interface Factory{
    void getTax(Double baseAmount);
    void getSP(Double baseAmount);
}

class PolandFactory implements Factory{

    String readFileInfo(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("tax.txt"));
            String line = reader.readLine();
            reader.close();
            return line;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void getTax(Double baseAmount){
        String info = readFileInfo();
        PolishTax polishTax = new PolishTax();
        polishTax.calculate(info, baseAmount);
    }
    @Override
    public void getSP(Double baseAmount){
        String info = readFileInfo();
        PolishSP polishSP = new PolishSP();
        polishSP.calculate(info, baseAmount);
    }
}

class USAFactory implements Factory{

    String readFileInfo(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("tax.txt"));
            String line = reader.readLine();
            line = reader.readLine();
            reader.close();
            return line;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void getTax(Double baseAmount){
        String info = readFileInfo();
        USATax usaTax = new USATax();
        usaTax.calculate(info, baseAmount);
    }
    @Override
    public void getSP(Double baseAmount){
        String info = readFileInfo();
        USASP usaSP = new USASP();
        usaSP.calculate(info, baseAmount);
    }
}

class GermanyFactory implements Factory{

    String readFileInfo(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("tax.txt"));
            String line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            reader.close();
            return line;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void getTax(Double baseAmount){
        String info = readFileInfo();
        GermanyTax germanyTax = new GermanyTax();
        germanyTax.calculate(info, baseAmount);
    }
    @Override
    public void getSP(Double baseAmount){
        String info = readFileInfo();
        GermanySP germanySP = new GermanySP();
        germanySP.calculate(info, baseAmount);
    }
}

public class ZadanieB {
    public static void main(String[] args){
        Double baseAmount = 100000d;
        GermanyFactory germanyFactory = new GermanyFactory();
        germanyFactory.getTax(baseAmount);

        PolandFactory polandFactory = new PolandFactory();
        polandFactory.getSP(baseAmount);
    }
}