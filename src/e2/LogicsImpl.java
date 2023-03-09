package e2;

public class LogicsImpl implements Logics {


    public LogicsImpl(int size, int numMines) {
    }

    @Override
    public Result reveal(Pair<Integer, Integer> position) {
        return Result.WIN;
    }
}
