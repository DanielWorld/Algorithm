package com.danielpark.algorithm

import java.util.ArrayList
import java.util.LinkedList

/**
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * <br></br><br></br>
 * Copyright (c) op7773hons@gmail.com
 * Created by daniel on 2019-11-27
 */
object BFSG {

    internal fun search(graph: GAL.Graph, beginVertex: Int, targetVertex: Int): List<Int> {
        var beginVertex = beginVertex
        val traverse = ArrayList<Int>()

        // Mark all the vertices as not visited(By default
        // set as false)
        val visited = BooleanArray(graph.V)

        // Create a queue for BFS
        val queue = LinkedList<Int>()

        // Mark the current node as visited and enqueue it
        visited[beginVertex] = true
        queue.add(beginVertex)

        while (queue.size != 0) {

            // Dequeue a vertex from queue and print it
            beginVertex = queue.poll()!!
            traverse.add(beginVertex)

            if (beginVertex == targetVertex) {
                return traverse
            }

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            val i = graph.adjListArray[beginVertex]!!.listIterator()
            while (i.hasNext()) {
                val n = i.next()
                if (!visited[n]) {
                    visited[n] = true
                    queue.add(n)
                }
            }
        }

        // Daniel () : 결국 찾지 못함.
        traverse.add(-1)

        return traverse
    }

    fun printResult(list: List<Int>): String {
        val stringBuilder = StringBuilder()

        stringBuilder.append("start")
        for (i in list) {
            stringBuilder.append(" -> $i")
        }
        stringBuilder.append("\n")

        return stringBuilder.toString()
    }


}
