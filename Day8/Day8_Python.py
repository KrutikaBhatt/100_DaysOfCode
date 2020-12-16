class Node:

  def __init__(self,data):
    self.data = data
    self.both = id(data)

  def __repr__(self):
    return str(self.data)


a = Node("a")
b = Node("b")
c = Node("c")
d = Node("d")

#id_map simulate object pointer values
id_map = dict()
id_map[id("a")] = a
id_map[id("b")] = b
id_map[id("c")] = c
id_map[id("d")] = d


class XORLinkedList:

  def __init__(self,node):

    self.head = node
    self.tail = node
    self.head.both = 0
    self.tail.both = 0

  def add(self,element):

    self.tail.both ^= id(element.data)
    element.both = id(self.tail.data)
    self.tail = element

  def get(self, index):

    prev_node_address = 0
    result_node = self.head
    
    for i in range(index):
      next_node_address = prev_node_address ^ result_node.both
      prev_node_address = id(result_node.data)
      result_node = id_map[next_node_address]
    return result_node.data

llist = XORLinkedList(c)
llist.add(d)
llist.add(b)
llist.add(a)

print(llist.get(0) == "c")
print(llist.get(1) == "d")
print(llist.get(2) == "b")
print(llist.get(3) == "a")
