class LinkedList {

    constructor(data) {
        this.next = null;
        this.data = data;
    }

    setNext(next) {

        this.next = next;
    }

    getNext() {

        return this.next;
    }

    getData() {

        return this.data;
    }

    printLinkedList() {

        let temp = this; 

        let result = '';

        while(temp) {

            if(temp.next) {

                result = result + temp.data + "->";

            }else {

                result = result + temp.data;
            }

            temp = temp.next;
        }

        console.log(result);
    }
}

const merge = (l1, l2) => {

    if(l1 == null) return l2;
    if(l2 == null) return l1;

    if(l1.getData() < l2.getData()) {

        let result = merge(l1.next, l2);
        l1.setNext(result);

        return l1;
    }else {

        let result = merge(l1, l2.next);
        l2.setNext(result);

        return l2;
    }
}

const mergeSortedLinkedList = () => {

    l1 = new LinkedList(1);
    l3 = new LinkedList(3);
    l5 = new LinkedList(5);

    l1.setNext(l3);
    l3.setNext(l5);

    // l1.printLinkedList();

    l2 = new LinkedList(2);
    l4 = new LinkedList(4);
    l6 = new LinkedList(6);

    l2.setNext(l4);
    l4.setNext(l6);

    // l2.printLinkedList();

    let result = merge(l1, l2);

    result.printLinkedList();
}


mergeSortedLinkedList();

