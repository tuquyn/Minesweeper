public class Cell {
    // the number of surrounding mines: -1 when the cell is mine
    private int num;
    // the status of cell: 0 free, 1 flagged, 2 opened
    private int status;

    public Cell() {
        this.num = 0;
        this.status = 0;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public boolean isMine(){
        if(num == -1)
            return true;
        else
            return false;
    }
    public void openCell(){
        if(status == 1)
            return;
        setStatus(2);
        if(isMine())
            gameLose();
    }
    public void gameLose(){
        // do something
    }
}