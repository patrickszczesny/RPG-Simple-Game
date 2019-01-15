package pl.sdacademy.homework.rpggame.map;

public class Board {

    private  String[][] board;

    private int tempPlaceNumber;
    private String tempPlaceName;

    private Board(String[][] board) {
        this.board = board;
            }



    public static Board build(int rows,int columns) {

        String[][] board = new String[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                board[i][j]=PlaceEnum.getRandomPlace().toString();
                }

            }
        return new Board(board);
    }
    public int getTempPlaceNumber() {
        return tempPlaceNumber;
    }

    public void setTempPlaceNumber(int tempPlaceNumber) {
        this.tempPlaceNumber = tempPlaceNumber;
    }
    public String getTempPlaceName() {
        return tempPlaceName;
    }

    public void setTempPlaceName(String tempPlaceName) {
        this.tempPlaceName = tempPlaceName;
    }

    public String[][] getBoard() {
        return board;
    }

    public void travelTo (int destination, int currentLocationNumber) {
        int rowstemp = currentLocationNumber / board[0].length;
        int coltemp = currentLocationNumber % board.length;

        if (currentLocationNumber>=0){
            if (currentLocationNumber<board.length * board[0].length){
                board[rowstemp][coltemp] = getTempPlaceName();
            }
        }

        setTempPlaceNumber(destination);
        if (destination >= 0) {
            if (destination < board.length * board[0].length) {

            rowstemp = destination / board[0].length;
            coltemp = destination % board.length;

            setTempPlaceName(board[rowstemp][coltemp]);
            board[rowstemp][coltemp] = " X ";
        } else {
                setTempPlaceName("void");
            }
    }else{
            setTempPlaceName("void");
        }
    }

    @Override
       public String toString() {
        int row = board.length;
        int col = board[0].length;


        String BoardPrint = "";

        for (int j = 0; j < col*12; j++) {

            BoardPrint += "-";

        }

        BoardPrint += "\n";


        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                int v=i*col+j;
                String s=""+v;

                for (int k=0; k<((12-board[i][j].length())/2);k++)
                {
                    s+=" ";
                }
                    s += board[i][j];
                for (int k=0; k<12-s.length();k++)
                {
                    s+=" ";
                }
                BoardPrint += ("|" + s);

            }

            BoardPrint += "|\n";

            for (int j = 0; j < col*12; j++) {

                BoardPrint += "-";

            }

            BoardPrint += "\n";

        }

        return BoardPrint;

    }
}


