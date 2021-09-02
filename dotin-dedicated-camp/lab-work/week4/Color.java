
    public enum Color {

        BLUE("ESTEGHLAL", 2),
        RED("PERSPOLIS", 0),
        GREEN("PAS", 1);

        public final String club;
        public final int chmpion;

        Color(String club, int chmpion){
            this.club = club;
            this.chmpion = chmpion;
        }

        public static void main(String[] args){

            for(Color x : Color.values()){
                System.out.println(x.club + "\t" + x.chmpion);
            }
        }


    }
