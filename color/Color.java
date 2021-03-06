package color;

import graph.ConnectedVertices;

import java.util.Arrays;

/**
 * Class which stores the coloring of the vertices of the graph
 */

public class Color
{

    private int n;
    private int[] colorList;


    public Color(int n)
    {
        this.n = n;
        colorList = new int[n];
    }

    public void setColor(int vertex, int color)
    {
        colorList[vertex-1] = color;
    }

    public void setColorCheck(int vertex, int color)
    {
        colorList[vertex-1] = color;
        check(vertex);
    }


    public void check(int vertex) {

        int [] connVertices = ConnectedVertices.get(vertex);


        for(int i = 0; i < connVertices.length; i++)
        {
            if(getColor(connVertices[i]) == getColor(vertex))
            {
                setColorCheck(vertex, getColor(vertex) + 1);
            }
        }
    }

    public int getColor(int vertex)
    {
        return colorList[vertex-1];
    }


    public int getVertex(int color)
    {
        int max = 0;
        int j = 0;

        for(int i = 0; i < colorList.length; i++)
        {
            if(colorList[i] > max)
            {
                max = colorList[i];
                j = i;
            }
        }

        return j;
    }


    public boolean allColored()
    {
        for(int i = 0; i < colorList.length; i++)
        {
            if(colorList[i] == 0)
            {
                return false;
            }
        }

        return true;
    }

    public int[] getColorList() {

        return colorList;

    }


    public void printColorList()
    {
        for(int i = 0; i < n; i++)
        {
            System.out.println("Vertex " + (i + 1) + ":    " + colorList[i]);
        }
    }

    public int chromNum()
    {
        int max = 0;

        for(int i = 0; i < colorList.length; i++)
        {
            if(colorList[i] > max)
            {
                max = colorList[i];
            }
        }

        return max;
    }

}