package ta_workspace.tamrin1;

 class JustOne {
     static class CampUsers{
         String name,family;

         public CampUsers(String name, String family) {
             this.name = name;
             this.family = family;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public String getFamily() {
             return family;
         }

         public void setFamily(String family) {
             this.family = family;
         }
     }


     public static void main(String[] args) {
        JustOne.CampUsers users = new JustOne.CampUsers("MohammadReza","FathiNzehad");
         System.out.println(users.getName());
     }

}
