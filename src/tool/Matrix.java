package tool;

/**
 * Created by zhangrunlin on 16/8/14.
 */
public class Matrix {

    /**
     * @param args
     */
    protected int[][]M;
    protected int column;
    protected int row;

    public Matrix()
    {
        this.column = 1;
        this.row = 1;
        M = new int[column][row];

        for(int i = 0; i < this.column; i++)
        {
            for(int j = 0; j < this.row; j++)
            {
                M[i][j] = 0;
            }
        }
    }

    public Matrix(int column, int row, int value)
    {
        this.column = column;
        this.row = row;
        M = new int[column][row];

        for(int i = 0; i < this.column; i++)
        {
            for(int j = 0; j < this.row; j++)
            {
                this.M[i][j] = value;
            }
        }
    }

    public void setM(int column, int row, int value)
    {
        M[column][row] = value;
    }

    public void displayMatrix()
    {
        for(int i = 0; i < this.column; ++i)
        {
            for(int j = 0; j < this.row; ++j)
            {
                System.out.print(M[i][j] + "\t");
            }

            System.out.println();
        }

        System.out.println();
    }

    public int[][] getM() {
        return M;
    }
}