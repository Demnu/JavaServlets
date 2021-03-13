public class theatre {
    seat[][] seats = new seat[8][8];
    theatre(){
        String[] letters = {"A","B","C","D","E","F","G","H"};
        for (int i = 0 ; i< 8 ; i++){
            for (int j =0 ; j<8 ; j++){
                seats[i][j] = new seat(letters[i] + "-" + (j+1),false);
            }
        }

    }

    public String showSeats(){
        String theatre ="";
        for (int i = 0 ; i< 8 ; i++){
            for (int j =0 ; j<8 ; j++){
                theatre += seats[i][j].getName() + " ";
            }
        }
        return theatre;
    }

}
