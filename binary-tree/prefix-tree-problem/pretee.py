"""
Author: Noopur Parag Phadkar

The main program and class for a prefix expression interpreter of the
PreTee language.  See prog1.pre for a full example.

Usage: python3 pretee.py source-file.pre
"""

import sys  # argv
import literal_node  # literal_node.LiteralNode
import variable_node  # variable_node.VariableNode
import assignment_node  # assignment_node.AssignmentNode
import print_node  # print_node.PrintNode
import math_node  # math_node.MathNode
import syntax_error  # syntax_error.SyntaxError
import runtime_error  # runtime_error.RuntimeError


class PreTee:
    """
    The PreTee class consists of:
    :slot srcFile: the name of the source file (string)
    :slot symTbl: the symbol table (dictionary: key=string, value=int)
    :slot parseTrees: a list of the root nodes for valid, non-commented
        line of code
    :slot lineNum:  when parsing, the current line number in the source
        file (int)
    :slot syntaxError: indicates whether a syntax error occurred during
        parsing (bool).  If there is a syntax error, the parse trees will
        not be evaluated
    """
    __slots__ = 'srcFile', 'symTbl', 'parseTrees', 'lineNum', 'syntaxError'

    # the tokens in the language
    COMMENT_TOKEN = '#'
    ASSIGNMENT_TOKEN = '='
    PRINT_TOKEN = '@'
    ADD_TOKEN = '+'
    SUBTRACT_TOKEN = '-'
    MULTIPLY_TOKEN = '*'
    DIVIDE_TOKEN = '//'
    MATH_TOKENS = ADD_TOKEN, SUBTRACT_TOKEN, MULTIPLY_TOKEN, DIVIDE_TOKEN

    def __init__(self, srcFile):
        """
        Initialize the parser.
        :param srcFile: the source file (string)
        """
        self.srcFile = srcFile
        self.symTbl = dict()
        self.parseTrees = []
        self.lineNum = 0
        self.syntaxError = False

    def __parse(self, tokens):
        """
        The recursive parser that builds the parse tree from one line of
        source code.
        :param tokens: The tokens from the source line separated by whitespace
            in a list of strings.
        :exception: raises a syntax_error.SyntaxError with the message
            'Incomplete statement' if the statement is incomplete (e.g.
            there are no tokens left and this method was called).
        :exception: raises a syntax_error.SyntaxError with the message
            'Invalid token {token}' if an unrecognized token is
            encountered (e.g. not one of the tokens listed above).
        :return: The root node of tree created from the given expression in tokens (LiteralNode, MathNode, VariableNode)
        """
        if len(tokens) == 0:
            raise syntax_error.SyntaxError('Incomplete statement' + " in Line: " + str(self.lineNum))
        if tokens[0].isdigit():
            root = literal_node.LiteralNode(int(tokens[0]))
            tokens.pop(0)
        elif tokens[0].isidentifier():
            root = variable_node.VariableNode(tokens[0], self.symTbl)
            tokens.pop(0)
        else:
            if not tokens[0] in self.MATH_TOKENS:
                raise syntax_error.SyntaxError('Invalid token ' + str(tokens[0]) + " in Line: " + str(self.lineNum))
            token = tokens[0]
            tokens.pop(0)
            root = math_node.MathNode(self.__parse(tokens), self.__parse(tokens), token)
        return root

    def parse(self):
        """
        The public parse is responsible for looping over the lines of
        source code and constructing the parseTree, as a series of
        calls to the helper function that are appended to this list.
        It needs to handle and display any syntax_error.SyntaxError
        exceptions that get raised.
        : return None
        """
        with open(self.srcFile) as file:
            for line in file:
                try:
                    self.lineNum += 1
                    if line.startswith(self.COMMENT_TOKEN) or line == '\n':
                        continue
                    line_data = line.strip('\n').split(" ")
                    if line_data[0] is self.ASSIGNMENT_TOKEN:  # create Assignment Node if line starts with '='
                        if len(line_data) == 1:
                            raise syntax_error.SyntaxError("Incomplete statement :" + " in Line: " + str(self.lineNum))
                        if not line_data[1].isidentifier():
                            raise syntax_error.SyntaxError("Incomplete statement :" + " in Line: " + str(self.lineNum))
                        right_node = self.__parse(line_data[2:])
                        variable = variable_node.VariableNode(line_data[1], self.symTbl)
                        assignment = assignment_node.AssignmentNode(variable, right_node, self.symTbl, line_data[0])
                        self.parseTrees.append(assignment)
                    elif line[0] is self.PRINT_TOKEN:  # create Assignment Node if line starts with '@'
                        if len(line_data) == 1 or line_data[1] == '\n':
                            self.parseTrees.append(print_node.PrintNode())
                        else:
                            self.parseTrees.append(print_node.PrintNode(self.__parse(line_data[1:])))
                    else:
                        raise syntax_error.SyntaxError(
                            "Invalid token " + line_data[0] + " in Line: " + str(self.lineNum))
                except syntax_error.SyntaxError as e:
                    self.syntaxError = True
                    print("*** Syntax Error:", e)

    def emit(self):
        """
        Prints an infix string representation of the source code that
        is contained as root nodes in parseTree.
        :return None
        """
        for root_node in self.parseTrees:
            print(root_node.emit())

    def evaluate(self):
        """
        Prints the results of evaluating the root notes in parseTree.
        This can be viewed as executing the compiled code.  If a
        runtime error happens, execution halts.
        :exception: runtime_error.RunTimeError may be raised if a
            parse tree encounters a runtime error
        :return None
        """
        if not self.syntaxError:
            for root_node in self.parseTrees:
                root_node.evaluate()


def main():
    """
    The main function prompts for the source file, and then does:
        1. Compiles the prefix source code into parse trees
        2. Prints the source code as infix
        3. Executes the compiled code
    :return: None
    """
    if len(sys.argv) != 2:
        print('Usage: python3 pretee.py source-file.pre')
        return

    pretee = PreTee(sys.argv[1])
    print('PRETEE: Compiling', sys.argv[1] + '...')
    pretee.parse()
    print('\nPRETEE: Infix source...')
    pretee.emit()
    print('\nPRETEE: Executing...')
    try:
        pretee.evaluate()
    except runtime_error.RuntimeError as e:
        # on first runtime error, the supplied program will halt execution
        print('*** Runtime error:', e)


if __name__ == '__main__':
    main()
