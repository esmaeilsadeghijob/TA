public class CheckTryCatch {
    public boolean chechTheCharacters (String string){
        if (string.length() == 0)
            throw new NullPointerException("Error Null Parameter");
        else if(string.length() > 4)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
    CheckTryCatch checkTryCatch = new CheckTryCatch();
    checkTryCatch.chechTheCharacters("");
    }
}
