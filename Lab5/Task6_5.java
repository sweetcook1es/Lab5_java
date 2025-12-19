package Lab5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Task6_5 {

    // переписывает элементы из одной очереди в другую в обратном порядке
    public static <T> Queue<T> reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();  // стек для временного хранения элементов
        Queue<T> result = new LinkedList<>();  // результирующая очередь

        // перекладываем все элементы из очереди в стек
        while (!queue.isEmpty()) {
            stack.push(queue.poll());  // извлекаем из очереди и помещаем в стек
        }

        // перекладываем все элементы из стека в новую очередь
        while (!stack.isEmpty()) {
            result.offer(stack.pop());  // извлекаем из стека и помещаем в очередь
        }

        return result;
    }
}