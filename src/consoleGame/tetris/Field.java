package consoleGame.tetris;


import java.util.ArrayList;

/**
 *  ласс Field описывает "поле клеток" игры “етрис
 */
public class Field
{
    //ширина и высота
    private int width;
    private int height;

    //матрица пол€: 1 - клетка зан€та, 0 - свободна
    private int[][] matrix;

    public Field(int width, int height)
    {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    /**
     * ћетод возвращает значение, которое содержитс€ в матрице с координатами (x,y)
     * ≈сли координаты за пределами матрицы, метод возвращает null.
     */
    public Integer getValue(int x, int y)
    {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];

        return null;
    }

    /**
     *  ћетод устанавливает переданное значение(value) в €чейку матрицы с координатами (x,y)
     */
    public void setValue(int x, int y, int value)
    {
        if (x >= 0 && x < width && y >= 0 && y < height)
            matrix[y][x] = value;
    }

    /**
     * ћетод печатает на экран текущее содержание матрицы
     */
    public void print()
    {
        //—оздаем массив, куда будем "рисовать" текущее состо€ние игры
        int[][] canvas = new int[height][width];

        // опируем "матрицу пол€" в массив
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                canvas[i][j] = matrix[i][j];
            }
        }

        // опируем фигурку в массив, только непустые клетки
        int left = Tetris.game.getFigure().getX();
        int top = Tetris.game.getFigure().getY();
        int[][] brickMatrix = Tetris.game.getFigure().getMatrix();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (top + i >= height || left + j >= width) continue;
                if (brickMatrix[i][j] == 1)
                    canvas[top + i][left + j] = 2;
            }
        }


        //¬ыводим "нарисованное" на экран, но начинаем с "границы кадра".
        System.out.println("---------------------------------------------------------------------------\n");

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                int index = canvas[i][j];
                if (index == 0)
                    System.out.print(" . ");
                else if (index == 1)
                    System.out.print(" X ");
                else if (index == 2)
                    System.out.print(" X ");
                else
                    System.out.print("???");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
    }

    /**
     * ”дал€ем заполненные линии
     */
    public void removeFullLines()
    {
        //—оздаем список дл€ хранени€ линий
        ArrayList<int[]> lines = new ArrayList<int[]>();

        // опируем все непустые линии в список.
        for (int i = 0; i <height; i++)
        {
            //подсчитываем количество единиц в строке - просто суммируем все ее значени€
            int count = 0;
            for (int j = 0; j < width; j++)
            {
                count += matrix[i][j];
            }

            //≈сли сумма строки не равно ее ширине - добавл€ем в список
            if (count != width)
                lines.add(matrix[i]);
        }

        //ƒобавл€ем недостающие строки в начало списка.
        while (lines.size()<height)
        {
            lines.add(0,new int[width]);
        }

        //ѕреобразуем список обратно в матрицу
        matrix = lines.toArray(new int[height][width]);
    }
}