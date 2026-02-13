package Review.Q7;

import java.util.HashMap;
import java.util.function.Consumer;

public class EventHandler {
    //FIXME add members
    // 强行记住 如果是eventhanlder 就用 HashMap， 先initialize 一个 map， key和 value 就是题目给定的两个type的 arguments
    HashMap<String,Consumer<Event>> map = new HashMap<>();

    /**
     * Associates an event kind to an event handler function. If the
     * event kind is already associated with an event handler function,
     * the existing event handler function is replaced by the
     * one provided in this method.
     */
    public void registerEventHandlerFunction(String eventKind, Consumer<Event> handlerFunction) {
        // FIXME complete method
        // register 为默认为 map。put 把他们添加进去，不管他有没有就put， 如果有put会把它replace掉， 如果没有就创建新的
       map.put(eventKind,handlerFunction);
    }

    /**
     * Removes the association among an event kind and an event handler
     * function. If the event kind is already associated with an event handler
     * function, then the existing event handler function is returned by the
     * method. Otherwise, the method returns null.
     */
    public Consumer<Event> unregisterEventHandlerFunction(String eventKind) {
        // 在eventhandler里要用到containsKey来查找
        if(map.containsKey(eventKind)){
            return null;
        }
        // map的remove 同样会保留被remove的东西，然后我们就可以用作return
        return map.remove(eventKind);
    }

    /**
     * Given an event, tries to dispatch the event to the event handler function
     * associated with the event's kind.
     * If the event kind is associated to an event handler function, that function
     * is called with the event as an argument, and handleEvent returns true.
     * Otherwise, nothing happens, and handleEvent returns false.
     */
    public boolean handleEvent(Event event) {
        // 先确定 event的kind， 用给定的数据
        String eventKind = event.kind();
        //如果这个map不包含这个 event的eventkind，返回错误
        if(!map.containsKey(eventKind)){
            return false;
        } else{
            // 如果map包含这个event的event kind， 我们先把这个event kind 提取出来
            // 这个题目给定的是 Comsumer<Event>， 所以我们创建一个新的 instance 来存储
            Consumer<Event> handler = map.get(eventKind);
            // 然后 这一步就是 handle event， 用 handler。accept这个event
            handler.accept(event);
            return true;
        }
        // FIXME complete method
    }
}