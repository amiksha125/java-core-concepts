package interfaces;

public interface Utils {

       static int min(int a, int b){
            if( a < b){
                return a;
            }
            return b;
        }

       static int max(int a, int b){
            if( a < b){
                return b;
            }
            return a;
        }

     static String trimAndUppercase(String str){
            if(str != null){
                str.trim().toUpperCase() ;
            }
            return null;
        }



}
