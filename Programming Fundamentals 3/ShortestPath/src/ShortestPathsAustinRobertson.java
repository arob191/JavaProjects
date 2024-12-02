/**
 Austin Robertson
 COSC 2336-01
 Programming Assignment 7
 Due: 11/22/2024
 Submitted: 11/22/2024
 Using the WeightedGraph Class to create a graph. Using Dijkstra's algorithm to find the shortest path tree within our graph
 */

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Paths;

public class ShortestPathsAustinRobertson {

    /**
     * Main Class, Contains the main script
     *
     * Class Information:
     * - Name: ShortestPathsAustinRobertson
     * - Dependencies:
     *   - None
     * - Package: Default
     * - Inheritance: None
     *
     * Constants and Variables:
     * - Constants: None
     * - Variables:
     *   - edgesArray - Array to hold the edges of our graph
     *   - sourceVertex - Will be used as the source vertex for the shortest path tree
     *   - targetVertex - Will be used as the target vertex when finding the path from the source vertex
     *   - edgesList - A temp ArrayList which will be used when feeding the edge information from the txt file
     *   - myGraph - Our graph object created from the WeightedGraph class
     *   - tree - The shortest path tree created using Dijkstra's algorithm
     *
     * Constructors:
     * - Default constructor
     */


    public static void main(String[] args) {
        // Declare our two-dimensional array for the edges and initialize our int vertices variable
        int[][] edgesArray;
        int numberOfVertices = 0;
        // Initialize our source vertex and target vertex for when finding the shortest path
        int sourceVertex = 0;
        int targetVertex = 0;
        // Declare a edgeList that will be converted to our two-dimensional array
        List<int[]> edgesList = new ArrayList<>();
        // Initialize our scanner
        Scanner scanner = new Scanner(System.in);
        // Set the filePath of the graph file
        System.out.print("Please enter the file path: ");
        String filePath = scanner.nextLine();
        // Read all the lines from the file
        try { // Using try-catch block for IOExceptions
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            // Set the numberOfVertices
            if (!lines.isEmpty()) {
                numberOfVertices = Integer.parseInt(lines.getFirst().trim());
            }
            // Set the edgeList using the rest of the lines from the file
            for (int i = 1; i < lines.size(); i++) {
                String[] edgeParts = lines.get(i).split("\\|"); // Split at the pipe operator
                // For loop to separate each edgePart and parse to int
                for (String edge : edgeParts) {
                    String[] values = edge.split(",");
                    int[] edgeInts = new int[values.length];
                    for (int j = 0; j < values.length; j++) {
                        edgeInts[j] = Integer.parseInt(values[j].trim());
                    }
                    edgesList.add(edgeInts);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Ask User for the source and target vertex
        System.out.print("Please enter the source vertex: ");
        sourceVertex = scanner.nextInt();
        System.out.print("Please enter the target vertex: ");
        targetVertex = scanner.nextInt();

        // Set our edgesArray
        edgesArray = new int[edgesList.size()][];
        for (int i = 0; i < edgesList.size(); i++) {
            edgesArray[i] = edgesList.get(i);
        }
        // Construct our graph
        WeightedGraph<Integer> myGraph = new WeightedGraph<>(edgesArray, numberOfVertices);

        // Display the shortest path between the two vertices
        System.out.println("The Number of vertices is " + numberOfVertices);
        myGraph.printWeightedEdges();
        // Initialize our shortest path tree
        WeightedGraph<Integer>.ShortestPathTree tree = myGraph.getShortestPath(sourceVertex);
        // Print our shortest path to the target vertex
        tree.printAllPaths(targetVertex);
    }
}