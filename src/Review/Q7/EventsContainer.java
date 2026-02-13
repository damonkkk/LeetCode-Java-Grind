package Review.Q7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventsContainer {
    //FIXME add members
    //强行记忆， 如果是eventContainer 我们需要用到 Queue 和 LinkedList
    Queue<Event> pending = new LinkedList<>();

    /**
     * Adds a new Event at the tail of the container.
     */
    public void addEvent(Event event) {
        // FIXME complete method
        // 简单的添加event到queue
        pending.add(event);
    }

    /**
     * Extracts (removes) an Event from the head of the container.
     * If the container is empty, it returns null.
     */
    public Event extractEvent() {
        // 提取event， 如果 这个queue 不是null 或 空
        if(pending == null || pending.isEmpty()){
            return null;
        } else {
            // queue 可以使用 poll 来返回第一个数据 （fisrt in first out）
            // 如果是map 就是 first in last out？
            return pending.poll();
        }

        // FIXME complete method
    }

    /**
     * Tries to use the given event handler to handle as many events in the
     * container as possible, by asking it to dispatch each event in the container
     * (in the order in which they were added to the container) to a handler function
     * corresponding to the event's kind.
     * Each event that can be handled in this way is removed from the container,
     * while any events for which no handling function is registered, will remain,
     * preserving the existing order of the remaining events.
     * Returns a list with the events that were handled.
     */
    public List<Event> handleEvents(EventHandler eventHandler) {
        // BFS?
        // 创建新的 list 和 queue 来保存数据
        List<Event> result = new ArrayList<>();
        Queue<Event> remain = new LinkedList<>();

        //只要 queue 不为空，那么我们就继续loop 直到loop完所有的数据
        while (!pending.isEmpty()){
            // 提取第一个数据
            Event event = pending.poll();

            // call eventHandler的method handleEvent 来尝试当前这个数据
            if(eventHandler.handleEvent(event)){
                // 尝试成功 添加到handled 的数据集 result 中
                result.add(event);
            } else{
                // 尝试失败 添加到 unhandled 的数据集中
                remain.add(event);
            }
        }
        // 不明白为什么要这么做
        pending= remain;

        // 返回handled的数据
        return result;
        // FIXME complete method
    }
}