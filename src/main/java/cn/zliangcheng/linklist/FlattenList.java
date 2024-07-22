package cn.zliangcheng.linklist;

public class FlattenList {
    public Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }

    public Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            Node next = node.next;
            if (node.child != null) {
                Node child = node.child;
                Node childTail = flattenGetTail(child);
                node.child = null;
                childTail.next = next;
                node.next = child;
                child.prev = node;

                if (next != null) {
                    next.prev = childTail;
                }

                tail = childTail;
            } else {
                tail = node;
            }

            node = next;
        }

        return tail;
    }
}
