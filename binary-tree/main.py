class TreeNode:
    def __init__(self, left_node, val, right_node):
        self.left_node = left_node
        self.val = val
        self.right_node = right_node

    def is_leaf(self, node):
        if node.left_node is None and node.right_node is None:
            return True
        else:
            return False


class Tree:
    def __init__(self):
        self.head = None

    def create_tree(self, val):
        self.head = TreeNode(None, val, None)

    def is_empty(self):
        return not self.head

    def insert_node(self, val):
        temp = self.head
        while temp is not temp.is_leaf():
            if val <= temp.val:
                temp = temp.left
            else:
                temp = temp.right

    def print_tree(self):
        print(self.head.val)
        if self.head.left_node:
            self.head.left_node.print_tree()
        if self.head.right_node:
            self.head.right_node.print_tree()


def main():
    tree = Tree()
    with open('input.txt', 'r') as f:   # TODO
        for val in f.readlines():
            if tree.is_empty():
                tree.create_tree(int(val))
            else:
                tree.insert_node(int(val))
    tree.print_tree()


if __name__ == '__main__':
    main()
