"""
This problem was asked by Google.
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, 
and deserialize(s), which deserializes the string back into the tree.

Serialization is to store tree in a file so that it can be later restored. The structure of tree must be maintained. 
Deserialization is reading tree back from file.

For example, given the following Node class
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:
node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

"""
import json

class Node:

	def __init__(self,val,left = None,right = None):
		self.val = val
		self.left = left
		self.right = right
		self.serializedTree = dict()

	def __str__(self):

		string = "< " + str(self.val) +","+ str(self.left) +","+ str(self.right)+" >"
		return string

def serializeNode(node):
    node.serializedTree["val"] = node.val

    if node.left != None:
        node.serializedTree["left"] = serializeNode(node.left)
    else:
        node.serializedTree["left"] = None

    if node.right != None:
        node.serializedTree["right"] = serializeNode(node.right)
    else:
        node.serializedTree["right"] = None

    return node.serializedTree

def serialize(node):
	# converts a Python object into a json string. 
    return json.dumps(serializeNode(node))

def deserialize(s) : 

	# json.loads() method can be used to parse a valid JSON string and convert it into a Python Dictionary.
	nodejson = json.loads(s)

	#If the given dictionery has right as well as left node
	if(nodejson["left"] != None and nodejson["right"] !=None):
		return Node(nodejson["val"], deserialize(json.dumps(nodejson["left"])), deserialize(json.dumps(nodejson["right"])))

	# It has only left node
	elif(nodejson["left"]!=None):
		return Node(nodejson["val"], deserialize(json.dumps(nodejson["left"])),None)

	# Only has right node
	elif(nodejson["right"]!=None):
		return Node(nodejson["val"],None,deserialize(json.dumps(nodejson["right"])))

	else:

		return Node(nodejson["val"])


if __name__ == "__main__":
	n = Node('root', Node('left', Node('left.left')), Node('right'))
	print("The serialized Tree :")
	print(serialize(n))
	print("The deserialize Tree :\n")
	print(deserialize(serialize(n)))





