package com.danielpark.algorithm

import java.lang.StringBuilder
import java.util.LinkedList

/**
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 * <br><br>
 * Copyright (c) op7773hons@gmail.com
 * Created by daniel on 2019-11-25
 */
object GAL {
    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    internal class Graph// constructor
        (val V: Int, val hasDirection: Boolean) {
        val adjListArray: Array<LinkedList<Int>?> = arrayOfNulls(V)

        init {

            // define the size of array as
            // number of vertices

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for (i in 0 until V) {
                adjListArray[i] = LinkedList()
            }
        }
    }

    // Adds an edge to an undirected graph
    internal fun addEdge(graph: Graph, src: Int, dest: Int) {
        // Add an edge from src to dest.
        graph.adjListArray[src]!!.add(dest)

        if (!graph.hasDirection) {
            // Since graph is undirected, add an edge from dest
            // to src also
            graph.adjListArray[dest]!!.add(src)
        }
    }

    // A utility function to print the adjacency list
    // representation of graph
    internal fun printGraph(graph: Graph) : String {
        val stringBuilder = StringBuilder()

        for (v in 0 until graph.V) {
            stringBuilder.append("Adjacency list of vertex $v\n")
            stringBuilder.append("head")
            for (pCrawl in graph.adjListArray[v]!!) {
                stringBuilder.append(" -> $pCrawl")
            }
            stringBuilder.append("\n\n")
        }

        print(stringBuilder.toString())

        return stringBuilder.toString()
    }

}
