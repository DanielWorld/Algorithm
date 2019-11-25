package com.danielpark.algorithm

/**
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 * <br><br>
 * Copyright (c) op7773hons@gmail.com
 * Created by daniel on 2019-11-25
 */
object GAM  {

    internal class Graph(val V: Int) {
        // Consider there are [V][V] -> 0
        val matrix = Array(V) {Array(V) {0} }
    }

    internal fun addEdge(graph: Graph, src:Int, dest: Int) {
        graph.matrix[src][dest] = 1

        // This graph exist for undirected graph
        graph.matrix[dest][src] = 1
    }

    internal fun printGraph(graph: Graph) {

        for (i in 0 until graph.V) {
            System.out.println("Adjacency matrix of vertex $i")
            for ((j, value) in graph.matrix[i].withIndex()) {
                print(" -> [$i, $j] = $value")
            }
            println("\n")
        }
    }

}