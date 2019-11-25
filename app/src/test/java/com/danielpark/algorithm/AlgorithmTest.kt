package com.danielpark.algorithm

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AlgorithmTest {

    @Test
    fun graph_adjacency_list() {
        val V = 5
        val graph = GAL.Graph(V)
        GAL.addEdge(graph, 0, 1)
        GAL.addEdge(graph, 0, 4)
        GAL.addEdge(graph, 1, 2)
        GAL.addEdge(graph, 1, 3)
        GAL.addEdge(graph, 1, 4)
        GAL.addEdge(graph, 2, 3)
        GAL.addEdge(graph, 3, 4)

        // print the adjacency list representation of
        // the above graph
        GAL.printGraph(graph)

        assertEquals(4, 2 + 2)
    }

    @Test
    fun graph_adjacency_matrix() {
        val V = 5
        val graph = GAM.Graph(V)
        GAM.addEdge(graph, 0, 1)
        GAM.addEdge(graph, 0, 4)
        GAM.addEdge(graph, 1, 2)
        GAM.addEdge(graph, 1, 3)
        GAM.addEdge(graph, 1, 4)
        GAM.addEdge(graph, 2, 3)
        GAM.addEdge(graph, 3, 4)

        // print the adjacency list representation of
        // the above graph
        GAM.printGraph(graph)

        assertEquals(4, 2 + 2)
    }
}
