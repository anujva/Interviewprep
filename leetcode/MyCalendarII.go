package main

import "fmt"

type MyCalendarTwo struct {
	idGenerator  int
	events       []Event
	overlappings []OverlappingEvent
}

type Event struct {
	id    int
	start int
	end   int
}

type OverlappingEvent struct {
	id    int
	start int
	end   int
}

// We have overlapping events, then we will store
// the start and end of the overlap in the
// overlapping event struct and the overlapping events
// can be arranged as a bst.

func Constructor() *MyCalendarTwo {
	return &MyCalendarTwo{
		idGenerator: 0,
		events:      make([]Event, 0),
	}
}

func (this *MyCalendarTwo) Book(start int, end int) bool {
	// If a event is going to be booked, if the events slice
	// empty.. then just add
	if len(this.events) == 0 {
		// Just add the event and return
		this.events = append(this.events, Event{
			id:    this.getId(),
			start: start,
			end:   end,
		})
	} else {
		// check if there is a collision in the overlapping event array
		// if there is collision in the overlapping event array, then
		// it would mean that there is a triple booking that might
		// happen, so reject this current add.
		if this.checkOverlapping(start, end) {
			return false
		} else {
			event := Event{
				id:    this.getId(),
				start: start,
				end:   end,
			}

			// check if it overlaps with any current events..
			// and if it does.. add an overlap..
			this.findOverLapAndAddIfPresent(event)
			this.events = append(this.events, event)
		}
	}
	return true
}

func (this *MyCalendarTwo) findOverLapAndAddIfPresent(event Event) {
	for _, e := range this.events {
		if event.start >= e.start && event.start < e.end {
			if event.end <= e.end {
				// this will take care of the overlapping event that is subsumed
				// by an event
				this.overlappings = append(this.overlappings, OverlappingEvent{
					id:    this.getId(),
					start: event.start,
					end:   event.end,
				})
			} else {
				this.overlappings = append(this.overlappings, OverlappingEvent{
					id:    this.getId(),
					start: event.start,
					end:   e.end,
				})
			}
		} else if event.end > e.start && event.end <= e.end {
			// a subsumed event will never reach this block
			this.overlappings = append(this.overlappings, OverlappingEvent{
				id:    this.getId(),
				start: e.start,
				end:   event.end,
			})
		} else if e.start <= event.start && e.end >= event.end {
			// the event is subsumed
			this.overlappings = append(this.overlappings, OverlappingEvent{
				id:    this.getId(),
				start: event.start,
				end:   event.end,
			})
		}
	}
}

// checkOverlapping finds if the interval overlaps with the saved
// overlapping intervals
func (this *MyCalendarTwo) checkOverlapping(start, end int) bool {
	for _, overlap := range this.overlappings {
		if overlap.start >= start && overlap.start < end {
			return true
		} else if overlap.end > start && overlap.end < end {
			return true
		} else if overlap.start <= start && overlap.end >= end {
			return true
		}
	}
	return false
}

func (this *MyCalendarTwo) getId() int {
	id := this.idGenerator
	this.idGenerator = this.idGenerator + 1
	return id
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Book(start,end);
 */

func main() {
	obj := Constructor()
	fmt.Println(obj.Book(10, 20))
	fmt.Println(obj.Book(50, 60))
	fmt.Println(obj.Book(10, 40))
	fmt.Println(obj.Book(5, 15))
	fmt.Println(obj.Book(5, 10))
	fmt.Println(obj.Book(25, 55))
}
