import heapq

class PriorityQueue:
    def __init__(self):
        self.heap = []

    # Add an element with a priority to the queue
    def enqueue(self, item, priority):
        # heapq is a min heap, so we use priority as the first element of the tuple
        heapq.heappush(self.heap, (priority, item))

    # Remove and return the element with the highest priority (lowest priority value)
    def dequeue(self):
        if not self.is_empty():
            return heapq.heappop(self.heap)[1]  # Return the item, ignoring the priority
        else:
            return "Queue is empty"

    # Check if the queue is empty
    def is_empty(self):
        return len(self.heap) == 0

    # Get the size of the queue
    def size(self):
        return len(self.heap)

    # Peek at the front element without removing it
    def peek(self):
        if not self.is_empty():
            return self.heap[0][1]  # Return the item with the highest priority
        else:
            return "Queue is empty"

# Example usage:
pq = PriorityQueue()
pq.enqueue("Task 1", 3)  # Lower priority number means higher priority
pq.enqueue("Task 2", 1)
pq.enqueue("Task 3", 2)

print("Dequeued:", pq.dequeue())  # Output: Task 2 (highest priority)
print("Front element:", pq.peek())  # Output: Task 3
print("Queue size:", pq.size())  # Output: 2