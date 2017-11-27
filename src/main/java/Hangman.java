import java.security.PrivilegedExceptionAction;

public class Hangman {


    public enum Status{Started,Won,Lose}
    private String tried ;
    private int tries;
    private Status status;
    private String secret;

    public Hangman(String s,int n){
        this(s,n,"");

    }

    public Hangman(String s,int n, String hint){
        secret = s;
        tried = hint;
        status = Status.Started;
        tries = n;
    }

    public int getTries(){
        return tries;
    }

    public Status getStatus(){

        if (tries <= 0) {
            status = Status.Lose;
        }
        if(word ().equals (secret))
            status = Status.Won;
        return status;
    }

    public String word(){
        return secret.replaceAll(mask(),"_");
    }

    private String mask() {
        if ("".equals (tried)) { return ".";}
        else { return "[^"+tried+"]" ;}
    }


    public String tries(){
        return tried;
    }

    public void guess(char l){
        if (neverTryied (l))
        tried += l;
        if (wrong (l)) {
            tries --;
        }
    }

    private boolean wrong(char l) {
        return secret.indexOf (l) <0;
    }

    private boolean neverTryied(char l) {
        return tried.indexOf (l)<0;
    }


    //    public void doFoo(){
//        throw (new RuntimeException("X is outside board")) ;
//    }


}
