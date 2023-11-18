public class LifeSimulator {
    private int sizeX;
    private int sizeY;
    private int[][] grid;
    public LifeSimulator(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.grid = new int[sizeX][sizeY];

        //test hardcode vals
        this.grid[0][0] = 1;
    }

    public int getSizeX() {
        return this.sizeX;
    }
    public int getSizeY() {
        return this.sizeY;
    }
    public boolean getCell(int x, int y) {
        if (this.grid[x][y] == 0){
            return false;
        }else{
            return true;
        }
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {

    }
    //This function returns how many live neighbors a cell has
    private int checkNeighbors(int posX, int posY){
        int count = 0;
        for (int i = 0; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (this.grid[posX + i][posY + j] == 1){
                    if (i == 0 & j == 0){
                        //Dont add to count
                    }
                    else {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public void update() {
        for (int i = 0; i < this.sizeX; i++){
            for (int j = 0; j < this.sizeY; j++){
                if (this.grid[i][j]== 1) {
                    if (checkNeighbors(i, j) < 2) {
                        this.grid[i][j] = 0;
                    } else if (checkNeighbors(i, j) > 3) {
                        this.grid[i][j] = 0;
                    } else if (checkNeighbors(i, j) == 2) {
                        this.grid[i][j] = 1;
                    } else if (checkNeighbors(i, j) == 3) {
                        this.grid[i][j] = 1;
                    }
                }else {
                    if (checkNeighbors(i, j) == 3) {
                        this.grid[i][j] = 1;
                    }
                }

            }
        }
        //Rules
        //1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
        //2. Any live cell with two or three live neighbours lives on to the next generation.
        //3. Any live cell with more than three live neighbours dies, as if by overpopulation.
        //4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
    }
};