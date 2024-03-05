class TreeNode:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


class Tree:
    def __init__(self):
        self.root = None

    def create_tree(self, value):
        self.root = TreeNode(value)

    def insert_node(self, value):
        if self.root is None:
            self.create_tree(value)
        else:
            curr = self.root
            while curr:
                if value <= curr.data:  # go left
                    if curr.left:
                        curr = curr.left
                    else:
                        curr.left = TreeNode(value)
                        break
                else:
                    if curr.right:
                        curr = curr.right
                    else:
                        curr.right = TreeNode(value)
                        break

    def print_tree(self):
        if self.root is None:
            print("Tree is empty")
        else:
            print(self.print_tree_recursive(self.root))

    def print_tree_recursive(self, curr):
        if curr is None:
            return ""
        else:
            return self.print_tree_recursive(curr.left) + " " + str(curr.data) + " " + self.print_tree_recursive(curr.right)


def main():
    tree = Tree()
    nodes = [1, 9, 7, 2, 5, 6, 11]
    for node in nodes:
        tree.insert_node(node)
    tree.print_tree()


if __name__ == '__main__':
    main()
