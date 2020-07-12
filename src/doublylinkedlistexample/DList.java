/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlistexample;

/**
 *
 * @author Enubs
 */
public class DList<E> {

    private DNode<E> header, trailer;
    private int size;

    private DList() {
        header = new DNode<>(null, null, null);
        trailer = new DNode<>(header, null, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    private void addBetween(DNode<E> prev, E element, DNode<E> next) {
        DNode<E> newNode = new DNode<>(prev, element, next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
    }

    public void addFirst(E element) {
        addBetween(header, element, header.getNext());
    }

    public void addLast(E element) {
        addBetween(trailer.getPrev(), element, trailer);
    }

    public E remove(DNode<E> node) {
        DNode<E> prev = node.getPrev();
        DNode<E> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return node.getElement();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

}
