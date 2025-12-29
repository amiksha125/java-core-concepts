package static_keyword;

public class Utils {

    public static int min(int a, int b){
        if( a < b){
            return a;
        }
        return b;
    }

    public static int max(int a, int b){
        if( a < b){
            return b;
        }
        return a;
    }

    public String trimAndUppercase(String str){
        if(str != null){
            str.trim().toUpperCase() ;
        }
        return null;
    }

}
