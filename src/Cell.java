public class Cell {
    // the number of surrounding mines: -1 when the cell is mine
    private int num;
    // the status of cell: 0 free, 1 flagged, 2 opened
    private CellStatus status;

    public Cell() {
        this.num = 0;
        this.status = CellStatus.FREE;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }
    public boolean isMine(){
        if(num == -1)
            return true;
        else
            return false;
    }

    //fail to openCell => game over
    public boolean openCell(){
        if(status == CellStatus.FLAGGED)
            return true;
        setStatus(CellStatus.OPENED);
        if(isMine())
            return false;
        else
            return true;
    }
    public void gameLose(){
        // do something
    }
}