package com.company;

import java.util.Scanner;

class Node {
    public int id;
    public Node next;


    public Node(int number) {
        id = number;
        next = null;
    }
}


class CycledList {
    private Node root;
    private int size;

    public CycledList() {
        root = null;
        size = 0;
    }
    public void Add(int id) {

        if (size == 0) {

            root = new Node(id);

            root.next = root;
        } else {

            Node curr = root;
            while (curr.next != root)
                curr = curr.next;


            if (curr == root) {
                Node newKid = new Node(id);
                root.next = newKid;
                newKid.next = root;

            } else {

                Node newKid = new Node(id);
                curr.next = newKid;
                newKid.next = root;
            }
        }
    size++;
    }

    public void remove(int K) {
        Node curr = root, prev = curr;
        System.out.print("Номера ребят,которые удалились из хоровода: ");
        int id = 1;
        while (size != 0) {
            if (id == K) {
                prev.next = curr.next;
                curr.next = null;
                System.out.print(curr.id + " ");
                curr = prev.next;
                size--;
                id = 1;
            }
            if (size == 0) break;

            prev = curr;
            curr = curr.next;
            id++;
        }
        System.out.println("\n");
    }
}


public class Main {

    public static void main(String[] args) {

        System.out.println("Введите  k-ый элемент.");
        Scanner in = new Scanner(System.in);
        int K = -1;


        while (K <= 1) {
            try {
                K = Integer.parseInt(in.nextLine());

                if (K <= 1) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод!");
            }
        }


        CycledList list = new CycledList();
        for (int i = 1; i <= 64; i++) {
            for (int j = 1; j <= i; j++) {
				list.Add(j);
			}

            System.out.println("Хоровод состоит из " + i + " человек(а)");
            list.remove(K);
        }
    }
}
