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
        if not self.root:
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

    def search_value(self, value):
        if not self.root:
            return False
        else:
            curr = self.root
            while curr:
                if curr.data == value:
                    return True
                elif value <= curr.data:
                    curr = curr.left
                else:
                    curr = curr.right
            return False

    def delete_node(self, value, replace):
        if not self.root:
            print("Not Found")
        else:
            curr = self.root
            while curr:
                if curr.data == value:
                    if replace:
                        curr.data = self.find_replacement(curr)
                        self.delete_node(curr.data, False)
                    else:
                        pass
                elif value <= curr.data:
                    curr = curr.left
                else:
                    curr = curr.right
            print("Not Found")

    def find_replacement(self, root):
        # replace with the largest value in left of root
        # if root doesn't have a left branch, replace with the smallest value in right of root
        if root.left:
            # find the largest value in the left
            root = root.left
            while root.right:
                root = root.right
            return root.data
        else:
            # find the smallest value in the right
            root = root.right
            while root.left:
                root = root.left
            return root.data

    def print_tree(self):
        if not self.root:
            print("Tree is empty")
        else:
            print(self.print_tree_recursive(self.root))

    def print_tree_recursive(self, curr):
        if curr is None:
            return ""
        else:
            return self.print_tree_recursive(curr.left) + " " + str(curr.data) + " " + self.print_tree_recursive(
                curr.right)


def main():
    tree = Tree()
    tree.print_tree()
    nodes = [1, 9, 7, 2, 5, 6, 11]
    for node in nodes:
        tree.insert_node(node)
    print(tree.search_value(11))
    print(tree.search_value(12))
    tree.print_tree()


if __name__ == '__main__':
    main()
