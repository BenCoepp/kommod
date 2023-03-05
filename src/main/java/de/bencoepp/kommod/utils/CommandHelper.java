package de.bencoepp.kommod.utils;

public class CommandHelper {

    public static String execCmd(String cmd) throws java.io.IOException {
        java.util.Scanner s;
        try {
            String os = System.getProperty("os.name");
            if(os.contains("Windows")){
                s = new java.util.Scanner(Runtime.getRuntime().exec("cmd.exe /c " + cmd).getInputStream()).useDelimiter("\\A");
            }else{
                s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");

            }
        }catch (Exception e){
            s = new java.util.Scanner(e.toString());
        }
        return s.hasNext() ? s.next() : "";
    }
}
