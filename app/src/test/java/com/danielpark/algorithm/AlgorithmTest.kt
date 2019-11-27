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
        val graph = GAL.Graph(V, false)
        GAL.addEdge(graph, 0, 1)
        GAL.addEdge(graph, 0, 4)
        GAL.addEdge(graph, 1, 2)
        GAL.addEdge(graph, 1, 3)
        GAL.addEdge(graph, 1, 4)
        GAL.addEdge(graph, 2, 3)
        GAL.addEdge(graph, 3, 4)

        // print the adjacency list representation of
        // the above graph
        val printResult = GAL.printGraph(graph)

        assertEquals("Adjacency list of vertex 0\n" +
                "head -> 1 -> 4\n" +
                "\n" +
                "Adjacency list of vertex 1\n" +
                "head -> 0 -> 2 -> 3 -> 4\n" +
                "\n" +
                "Adjacency list of vertex 2\n" +
                "head -> 1 -> 3\n" +
                "\n" +
                "Adjacency list of vertex 3\n" +
                "head -> 1 -> 2 -> 4\n" +
                "\n" +
                "Adjacency list of vertex 4\n" +
                "head -> 0 -> 1 -> 3\n" +
                "\n", printResult)
    }

    @Test
    fun graph_directed_adjacency_list() {
        val graph = GAL.Graph(4, true)
        GAL.addEdge(graph, 0, 1)
        GAL.addEdge(graph, 0, 2)
        GAL.addEdge(graph, 1, 2)
        GAL.addEdge(graph, 2, 0)
        GAL.addEdge(graph, 2, 3)
        GAL.addEdge(graph, 3, 3)

        val printResult = GAL.printGraph(graph)

        assertEquals("Adjacency list of vertex 0\n" +
                "head -> 1 -> 2\n" +
                "\n" +
                "Adjacency list of vertex 1\n" +
                "head -> 2\n" +
                "\n" +
                "Adjacency list of vertex 2\n" +
                "head -> 0 -> 3\n" +
                "\n" +
                "Adjacency list of vertex 3\n" +
                "head -> 3\n" +
                "\n", printResult)
    }

    @Test
    fun graph_adjacency_matrix() {
        val V = 5
        val graph = GAM.Graph(V, false)
        GAM.addEdge(graph, 0, 1)
        GAM.addEdge(graph, 0, 4)
        GAM.addEdge(graph, 1, 2)
        GAM.addEdge(graph, 1, 3)
        GAM.addEdge(graph, 1, 4)
        GAM.addEdge(graph, 2, 3)
        GAM.addEdge(graph, 3, 4)

        // print the adjacency list representation of
        // the above graph
        val printResult = GAM.printGraph(graph)

        assertEquals("Adjacency matrix of vertex 0\n" +
                " -> [0, 0] = 0 -> [0, 1] = 1 -> [0, 2] = 0 -> [0, 3] = 0 -> [0, 4] = 1\n" +
                "\n" +
                "Adjacency matrix of vertex 1\n" +
                " -> [1, 0] = 1 -> [1, 1] = 0 -> [1, 2] = 1 -> [1, 3] = 1 -> [1, 4] = 1\n" +
                "\n" +
                "Adjacency matrix of vertex 2\n" +
                " -> [2, 0] = 0 -> [2, 1] = 1 -> [2, 2] = 0 -> [2, 3] = 1 -> [2, 4] = 0\n" +
                "\n" +
                "Adjacency matrix of vertex 3\n" +
                " -> [3, 0] = 0 -> [3, 1] = 1 -> [3, 2] = 1 -> [3, 3] = 0 -> [3, 4] = 1\n" +
                "\n" +
                "Adjacency matrix of vertex 4\n" +
                " -> [4, 0] = 1 -> [4, 1] = 1 -> [4, 2] = 0 -> [4, 3] = 1 -> [4, 4] = 0\n" +
                "\n", printResult)
    }

    @Test
    fun graph_breadth_first_search() {
        val graph = GAL.Graph(4, true)
        GAL.addEdge(graph, 0, 1)
        GAL.addEdge(graph, 0, 2)
        GAL.addEdge(graph, 1, 2)
        GAL.addEdge(graph, 2, 0)
        GAL.addEdge(graph, 2, 3)
        GAL.addEdge(graph, 3, 3)

        assertEquals("start -> 0\n",
                BFSG.printResult(BFSG.search(graph, 0, 0)))
        

        assertEquals("start -> 0 -> 1\n",
                BFSG.printResult(BFSG.search(graph, 0, 1)))
        

        assertEquals("start -> 0 -> 1 -> 2\n",
                BFSG.printResult(BFSG.search(graph, 0, 2)))
        

        assertEquals("start -> 0 -> 1 -> 2 -> 3\n",
                BFSG.printResult(BFSG.search(graph, 0, 3)))
        

        assertEquals("start -> 1 -> 2 -> 0\n",
                BFSG.printResult(BFSG.search(graph, 1, 0)))
        

        assertEquals("start -> 1\n",
                BFSG.printResult(BFSG.search(graph, 1, 1)))
        

        assertEquals("start -> 1 -> 2\n",
                BFSG.printResult(BFSG.search(graph, 1, 2)))
        

        assertEquals("start -> 1 -> 2 -> 0 -> 3\n",
                BFSG.printResult(BFSG.search(graph, 1, 3)))
        

        assertEquals("start -> 2 -> 0\n",
                BFSG.printResult(BFSG.search(graph, 2, 0)))
        

        assertEquals("start -> 2 -> 0 -> 3 -> 1\n",
                BFSG.printResult(BFSG.search(graph, 2, 1)))
        

        assertEquals("start -> 2\n",
                BFSG.printResult(BFSG.search(graph, 2, 2)))
        

        assertEquals("start -> 2 -> 0 -> 3\n",
                BFSG.printResult(BFSG.search(graph, 2, 3)))
        

        assertEquals("start -> 3 -> -1\n",
                BFSG.printResult(BFSG.search(graph, 3, 0)))
        

        assertEquals("start -> 3 -> -1\n",
                BFSG.printResult(BFSG.search(graph, 3, 1)))
        

        assertEquals("start -> 3 -> -1\n",
                BFSG.printResult(BFSG.search(graph, 3, 2)))
        

        assertEquals("start -> 3\n",
                BFSG.printResult(BFSG.search(graph, 3, 3)))
        
    }
}
