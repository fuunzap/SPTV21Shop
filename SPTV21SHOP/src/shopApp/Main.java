package shopApp;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        if(args.length > 0 && "base".equals(args[0])){
            App.saveToBase = true;
        }else{
            App.saveToBase = false;
        }
        App app = new App();
        app.run();
    }
}