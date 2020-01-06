package divide_conquer;

/**
 *
 * @author Maksim Sandybekov
 */
public class TuermeHanoi {

    private int towers;
    private int disks;
    private int[][] game;

    public TuermeHanoi() {
        this.disks = 3;
        this.towers = 3;
        this.game = new int[towers][disks];
        this.initGame();
    }

    public TuermeHanoi(int scheiben) {
        this.towers = 3;
        this.disks = scheiben;
        this.game = new int[towers][disks];
        this.initGame();
    }

    public TuermeHanoi(int towers, int disks) {
        this.towers = towers;
        this.disks = disks;
        this.game = new int[towers][disks+1]; // Oberster index der zuletzt eingetragene wert
        this.initGame();
    }


    public int solve() {

        int[][] game = this.getGame();
        int moveTo = game[0].length -1;

        return 0;
    }


    public int recurse() {


        return 0;
    }


    // --------------------------
    // ---------- Utilities
    // --------------------------

    private void initGame() {

        int disks = this.getDisks();
        int towers = this.getTowers();
        int[][] game = this.getGame();

        if (disks < 1 || towers < 1) {
            throw new IllegalArgumentException("Can't have less than 1-Tower or 1-Disk!");
        }

        // Set all disks in first line
        for (int i = 0; i < game.length; i++) {

            // Set values of first tower
            for (int j = game[i].length-1; j > 0; j--) {
                game[i][j] = disks--;
            }

            game[i][0] = disks+1;
            break;
        }
    }


    public String toString() {

        int[][] game = this.getGame();
        boolean firstLine = true;
        String field = "";
        String divider = "---".repeat(game[0].length);

        for (int i = 0; i < game.length; i++) {

            field += "| ";
            for (int j = 0; j <  game[i].length; j++) {
                field += game[i][j] + " | ";
            }

            if (firstLine) {
                field += "\n" + divider;
                firstLine = false;
            }

            field += "\n";
        }

        return field;
    }


    // --------------------------
    // ---------- Setter/-Getter
    // --------------------------

    public int getTowers() {
        return towers;
    }

    public int getDisks() {
        return disks;
    }

    public int[][] getGame() {
        return game;
    }

    public void setTowers(int towers) {
        this.towers = towers;
    }

    public void setDisks(int disks) {
        this.disks = disks;
    }

    public void setGame(int[][] game) {
        this.game = game;
    }
}
