class Queue:
    def __init__(self):
        self.queue = []

    # Add an element to the queue
    def enqueue(self, item):
        self.queue.append(item)

    # Remove an element from the queue
    def dequeue(self):
        if not self.is_empty():
            return self.queue.pop(0)
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
            return self.queue[0]
        else:
            return "Queue is empty"

# Example usage:
q = Queue()
q.enqueue(1)
q.enqueue(2)
q.enqueue(3)

print("Dequeued:", q.dequeue())  # Output: 1
print("Front element:", q.peek())  # Output: 2
print("Queue size:", q.size())  # Output: 2