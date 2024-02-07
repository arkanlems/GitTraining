public class StartMenu {

    public static void showOptions(){
        System.out.println("---------------------Welcome To GloRecipe--------------");
        System.out.println("1. Add Recipe");
        System.out.println("2. Replace Recipe");
        System.out.println("3. Show Menu");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------------------------");

        System.out.print("Input: ");
        int option = Utils.readInteger();

        switch (option){
            case 1:{
                Restaurant.addRecipe();
                showOptions();
                break;
            }
            case 2:{
                Restaurant.replaceRecipeById();
                showOptions();
                break;
            }
            case 3: {
                Restaurant.showMenu();
                showOptions();
            }
            case 4:{
                break;
            }
            default:{
                System.out.println("Please Enter A Valid Option");
                showOptions();
            }
        }
    }
}
