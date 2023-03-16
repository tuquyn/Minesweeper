import java.util.Random;

public class Board {
    private int size;
    private int mines;
    private Cell[][]arr;

    public Board(int size, int mines) {
        this.size = size;
        this.mines = mines;
        this.arr = new Cell[size][size];
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                this.arr[i][j] = new Cell();
        createNewBoard();
    }
    protected boolean outBoard(int x, int y){
        if(x < 0 || y < 0) return true;
        if(x >= size || y >= size) return true;
        return false;
    }
    public void createNewBoard(){
        Random rand = new Random();
        for(int i = 0; i < mines; ){
            int x = rand.nextInt(0,size);
            int y = rand.nextInt(0,size);

            if(arr[x][y].getNum() != -1){
                arr[x][y].setNum(-1);
                for(int j = -1; j <= 1; j++)
                    for(int k = -1; k <= 1; k++)
                        if((j != 0 || k != 0) && !outBoard(x+j,y+k))
                            if(!arr[x+j][y+k].isMine())
                                arr[x+j][y+k].setNum(arr[x+j][y+k].getNum()+1);
                i++;
            }
        }
    }
    public void display(){
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j].isMine() ? "x" : arr[i][j].getNum() == 0 ? "." : arr[i][j].getNum());
            }
            System.out.println();
        }
    }
    public void autoOpen(int x, int y){
        if(arr[x][y].getNum() == -1) return;
        int count = 0;
        for(int j = -1; j <= 1; j++)
            for(int k = -1; k <= 1; k++)
                if((j != 0 || k != 0) && !outBoard(x+j,y+k))
                    if(arr[x+j][y+k].getStatus() == 1) // flagged
                        count++;
        if(count == arr[x][y].getNum()) // if it is greater, dont do anything
        {
            for(int j = -1; j <= 1; j++)
                for(int k = -1; k <= 1; k++)
                    if((j != 0 || k != 0) && !outBoard(x+j,y+k))
                        if(arr[x+j][y+k].getStatus() == 0)
                            arr[x+j][y+k].openCell();
        }
    }
}
