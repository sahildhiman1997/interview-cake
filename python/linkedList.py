class ListNode:
    def __init__(self, value):
         self.value = value
         self.next = None
         return
    

node1 = ListNode(1)
node2 = ListNode(12)


node1.next = node2
print(node1.next.value)