# Data Structures Adventure

**Student Name:** Nishan Kadel
**Student ID:** C0913704

## Overview
This project consists of five coding challenges focused on fundamental data structures.

### 1. The Array Artifact
**Description:** A class using an array to store ancient artifacts and perform add, remove, and search operations.  
**Design Decisions:** Linear search was used for unsorted data, binary search for sorted data.  
**How to run:** Instantiate `ArtifactVault` and call its methods.

### 2. The Linked List Labyrinth
**Description:** A singly linked list to represent a path in the labyrinth.  
**Design Decisions:** Loop detection is done using Floyd's cycle-finding algorithm.  
**How to run:** Instantiate `LabyrinthPath` and add/remove locations.

### 3. The Stack of Ancient Texts
**Description:** A stack for managing scrolls with typical push, pop, and peek operations.  
**Design Decisions:** A basic stack without recursion.  
**How to run:** Instantiate `ScrollStack` and push/pop scrolls.

### 4. The Queue of Explorers
**Description:** A circular queue to manage explorers entering a temple.  
**Design Decisions:** The queue was designed to be circular to optimize space.  
**How to run:** Instantiate `ExplorerQueue` and enqueue/dequeue explorers.

### 5. The Binary Tree of Clues
**Description:** A binary tree to manage clues with traversal and search capabilities.  
**Design Decisions:** Simple insertion algorithm and three types of traversal.  
**How to run:** Instantiate `ClueTree` and insert clues.

### Assumptions:
1. Array size is fixed, and no resizing is done.
2. Binary search assumes the array is sorted.
3. All clues and artifacts are unique.
4. All explorers have unique names.

### Instructions:
To run the project, instantiate each class in your Java environment and call the relevant methods for each challenge.
