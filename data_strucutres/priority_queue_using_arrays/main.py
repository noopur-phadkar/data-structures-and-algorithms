class PriorityQueue:
    def __init__(self):
        self.queue = []

    # Add an element to the queue with a priority
    def enqueue(self, item, priority):
        self.queue.append((item, priority))
        self.queue.sort(key=lambda x: x[1])  # Sort by priority, lowest priority first

    # Remove and return the element with the highest priority
    def dequeue(self):
        if not self.is_empty():
            return self.queue.pop(0)[0]  # Return the element with the highest priority
        else:
            return "Queue is empty"

    # Check if the queue is empty
    def is_empty(self):
        return len(self.queue) == 0

    # Get the size of the queue
    def size(self):
        return len(self.queue)

    # Peek at the front element of the queue without removing it
    def peek(self):
        if not self.is_empty():
            return self.queue[0][0]  # Return the element with the highest priority
        else:
            return "Queue is empty"

# Example usage:
pq = PriorityQueue()
pq.enqueue("Task 1", 3)  # Lower number indicates higher priority
pq.enqueue("Task 2", 1)
pq.enqueue("Task 3", 2)

print("Dequeued:", pq.dequeue())  # Output: Task 2 (highest priority)
print("Front element:", pq.peek())  # Output: Task 3
print("Queue size:", pq.size())  # Output: 2