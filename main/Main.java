package main;

import algorithms.*;
import graph.ConnectedVertices;
import graph.Graph;
import logging.Log;


public class Main
{

    static String graphName;
    static int chromaticNumber;

    public static void main(String[] args)
    {

        int graph = 6;

        for(int i = graph; i < 7; i++)
        {
            if(i != 15)
            {
                // data setup
                graphName = i + ".txt";
                //graphName = args[0];
                Graph.read(graphName);
                ConnectedVertices.makeMatrix();
                Log.init();

                // algorithms
                UpperBound.get();
                LowerBound.get();
                //Greedy.run(Graph.getN());
                //OrderedGreedy.run();
                //LowerBoundGreedy.run();
                //DSatur.run();
                //Bipartite.run();
                //BackTracking.run();
                //BackTrackingBrown.run();
                ColoringDecision.run();
                //Cycle.run();



                Log.close();
            }
        }

    }


    public static void runProgram()
    {

        Log.init();

        Cycle.run();
        if(Cycle.getChromNum() == 0) {

            chromaticNumber = Cycle.getChromNum();
        }
        if(!TreeDetection.isTree())
        {
            Bipartite.run();
            if(!Bipartite.isBipartite())
            {
                Greedy.run(Graph.getM());
                DSatur.run();
                OrderedGreedy.run();
                chromaticNumber = getBest();
            } else {
                chromaticNumber = 2;
            }
        } else {
            chromaticNumber = 2;
        }

        System.out.println("The Chromatic number = " + chromaticNumber);

        Log.close();
    }


    public static int getBest()
    {
        int list[] = new int[4];
        list[0] = Greedy.getChrom();
        list[1] = DSatur.getChrom();
        list[2] = BackTracking.getChrom();
        list[3] = OrderedGreedy.getChrom();

        int min = list[0];

        for(int i = 0; i < list.length; i++)
        {
            System.out.println("possible chromatic number: " + list[i]);

            if (list[i] < min)
            {
                min = list[i];
            }
        }
        return min;
    }


    public static String getGraphName()
    {
        return graphName;
    }
}
