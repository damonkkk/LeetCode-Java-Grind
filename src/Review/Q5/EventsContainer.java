package Review.Q5;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an ordered container of Events stored for future handling.
 * Events are kept in the order in which they were added.
 * The container itself does not handle events; it relies on an EventHandler
 * to dispatch the events in the container to event handlers corresponding
 * to the right event kind.
 *
 * You MUST NOT change the signatures of the existing methods in the class.
 * You MUST implement the class methods below.
 */
public class EventsContainer {
    //FIXME add members
    private List<Event> events;

    public EventsContainer() {
        events = new ArrayList<>();
    }

    /**
     * Adds a new Event at the tail of the container.
     *
     * @param event The event to be added to the container
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Extracts (removes) an Event from the head of the container.
     * If the container is empty, it returns null.
     *
     * @return event The event at the head of the container, or null
     *               if the container is empty
     */
    public Event extractEvent() {
     if(events.isEmpty()){
         return null;
     }
     return events.remove(0);
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
     *
     * @param eventHandler An event handler
     * @return A list with the events that were handled (and thus extracted
     *         from the container). If no events were handled, returns an empty
     *         list.
     */
    public List<Event> handleEvents(EventHandler eventHandler) {
        List<Event> handledEvents = new ArrayList<>();
        List<Event> remainingEvents = new ArrayList<>();

        for(Event event: events){
            if (eventHandler.handleEvent(event)) {
                // Event was handled - add to handled list
                handledEvents.add(event);
            } else {
                // Event could not be handled - keep it for later
                remainingEvents.add(event);
            }
        }
        // Replace events with only the remaining ones
        events = remainingEvents;
        return handledEvents;

    }
}